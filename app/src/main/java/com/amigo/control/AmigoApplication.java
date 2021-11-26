package com.amigo.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.amigo.control", "com.amigo.course"})
@EntityScan(basePackages = {"com.amigo.course"})
@EnableJpaRepositories(basePackages =  {"com.amigo.course"})
@ComponentScan("com.amigo") // enabling component scan for same-level packages (by indicating closest common
                            // parent package)
@ConfigurationPropertiesScan("com.amigo.config")
public class AmigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigoApplication.class, args);
	}
}
