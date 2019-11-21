package io.pivotal.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pivotal.workshop.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
