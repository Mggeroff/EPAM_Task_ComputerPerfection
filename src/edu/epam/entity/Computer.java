package edu.epam.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

public class Computer {
    private static final Logger logger = LogManager.getLogger();
    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 20;
    private static final int MAX_NUMBER_OF_COMPONENTS = 8;
    private static final String VALIDATE_NAME = "^[a-zA-Z ]+$";
    private static final String DEFAULT_NAME = "Client ";
    private static final String DELIMITER = "--------------------------------";
    private int price;
    private String computerName;
    private int numberOfComputers;
    private List<PartType> components = new ArrayList<>();
    private ComputerCaseType computerCaseType;

    public Computer(String computerName, int numberOfComputers, int orderNumber) {
        if (computerName.matches(VALIDATE_NAME) && computerName.length() <= MAX_SIZE && computerName.length() >= MIN_SIZE) {
            this.computerName = computerName;
        } else {
            this.computerName = DEFAULT_NAME + orderNumber;
        }
        this.numberOfComputers = numberOfComputers;
    }

    public Computer addComponent(PartType component) {
        if (components.size() > MAX_NUMBER_OF_COMPONENTS) {
            // TODO: refactor this to throw exception when the limit is reached
            logger.info("Too much components");
        }
        components.add(component);
        price += component.getPrice();
        return this;
    }

    protected void setComputerCaseType(ComputerCaseType computerCaseType) {
        price += computerCaseType.getPrice();
        this.computerCaseType = computerCaseType;
    }

    void changeName(String updatedName) {
        this.computerName = updatedName;
    }

    public void changeAmount(int updatedAmount) {
        this.numberOfComputers = updatedAmount;
    }

    @Override
    public String toString() {
        try (Formatter formatter = new Formatter()) {
            formatter.format("%s%s%n", "Название: ", computerName);
            formatter.format("%s%n", DELIMITER);
            formatter.format("%-20s%10s%2s%n", computerCaseType.getCaseName(), computerCaseType.getPrice(), "$");
            for (Iterator<PartType> i = components.iterator(); i.hasNext(); ) {
                PartType partType = i.next();
                formatter.format("%-20s%10s%2s%n", partType.getPartName(), partType.getPrice(), "$");
            }
            formatter.format("%s%n", DELIMITER);
            formatter.format("%-20s%10s%2s%n", "Всего:", price, "$");
            formatter.format("%-20s%12s%n", "Кол-во:", numberOfComputers);
            formatter.format("%s%n", DELIMITER);
            return formatter.toString();
        }
    }


    public int getComputerPrice() {
        return price;
    }

    public String getComputerName() {
        return computerName;
    }

    public int getNumberOfComputers() {
        return numberOfComputers;
    }


}

