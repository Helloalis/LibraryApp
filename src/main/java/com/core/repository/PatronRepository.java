package com.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.model.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Integer> {
	
	List<Patron> findByFinesGreaterThan(int val);
	
}
