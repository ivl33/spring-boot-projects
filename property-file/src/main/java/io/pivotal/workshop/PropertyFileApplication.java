package io.pivotal.workshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PropertyFileApplication {

	@Value("${custom.message}")
	private String message;
	
	public static void main(String[] args) {
		SpringApplication.run(PropertyFileApplication.class, args);
	}
	
	@RequestMapping("/")
	public String greeting() {
		return message;
	}

}
