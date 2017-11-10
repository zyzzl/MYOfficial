package official.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTool {

	public static Logger log = LogManager.getLogger();

	public static void info(String info) {
		log.info(info);
	}

	public static void error(String error) {
		log.error(error);
	}

}
