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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Patrons")
public class Patron {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patronId;
	
	@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Copy> outBooks;
	
	private String name;
	
	private String email;
	
	private String libCard;
	
	private double fines;

	
	
	public Patron() {
		super();
		this.patronId = null;
		this.outBooks = new HashSet<Copy>();
	}

	public Patron(String name, String email, String libCard, double fines) {
		super();
		this.name = name;
		this.email = email;
		this.libCard = libCard;
		this.fines = fines;
		this.patronId = null;
		this.outBooks = new HashSet<Copy>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fines, libCard, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patron other = (Patron) obj;
		return Objects.equals(email, other.email)
				&& Double.doubleToLongBits(fines) == Double.doubleToLongBits(other.fines)
				&& Objects.equals(libCard, other.libCard) && Objects.equals(name, other.name);
	}

	public Integer getPatronId() {
		return patronId;
	}

	public void setPatronId(Integer patronId) {
		this.patronId = patronId;
	}

	public Set<Copy> getOutBooks() {
		return outBooks;
	}

	public void setOutBooks(Set<Copy> outBooks) {
		this.outBooks = outBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLibCard() {
		return libCard;
	}

	public void setLibCard(String libCard) {
		this.libCard = libCard;
	}

	public double getFines() {
		return fines;
	}

	public void setFines(double fines) {
		this.fines = fines;
	}
	
	
	
}
