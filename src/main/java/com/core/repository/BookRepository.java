package com.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	boolean existsByTitle(String title);
	void deleteBookByTitle(String un);
	
}