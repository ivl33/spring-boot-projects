package io.pivotal.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
