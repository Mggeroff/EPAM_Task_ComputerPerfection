package edu.epam.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

public class Order {
    public static final int MIN_ORDER_LENGTH = 10000;
    public static final int MAX_ORDER_LENGTH = 100000;
    private static final String DELIMETER = "*************************";
    private final int orderNumber;
    private final int clientId;
    private Computer computer;
    private LocalTime localTime;
    private List<Computer> computers = new ArrayList<>();

    public Order(int clientId, String computerName, int numberOfComputers) {
        this.clientId = clientId;
        Random random = new Random();
        orderNumber = MIN_ORDER_LENGTH + random.nextInt(MAX_ORDER_LENGTH - MIN_ORDER_LENGTH);
        computer = new Computer(computerName, numberOfComputers, orderNumber);
        addComputers(computer, numberOfComputers);
    }

    private void addComputers(Computer computer, int numberOfComputers) {
        for (int i = 0; i < numberOfComputers; i++) {
            computers.add(computer);
        }
    }

    public Computer addComputerCase(ComputerCase computerCase) {
        this.computer.setComputerCase(computerCase);
        return this.computer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void changeNumberOfOrderedComputers(int newNumber) {
    }

    public void changeComputerName(String computerName) {
    }

    public void showInfo() {
        System.out.println("[" + orderNumber + " : "
                                   + clientId + " : "
                                   + computer.getComputerName() + " : "
                                   + computer.getNumberOfComputers() + " : "
                                   + computer.getComputerPrice()
                                   + "]");
    }

    @Override
    public String toString() {
        try (Formatter formatter = new Formatter()) {
            int finalCost = 0;
            formatter.format("%s%n", DELIMETER);
            formatter.format("%s%d%n", "Заказ: ", getOrderNumber());
            formatter.format("%s%d%n", "Клиент: ", clientId);
            for (Computer computer : computers) {
                formatter.format("%s", computer.toString());
            }
            finalCost += computer.getComputerPrice() * computer.getNumberOfComputers();
            formatter.format("%-20s%10d%2s%n", "Общая сумма:", finalCost, "$");
            formatter.format("%-20s", DELIMETER);
            return formatter.toString();
        }
    }
}
