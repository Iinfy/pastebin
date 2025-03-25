package Infy.Projects.Pastebin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PastebinApplication {

	private static Logger logger = LogManager.getLogger(PastebinApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PastebinApplication.class, args);
		logger.info("Initialization successful");
		System.out.println("Initialization successful");
	}

}
