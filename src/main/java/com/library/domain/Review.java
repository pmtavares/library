package com.library.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dateReview;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@NotNull(message="User can not be null")
	private Users user;
	
	@ManyToOne
	@NotNull(message="Book can not be null")
	private Book book;
	
	@Column(name="score")
	@NotNull(message="Score can not be null")
	private short score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReview() {
		return dateReview;
	}

	public void setDateReview(Date dateReview) {
		this.dateReview = dateReview;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", dateReview=" + dateReview + ", comment=" + comment + ", user=" + user + ", book="
				+ book + ", score=" + score + "]";
	}
	


}
