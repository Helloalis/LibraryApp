package com.core.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Copies")
public class Copy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer copyId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "catalogId")
	@JsonBackReference
	private Catalog catalog;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "userId")
	@JsonBackReference
	private User user;
	
	private boolean checkedOut;
	
	private LocalDate dueDate;

	
	
	public Copy() {
		super();
		this.copyId = null;
	}

	public Copy(Catalog catalog, User user, boolean checkedOut, LocalDate dueDate) {
		super();
		this.copyId = null;
		this.catalog = catalog;
		this.user = user;
		this.checkedOut = checkedOut;
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(catalog, checkedOut, dueDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Copy other = (Copy) obj;
		return Objects.equals(catalog, other.catalog) && checkedOut == other.checkedOut
				&& Objects.equals(dueDate, other.dueDate);
	}

	public Integer getCopyId() {
		return copyId;
	}

	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
}
