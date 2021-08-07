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

import com.dao.BookDAO;
import com.pojos.Book;

public class BookDAOImpl implements BookDAO {

	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  

	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	 
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	
	Session session = factory.openSession();  
	
	Transaction t = session.beginTransaction();  
	
	
	
	public void addBook(Book book)
	{
		session.save(book);
		
		t.commit();
	}
	
	
	
	public Book getById(Integer id)
	{
		Book book=session.get(Book.class, id);
		
		return book;
	}
	
	
	
	public void update(Book book)
	{
		session.saveOrUpdate(book);
		
		t.commit();
		
		System.out.println("UPDATE METHOD");
	}
	
	
	
	public void delete(Book book)
	{
		
		session.delete(book);
		
		t.commit();
	}
	
	
	
	public List<Book> getAll()
	{
		String hql = "FROM Book";
		Query query = session.createQuery(hql);
		List<Book> list = query.list();
		
		t.commit();
		session.close();
		
		return list;
	}

}
