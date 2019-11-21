package io.pivotal.workshop.directory.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import io.pivotal.workshop.directory.controller.annotation.Audit;
import io.pivotal.workshop.directory.domain.Person;

@Repository
public class DirectoryRepository {

	@SuppressWarnings("serial")
	private List<Person> persons = new ArrayList<Person>() {
		{
			add(new Person("John S", "john@email.com", "password", new Date()));
			add(new Person("Ivan LEE", "ivan.lee@email.com", "password", new Date()));
		}
	};

	public Iterable<Person> findAll() {
		return this.persons;
	}

	public Optional<Person> findByEmail(String email) {
		return findFirstBy(p -> p.getEmail().equals(email));
	}

	@Audit
	public Optional<Person> findFirstBy(Predicate<Person> findBy) {
		return persons.stream().filter(findBy).findFirst();
	}
}
