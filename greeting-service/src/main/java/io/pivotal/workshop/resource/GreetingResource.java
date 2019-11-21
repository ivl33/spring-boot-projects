package io.pivotal.workshop.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.workshop.model.Employee;

@RestController
public class GreetingResource {

	@GetMapping(path = "/")
	public String greet() {
		return "Hello World";
	}

	@GetMapping(path = "/employees")
	public Employee getEmployees() {
		return new Employee("LEE", "Ivan", "Ivan.LEE@swift.com");
	}
}
