package edu.epam.reader;

import edu.epam.entity.ComputerCaseType;
import edu.epam.entity.Order;
import edu.epam.entity.PartType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceReader {
    private static final int CLIENT_NUMBER_POSITION = 0;
    private static final int COMPUTER_NAME_POSITION = 1;
    private static final int NUMBER_OF_COMPUTERS_POSITION = 2;
    private static final String DEFAULT_FILE_PATH = "data/";
    private static final String DATA_DELIMITER = "\\s+";
    private static Logger logger = LogManager.getLogger();

    public List<Order> readOrderInfo(String fileName) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_FILE_PATH + fileName))) {
            String data;
            while ((data = reader.readLine()) != null) {
                data = data.trim();
                orders.add(createOrder(data));
            }
        } catch (IOException ex) {
            logger.log(Level.FATAL, ex.getMessage());
        }

        return orders;
    }

    private Order createOrder(String input) {
        String[] data = input.split(DATA_DELIMITER);
        String clientId = data[CLIENT_NUMBER_POSITION];
        String computerName = data[COMPUTER_NAME_POSITION];
        String numberOfComputers = data[NUMBER_OF_COMPUTERS_POSITION];
        Order newOrder = new Order(Integer.parseInt(clientId), computerName, Integer.parseInt(numberOfComputers));
//        newOrder.addComputerCase(ComputerCaseType.PC_BLOCK).addComponent(PartType.MOTHERBOARD).addComponent(PartType.CPU).addComponent(PartType.RAM_MODULES).addComponent(PartType.HARD_DRIVE);
//        newOrder.addComputerCase(ComputerCaseType.valueOf(data[3]));
        int compCase = 3;
        int iterator = 4;
        do {
            newOrder.addComputerCase(ComputerCaseType.valueOf(data[compCase])).addComponent(PartType.valueOf(data[iterator]));
            iterator++;
        } while (iterator < data.length);
        return newOrder;
    }

}
