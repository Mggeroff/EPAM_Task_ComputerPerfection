package edu.epam.entity;

import java.time.LocalTime;
import java.util.List;

public class Order {
    private int orderNumber;
    private int clientId;
    private Computer computer;
    private int componentCount = 0;
    private LocalTime localTime;

    public Order(int clientId, String computerName, int numberOfComputers) {
        this.clientId = clientId;
        computer = new Computer(computerName, numberOfComputers);
    }


    public Computer addComputerCase(PartType part) {
        computer.addComponent(part);
        componentCount++;
        return this.computer;
    }

    public int getComputerPrice() {
        return this.computer.getPrice();
    }

    public List<String> getComputerPartName() {
        return this.computer.getPartsNames();
    }

    public void changeNumberOfOrderedComputers(int newNumber) {
        numberOfComputers = newNumber;
    }

    public void changeComputerName(String computerName) {
        this.computerName = computerName;
    }

    public void showInfo() {
        System.out.println("[" + orderNumber + " : " + clientId + " : " + computerName + " : " + numberOfComputers + "]");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n"
                               + "**************************\n"
                               + "Заказ: " + orderNumber + "\n"
                               + "Клиент: " + clientId + "\n");
        builder.append("Название: " + computerName + "\n");
        builder.append("-------------------------" + "\n");
        for (int i = 0; i < componentCount; i++) {
            builder.append(PartType.values());
        }
        builder.append("-------------------------" + "\n");
        builder.append("Всего: " + getComputerPrice() + "\n");
        builder.append("Количество: " + numberOfComputers + "\n");
        builder.append("-------------------------" + "\n");
        builder.append("Общая сумма: " + getComputerPrice() * numberOfComputers + "\n");
        return builder.toString();
    }
}
