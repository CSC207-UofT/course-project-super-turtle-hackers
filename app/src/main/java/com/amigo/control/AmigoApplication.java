package com.amigo.control;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.spring.autoconfigure.cosmos.CosmosProperties;
import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.amigo.control", "com.amigo.course", "com.amigo.user"})
@EntityScan(basePackages = {"com.amigo.course", "com.amigo.user"})
@EnableReactiveCosmosRepositories(basePackages = {"com.amigo.course", "com.amigo.user"})
// @EnableJpaRepositories(basePackages =  {"com.amigo.course"})
@ComponentScan("com.amigo") // enabling component scan for same-level packages (by indicating closest common
                            // parent package)
public class AmigoApplication {
	// @Autowired
	// private AzureKeyCredential azureKeyCredential;

	// @Autowired
	// private CosmosProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(AmigoApplication.class, args);
	}
}
