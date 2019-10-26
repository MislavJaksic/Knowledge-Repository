package mjaksic.Logging_Project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
	public static void main(String[] args) {
	    Logger logger = LoggerFactory.getLogger(Runner.class);
	    logger.debug("Debug-message");
	    logger.error("Error-message");
	    logger.info("Info-message");
	    logger.trace("Trace-message");
	    logger.warn("Warn-message");
	  }
}
