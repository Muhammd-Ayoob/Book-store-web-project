package com.dao;

import java.util.List;

import com.pojos.User;

public interface UserDAO {

	public void addUser(User user);
	
	public User getById(int id);
	
	public void update(User user);
	
	public void delete(User user);		
	
	public List<User> getAll();
	
	public Integer getIdByName(String name);
	
	public User getByName(String name);
}
