package com.core.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	//Books can have the same title, since book names can't be trademarked unless they're a brand, as far as I know. You can definitely have books or series with similar titles, e.g The Inheritance Trilogy(my hold for this came in 2 days ago, I set it last month, can't wait to start this weekend) vs The Inheritance Cycle. Howeer, naming a book the same as another book doesn't happen very often, since it confuses everyone and screws up marketing
	@Column(nullable = false, unique = true)
	private String title;
	
	//The author of a book.
	@Column(nullable = false)
	private String author;
		
	@Column(nullable = false, unique = true)
	private String isbn;
	
	private String description;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Catalog> catalog;
	
//	private String coverurl;
	
	
	
	
	
}