package io.pivotal.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldActuatorApplication.class, args);
	}
}
