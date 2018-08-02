package edu.epam.runner;

import edu.epam.entity.Order;
import edu.epam.entity.PartType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Order orderOne = new Order(47123, "Game Computer", 3);
        orderOne.showInfo();
        orderOne.changeNumberOfOrderedComputers(5);
        orderOne.showInfo();
        orderOne.addComputerCase(PartType.MINI_PC_BLOCK)
                .addComponent(PartType.CPU)
                .addComponent(PartType.MOTHERBOARD)
                .addComponent(PartType.RAM_MODULES)
                .addComponent(PartType.GRAPHICS_CARD)
                .addComponent(PartType.POWER_SUPPLY)
                .addComponent(PartType.HARD_DRIVE);
        orderOne.showInfo();
        logger.info(orderOne.getComputerPrice());

        Order orderTwo = new Order(43712, "Standard PC", 2);
        orderTwo.showInfo();
        orderTwo.changeComputerName("Workstation PC");
        orderTwo.addComputerCase(PartType.PC_BLOCK)
                .addComponent(PartType.CPU)
                .addComponent(PartType.MOTHERBOARD)
                .addComponent(PartType.RAM_MODULES)
                .addComponent(PartType.GRAPHICS_CARD)
                .addComponent(PartType.POWER_SUPPLY)
                .addComponent(PartType.HARD_DRIVE)
                .addComponent(PartType.PCI_DEVICE)
                .addComponent(PartType.CD_DVD_DRIVE);
        logger.info(orderTwo.getComputerPrice());
        logger.info(orderTwo.toString());
    }
}
