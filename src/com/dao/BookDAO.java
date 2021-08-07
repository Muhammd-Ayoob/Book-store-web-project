package com.dao;

import java.util.List;

import com.pojos.Book;

public interface BookDAO {

	public void addBook(Book book);
	
	public Book getById(Integer id);
	
	public void update(Book book);
	
	public void delete(Book book);
	
	public List<Book> getAll();
}
