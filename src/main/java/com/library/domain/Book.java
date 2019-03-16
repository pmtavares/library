package com.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@ManyToOne
	@NotNull(message="Category can not be null")
	private BooksCategory category;
	
	private int copies;
	
	private short edition;
	
	private String country;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BooksCategory getCategory() {
		return category;
	}
	public void setCategory(BooksCategory category) {
		this.category = category;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public short getEdition() {
		return edition;
	}
	public void setEdition(short edition) {
		if(edition < 1)
		{
			this.edition = 1;
		}
		else
		{
			this.edition = edition;
		}
		
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", copies=" + copies + ", edition=" + edition + ", country=" + country + "]";
	}

	
}
