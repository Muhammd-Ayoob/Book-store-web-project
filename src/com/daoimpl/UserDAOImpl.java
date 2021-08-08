package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.dao.UserDAO;
import com.pojos.User;

public class UserDAOImpl implements UserDAO{

	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	 
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	
	
	  
	
	
	public void addUser(User user)
	{
		
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		
		session.save(user);
		
		
		t.commit();
		
		session.close();
	}
	
	
	public User getById(int id)
	{
		Session session = factory.openSession();  
	
		Transaction t = session.beginTransaction();
		
		User user=session.get(User.class,id);
		
		t.commit();
		
		session.close();
		return user;
	}
	
	
	
	public void update(User user)
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		session.saveOrUpdate(user);
		
		t.commit();
		
		session.close();
	}

	
	
	public void delete(User user)
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		session.delete(user);
		
		t.commit();
		
		session.close();
	}
	
	
	
	public List<User> getAll()
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		
		
		t.commit();
		
		session.close();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	public Integer getIdByName(String name)
	{
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		Query query=session.createQuery("from User where userName='"+name+"'");
		
		List<User> list=query.list();
		
		User user=list.iterator().next();
		
		Integer id=user.getUserId();
		
		t.commit();
		
		session.close();
		
		return id;
	}
	
	
	
	
	
	public User getByName(String name)
	{

		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();
		
		Query query=session.createQuery("from User where userName='"+name+"'");
		
		List<User> list=query.list();
		
		User user=list.iterator().next();
		
		
		return user;
	}
}
