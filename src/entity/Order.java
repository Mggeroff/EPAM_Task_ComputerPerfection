package entity;

public class Order {
    final private int orderNumber;
    private int clientId;
    private int numberOfComputers = 0;
    private String computerName;

//    private LocalTime localTime;
//    private ArrayList<Computer> computers = new ArrayList<>();

    private final int MAXSIZE = 20;
    private final int MINSIZE = 4;

    public Order(int clientId, int numberOfComputers, String computerName) {
        this.clientId = clientId;
        this.computerName = computerName;
        if (computerName.length() < MINSIZE || computerName.length() > MAXSIZE) {
            this.computerName = "Client " + this.clientId;
        } else {
            this.numberOfComputers = numberOfComputers;
        }
        this.orderNumber = 551784;
    }

    public void changeNumberOfOrderedComputers(int newNumber) {
        numberOfComputers = newNumber;
    }

    public void showInfo() {
        System.out.println("res: " + clientId + " " + numberOfComputers + " " + computerName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
