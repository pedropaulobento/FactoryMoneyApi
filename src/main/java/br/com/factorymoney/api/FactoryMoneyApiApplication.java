package br.com.factorymoney.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.factorymoney.api.config.property.FactoryApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(FactoryApiProperty.class)
public class FactoryMoneyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryMoneyApiApplication.class, args);
	}
	
}
