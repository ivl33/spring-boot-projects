package io.pivotal.workshop.directory.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.workshop.directory.domain.Person;
import io.pivotal.workshop.directory.repository.DirectoryRepository;

@RestController
public class DirectoryController {

	@Autowired
	private DirectoryRepository directoryRepositoriy;

	@RequestMapping(path = "/directory")
	public ResponseEntity<Iterable<Person>> findAll() {
		return ResponseEntity.ok(this.directoryRepositoriy.findAll());
	}

	@RequestMapping(path = "/directory/search")
	public ResponseEntity<?> findByEmail(@RequestParam("email") String email) {
		Optional<Person> personByEmail =  this.directoryRepositoriy.findByEmail(email);
		
		if (personByEmail.isPresent()) {
			return ResponseEntity.ok(personByEmail.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
	}
}
