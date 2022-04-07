package com.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByFinesGreaterThan(int val);
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByEmail(String email);
	
}
