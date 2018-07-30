package edu.epam.entity;

public class Order {
    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 20;
    private int orderNumber;
    private int clientId;
    private final String DEFAULT_NAME = "Client " + clientId;
    private int numberOfComputers;
    private String computerName;
    private Computer computer;
    private int componentCount = 0;
    //    private LocalTime localTime;

    public Order(int clientId, int numberOfComputers, String computerName) {
        if (computerName == null) {
            // throw exception
        }
        this.clientId = clientId;
        this.computerName = computerName;
        if (computerName.length() < MIN_SIZE || computerName.length() > MAX_SIZE) {
            this.computerName = DEFAULT_NAME;
        } else {
            this.numberOfComputers = numberOfComputers;
        }
        this.orderNumber = 551784;
        computer = new Computer();
    }


    public Computer addComputerCase(PartType part) {
        computer.addComponent(part);
        componentCount++;
        return this.computer;
    }

    public int getComputerPrice() {
        return this.computer.getPrice();
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
