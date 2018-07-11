package runner;

import entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Order orderOne = new Order(47123, 3, "Game entity.Computer");
        orderOne.changeNumberOfOrderedComputers(5);
        orderOne.showInfo();
    }
}
