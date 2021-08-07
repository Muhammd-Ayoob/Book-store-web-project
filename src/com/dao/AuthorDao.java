package com.dao;

import java.util.List;

import com.pojos.Author;

public interface AuthorDao {

	public void addAuthor(Author author);
	
	public Author getById(int id);
	
	public void update(Author author);
	
	public void delete(Author author);
	
	public List<Author> getAll();
	
	public Integer getIdByName(String name);
	
	public Author getByName(String name);
}
