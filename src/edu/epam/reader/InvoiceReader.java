package edu.epam.reader;

import edu.epam.entity.ComputerCaseType;
import edu.epam.entity.Order;
import edu.epam.entity.PartType;
import edu.epam.exception.OrderException;
import edu.epam.validator.OrderInfoValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceReader {
    private static final int CLIENT_NUMBER_POSITION = 0;
    private static final int COMPUTER_NAME_POSITION = 1;
    private static final int NUMBER_OF_COMPUTERS_POSITION = 2;
    private static final String DEFAULT_FILE_PATH = "data/";
    private static final String DATA_DELIMITER = "\\s+";
    private static Logger logger = LogManager.getLogger();
    OrderInfoValidator orderInfoValidator = new OrderInfoValidator();

    public List<Order> readOrderData(String fileName) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_FILE_PATH + fileName))) {
            String data;
            while ((data = reader.readLine()) != null) {
                try {
                    data = data.trim();
                    orders.add(createOrder(data));
                } catch (OrderException e) {
                    logger.log(Level.FATAL, e);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.FATAL, ex.getMessage());
        }
        return orders;
    }

    private Order createOrder(String input) throws OrderException {
        String[] data = input.split(DATA_DELIMITER);
        int clientId = findClientNumber(data);
        int numberOfComputers = findComputersAmount(data);
        String computerName = findComputerName(data);

        Order newOrder = new Order(clientId, computerName, numberOfComputers);

        String[] computerParts = Arrays.copyOfRange(data, NUMBER_OF_COMPUTERS_POSITION + 1, data.length);
        int iterator = 1;
        do {
            if (orderInfoValidator.isComputerCaseSet(computerParts[0])) {
                newOrder.addComputerCase(ComputerCaseType.valueOf(computerParts[0])).addComponent(PartType.valueOf(computerParts[iterator]));
                iterator++;
            } else {
                throw new OrderException("Computer case is not set or found!");
            }
        } while (iterator < computerParts.length);

        return newOrder;
    }

    private int findClientNumber(String[] data) throws OrderException {
        if (orderInfoValidator.isValidCustomerId(data[CLIENT_NUMBER_POSITION])) {
            return Integer.parseInt(data[CLIENT_NUMBER_POSITION]);
        } else {
            throw new OrderException("Client Id is not found!");
        }
    }

    private String findComputerName(String[] data) {
        if (orderInfoValidator.isValidComputerName(data[COMPUTER_NAME_POSITION])) {
            return data[COMPUTER_NAME_POSITION];
        } else {
            return "";
        }
    }

    private int findComputersAmount(String[] data) throws OrderException {
        if (orderInfoValidator.isValidComputerAmount(data[NUMBER_OF_COMPUTERS_POSITION])) {
            return Integer.parseInt(data[NUMBER_OF_COMPUTERS_POSITION]);
        } else {
            throw new OrderException("Amount of computers is invalid!");
        }
    }

}
