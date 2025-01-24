package acc.br.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

	private static Logger log = LoggerFactory.getLogger(StudentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
		log.info("API server started");

	}

}
