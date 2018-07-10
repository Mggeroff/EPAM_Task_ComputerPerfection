import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello world!");
    }
}
