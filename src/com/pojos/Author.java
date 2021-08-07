package com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	@Column(name="author_id")
	private Integer authorId;
	
	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the numOfBooks
	 */
	public Integer getNumOfBooks() {
		return numOfBooks;
	}

	/**
	 * @param numOfBooks the numOfBooks to set
	 */
	public void setNumOfBooks(Integer numOfBooks) {
		this.numOfBooks = numOfBooks;
	}

	@Expose
	@Column(name="author_name")
	private String authorName;
	
	@Column(name="num_of_books")
	private Integer numOfBooks;
	
}
