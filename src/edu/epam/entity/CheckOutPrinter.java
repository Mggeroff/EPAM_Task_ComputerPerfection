package edu.epam.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;

public class CheckOutPrinter<T> {
    private static Logger logger = LogManager.getLogger();

    public void invoiceToFile(Formatter formatter, T orderNumber) {
        try (Formatter output = new Formatter(new FileOutputStream("./invoices/" + orderNumber + ".txt"))) {
            output.format(formatter.toString());
        } catch (FileNotFoundException ex) {
            logger.log(Level.ERROR, ex.getMessage());
            logger.log(Level.ERROR, "Error occurred while processing the order.");
        }
    }
}
