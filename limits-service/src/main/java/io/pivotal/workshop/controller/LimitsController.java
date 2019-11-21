package io.pivotal.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.workshop.config.LimitsProperties;
import io.pivotal.workshop.model.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsProperties limitsProperties;

	@GetMapping(path = "/limits")
	public Limits retriveLimits() {
		return new Limits(limitsProperties.getMaximum(), limitsProperties.getMinimum());
	}
	
	@GetMapping(path = "/fault-tolerance")
	@HystrixCommand(fallbackMethod="fallbackRetrieve")
	public Limits retrivethrowsexception() {
		//invoke a another service
		throw new RuntimeException("not available");
	}
	
	public Limits fallbackRetrieve() {
		return new Limits(999, 9);
	}
}
