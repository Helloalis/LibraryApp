package com.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.model.Book;
import com.core.model.Catalog;
import com.core.model.Location;



@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

	List<Catalog> findByLocation(Location loc);
	List<Catalog> findByBook(Book bo);
	Optional<Catalog> findByLocationAndBook(Location lo, Book bo);
	boolean existsByLocationAndBook(Location lo, Book bo);
	boolean deleteByLocationAndBook(Location lo, Book bo);
}
