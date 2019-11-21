package io.pivotal.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.workshop.properties.PersonProperties;

@SpringBootApplication
@RestController
public class ConfigurationPropertiesApplication {

	final private PersonProperties personProperties;

	@Autowired
	public ConfigurationPropertiesApplication(PersonProperties personProperties) {
		this.personProperties = personProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesApplication.class, args);
	}

	@RequestMapping("/")
	public String greetings() {
		return personProperties.getGreeting() + "Spring Boot! " + personProperties.getFarewell() + "Spring Boot!" + " Count: " + personProperties.getCount();
	}

	@RequestMapping("/intrude")
	public String intrude(@Value("${person.myprop}") String value) {
		return value;
	}
}
