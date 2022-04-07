package com.core.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="Users")
public class User {

	public static enum Role {
		ROLE_USER, ROLE_ADMIN // roles need to be capital and start with ROLE_
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Copy> outBooks;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String libCard;
	
	private double fines;
	
	private boolean enabled;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	

	
	
	public User() {
		this("DEF", "DEF", "DEF@DEF.com", "ABCD123", Role.ROLE_USER);

	}
	


	public User(String username, String password, String email, String libCard, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.libCard = libCard;
		this.role = role;
		this.userId = null;
		this.fines = 0;
		this.outBooks = new HashSet<Copy>();
		this.enabled = true;
	}



	public User(String name, String email, String libCard, double fines, String password) {
		super();
		this.username = name;
		this.email = email;
		this.libCard = libCard;
		this.fines = fines;
		this.userId = null;
		this.password = password;
		this.role = Role.ROLE_USER;
		this.outBooks = new HashSet<Copy>();
		this.enabled = true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fines, libCard, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email)
				&& Double.doubleToLongBits(fines) == Double.doubleToLongBits(other.fines)
				&& Objects.equals(libCard, other.libCard) && Objects.equals(username, other.username);
	}

	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Set<Copy> getOutBooks() {
		return outBooks;
	}

	public void setOutBooks(Set<Copy> outBooks) {
		this.outBooks = outBooks;
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
