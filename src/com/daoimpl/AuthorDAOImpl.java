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

import com.dao.AuthorDao;
import com.pojos.Author;

public class AuthorDAOImpl implements AuthorDao {

StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	 
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	
	Session session = factory.openSession();  
	
	Transaction t = session.beginTransaction();
	//Method to add Data in database
	
	public void addAuthor(Author author)
	{
		
		session.save(author);
		
		t.commit();
	}
	
	
	
	//Method to get Object by id
	
	public Author getById(int id)
    {
		Author author=session.get(Author.class, id);
		
		return author;
      
    }
	
	
	//Method to update a record
	public void update(Author author)
	{
		
		session.saveOrUpdate(author);
		t.commit();
	}
	
	//Method to delete the record
	public void delete(Author author)
	{
		
		session.delete(author);
		t.commit();
	}
	
	
	
	public List<Author> getAll()
	{

		

		String hql = "FROM Author";
		Query query = session.createQuery(hql);
		List<Author> list = query.list();
		
		
		session.close();
		this.getClass().getClassLoader();
		
		return list;
	}
	
	
	
	
	
	
	
	public Integer getIdByName(String name)
	{
		Query query=session.createQuery("from Author where authorName='"+name+"'");
		
		List<Author> list=query.list();
		
		Author author=list.iterator().next();
		
		Integer id=author.getAuthorId();
		
		return id;
	}
	
	
	
	
	
	
	public Author getByName(String name)
	{
		Query query=session.createQuery("from Author where authorName='"+name+"'");
		
		List<Author> list=query.list();
		
		Author author=list.iterator().next();
	
		
		return author;
	}
	
}
