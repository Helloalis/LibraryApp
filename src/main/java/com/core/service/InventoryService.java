package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.model.Address;
import com.core.model.Book;
import com.core.model.Catalog;
import com.core.model.Copy;
import com.core.repository.AddressRepository;
import com.core.repository.BookRepository;
import com.core.repository.CatalogRepository;
import com.core.repository.CopyRepository;

@Service
public class InventoryService {
	
	@Autowired
	CopyRepository coRepo;
	
	@Autowired
	BookRepository boRepo;
	
	@Autowired
	CatalogRepository caRepo;
	
	//Create
	
	public Book createBook(Book boo) {
		
		return boo;
	}
	
	public Catalog createCatalog(Catalog cato) {
		return cato;
	}
	
	public Copy createCopy(Copy co) {
		return co;
	}
	
	//Read
	
	

	//Update
	public Book updateBook(Book ad) {
		if(boRepo.existsByTitle(ad.getTitle())) {
			Book update = boRepo.save(ad);
			return update;
		}
		return null;
	}
		
	
	//Delete
	
	public boolean deleteBookByTitle(String title) {
		if(boRepo.existsByTitle(title)) {
			boRepo.deleteByTitle(title);
			return true;
		}
		return false;
	}
	
}
