package au.com.unico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories

public class UnicoGcdServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(UnicoGcdServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(UnicoGcdServiceApplication.class, args);
		logger.debug("--Application Started--");
	}
}
