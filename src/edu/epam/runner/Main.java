package edu.epam.runner;

import edu.epam.entity.Order;
import edu.epam.reader.InvoiceReader;
import edu.epam.util.PartsAsText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
//        Order gameComputer = new Order(47123, "Game Computer", 3);
//        gameComputer.addComputerCase(ComputerCaseType.PC_BLOCK)
//                .addComponent(PartType.MOTHERBOARD)
//                .addComponent(PartType.CPU)
//                .addComponent(PartType.GRAPHICS_CARD)
//                .addComponent(PartType.POWER_SUPPLY)
//                .addComponent(PartType.RAM_MODULES)
//                .addComponent(PartType.HARD_DRIVE);
//        logger.info(gameComputer.toString());
//
//        Order standardPc = new Order(43712, "Standard PC", 1);
//        standardPc.addComputerCase(ComputerCaseType.MINI_PC_BLOCK)
//                .addComponent(PartType.MOTHERBOARD)
//                .addComponent(PartType.CPU)
//                .addComponent(PartType.RAM_MODULES)
//                .addComponent(PartType.GRAPHICS_CARD)
//                .addComponent(PartType.POWER_SUPPLY)
//                .addComponent(PartType.HARD_DRIVE)
//                .addComponent(PartType.PCI_DEVICE)
//                .addComponent(PartType.CD_DVD_DRIVE);
//        logger.info(standardPc.toString());


        List<String> allComponents = PartsAsText.getComputerParts();
        Object[] allCompArray = allComponents.toArray();
        for (Object o : allCompArray) {
            System.out.println(o);
        }

        InvoiceReader invoiceReader = new InvoiceReader();
        List<Order> computersFromFile = invoiceReader.readOrderInfo("input.txt");
        for (Order computer : computersFromFile) {
            logger.info(computer.toString());
        }
    }

}
