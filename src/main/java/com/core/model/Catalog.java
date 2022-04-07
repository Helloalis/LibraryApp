package com.core.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "location", "book", "format" }) })
public class Catalog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catalogId;
	
	private String format;
	
	private int quantity;
	
	private int checkedOut;
	
	//Fiction, nonfiction,
	private String category;
	
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookId")
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locId")
	private Location location;
	
	@OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Copy> copies;
	

	
	public Catalog() {
		super();
		this.catalogId = null;
		this.copies = new HashSet<Copy>();
	}

	public Catalog(String format, int quantity, int checkedOut, String category, double price, Book book,
			Location location) {
		super();
		this.format = format;
		this.quantity = quantity;
		this.checkedOut = checkedOut;
		this.category = category;
		this.price = price;
		this.book = book;
		this.location = location;
		this.catalogId = null;
		this.copies = new HashSet<Copy>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalog other = (Catalog) obj;
		return Objects.equals(book, other.book) && Objects.equals(category, other.category)
				&& checkedOut == other.checkedOut && Objects.equals(format, other.format)
				&& Objects.equals(location, other.location)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, category, checkedOut, format, location, price, quantity);
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(int checkedOut) {
		this.checkedOut = checkedOut;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Copy> getCopies() {
		return copies;
	}

	public void setCopies(Set<Copy> copies) {
		this.copies = copies;
	}
	
	
	
}
