package xyz.lagosoft.ideas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EntityScan
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LagoIdeasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LagoIdeasApplication.class, args);
	}

}
