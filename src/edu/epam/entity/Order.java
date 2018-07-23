package edu.epam.entity;

public class Order {
    private final int orderNumber;
    private int clientId;
    private int numberOfComputers = 0;
    private String computerName;
    private Computer computer;
    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 20;
    private final String DEFAULT_NAME = "Client " + clientId;
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

//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }


    public Computer addComputerCase(Parts part) {
        computer.addComponent(part);
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
        return super.toString();
    }
}
