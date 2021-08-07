package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AuthorDao;
import com.dao.BookDAO;
import com.daoimpl.AuthorDAOImpl;
import com.daoimpl.BookDAOImpl;
import com.google.gson.Gson;
import com.pojos.Author;
import com.pojos.Book;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDao=new BookDAOImpl();
		String action= request.getParameter("action");
		
		if(action.equals("getAll"))
		{
			
			getAll(request, response);
		}
		else if(action.equals("select"))
		{
			getAuthor(request, response);
		}
		
		else if(action.equals("select1"))
		{
			getAuthor(request, response);
		}
		
		
		else if(action.equals("create"))
			{
			AuthorDao authorDao=new AuthorDAOImpl();
			Author author=new Author();
			String title=request.getParameter("title");
			
			
			String number=request.getParameter("copies");
			Integer copies=Integer.parseInt(number);
			
			String bPrice=request.getParameter("price");
			Integer price=Integer.parseInt(bPrice);
			
			
			String authors=request.getParameter("authors");
			Integer authorId=authorDao.getIdByName(authors);
			
			author.setAuthorId(authorId);
		
			
			Book book =new Book();
			
			book.setTitle(title);
		
			book.setNoOfCopies(copies);
			
			book.setPrice(price);
			
			book.setAuthor(author);
			
			Gson g=new Gson();
			
			String gson=g.toJson(book);
			
			response.getWriter().print(gson);
			
			
			
			bookDao.addBook(book);
			
			response.getWriter().print(g.toJson("status:success"));
			

		}
		
		else if(action.equals("delete"))
		{
			String bId=request.getParameter("id");
			
			System.out.println(bId);
			//Integer id=Integer.parseInt(bId);
			
			//Book book=bookDao.getById(id);
			
			//bookDao.delete(book);
		}
		else if(action.equals("update"))
		{
			AuthorDao authorDao=new AuthorDAOImpl();
			System.out.println("TETS UPADTE IS CALLING");
			String bId=request.getParameter("id");
			Integer id=Integer.parseInt(bId);
		
			
			String title=request.getParameter("title");
			
			String nCopies=request.getParameter("copies");
			Integer copies=Integer.parseInt(nCopies);
			
			//Integer books=Integer.parseInt(nBooks);
			
			String bPrice=request.getParameter("price");
			Integer price=Integer.parseInt(bPrice);
			
			String author=request.getParameter("authors");
			Integer authorId=authorDao.getIdByName(author);
			
			Author author1=new Author();
			author1.setAuthorId(authorId);
			
			Book book=new Book();
			book.setBookId(id);
			
			book.setTitle(title);
			
			book.setNoOfCopies(copies);
			
			book.setPrice(price);
			
			book.setAuthor(author1);
			
			bookDao.update(book);
			
			response.setContentType("javascript/json");
			
			Gson gson = new Gson();
			
			String obj = gson.toJson(author);
			
			response.getWriter().print(obj);
		}
		
	}
	
	
	protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
		 
		 	BookDAO dao=new BookDAOImpl();
		 	
			List<Book> list= dao.getAll();

			Gson g=new Gson();
			
			String gson=g.toJson(list);
			
			response.getWriter().print(gson);
			}
	
	protected void getAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
		 
		 	AuthorDao dao=new AuthorDAOImpl();
		 	
			List<Author> list= dao.getAll();

			Gson g=new Gson();
			
			String gson=g.toJson(list);
			
			response.getWriter().print(gson);
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
