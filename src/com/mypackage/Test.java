package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
 
   
public class Test {    
public static void main(String[] args) {    
       
   //Create typesafe ServiceRegistry object    
   StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
         
  Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
 
SessionFactory factory = meta.getSessionFactoryBuilder().build();  
Session session = factory.openSession();  
Transaction t = session.beginTransaction();   
    
//University u= session.get(University.class, 1);

  t.commit();  
   System.out.println("CONGRATULATION!!!! YOUR HIBERNATE PROJECT IS RUNNING SUCCESFULLY!!!!"); 

   factory.close();  
   session.close();    
   
   
}        
}   

