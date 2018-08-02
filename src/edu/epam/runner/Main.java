package edu.epam.runner;

import edu.epam.entity.ComputerCase;
import edu.epam.entity.Order;
import edu.epam.entity.PartType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Order orderOne = new Order(47123, "Game Computer", 3);
        orderOne.addComputerCase(ComputerCase.PC_BLOCK)
                .addComponent(PartType.MOTHERBOARD)
                .addComponent(PartType.CPU)
                .addComponent(PartType.GRAPHICS_CARD)
                .addComponent(PartType.POWER_SUPPLY)
                .addComponent(PartType.RAM_MODULES)
                .addComponent(PartType.HARD_DRIVE);
        logger.info(orderOne.toString());
    }
}
