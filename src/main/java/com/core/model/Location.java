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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Locations")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locId;
	
	private String name;
	
	@OneToOne(mappedBy = "location", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Catalog> catalog;

	
	
	public Location() {
		super();
		this.locId = null;
		this.catalog = new HashSet<Catalog>();
	}

	public Location(String name, Address address) {
		super();
		this.locId = null;
		this.name = name;
		this.address = address;
		this.catalog = new HashSet<Catalog>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name);
	}

	public Integer getLocId() {
		return locId;
	}

	public void setLocId(Integer locId) {
		this.locId = locId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Catalog> getCatalog() {
		return catalog;
	}

	public void setCatalog(Set<Catalog> catalog) {
		this.catalog = catalog;
	}
	
	
}
