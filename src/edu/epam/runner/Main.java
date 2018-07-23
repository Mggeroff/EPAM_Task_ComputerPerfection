package edu.epam.runner;

import edu.epam.entity.Order;
import edu.epam.entity.Parts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Order orderOne = new Order(47123, 3, "Game Computer");
        orderOne.showInfo();
        orderOne.changeNumberOfOrderedComputers(5);
        orderOne.showInfo();
        orderOne.addComputerCase(Parts.MINI_PC_BLOCK)
                .addComponent(Parts.CPU)
                .addComponent(Parts.MOTHERBOARD)
                .addComponent(Parts.RAM_MODULES)
                .addComponent(Parts.GRAPHICS_CARD)
                .addComponent(Parts.POWER_SUPPLY)
                .addComponent(Parts.HARD_DRIVE);
        orderOne.showInfo();
        //System.out.println(orderOne.getComputerPrice());
        logger.info(orderOne.getComputerPrice());

        Order orderTwo = new Order(43712, 3, "Standard PC");
        orderTwo.showInfo();
        orderTwo.changeComputerName("Workstation PC");
        orderTwo.addComputerCase(Parts.PC_BLOCK)
                .addComponent(Parts.CPU)
                .addComponent(Parts.MOTHERBOARD)
                .addComponent(Parts.RAM_MODULES)
                .addComponent(Parts.GRAPHICS_CARD)
                .addComponent(Parts.POWER_SUPPLY)
                .addComponent(Parts.HARD_DRIVE)
                .addComponent(Parts.PCI_DEVICE)
                .addComponent(Parts.CD_DVD_DRIVE);
        //System.out.println(orderTwo.getComputerPrice());
        logger.info(orderTwo.getComputerPrice());
    }
}
