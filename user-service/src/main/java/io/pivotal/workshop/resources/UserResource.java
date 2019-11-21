package io.pivotal.workshop.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.pivotal.workshop.exception.UserNotFoundException;
import io.pivotal.workshop.model.User;
import io.pivotal.workshop.repository.UserRepository;

@RestController
public class UserResource {
	
	private List<User> users;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getUsers() throws JAXBException {
		users = userRepository.findAll().stream().collect(Collectors.toList());
		return users;
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id = " + id);
		}
		return user.get();
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		if (user == null) {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}

		if (user.getName() == null) {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}

		if (user.getBirthDate() == null) {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}

		User savedUser = userRepository.save(user);
		if (savedUser == null) {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody User user) {
		if (user == null) {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}

		user.setId(id);

		User updateUser = userRepository.save(user);
		if (updateUser == null) {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable Integer id) {
		try {
			userRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			return "Failed to delete user " + id;
		}
		return "User " + id + " has been deleted successfully";
	}
}
