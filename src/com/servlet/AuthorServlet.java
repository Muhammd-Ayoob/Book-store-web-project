package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.daoimpl.*;
import com.google.gson.Gson;
import com.pojos.*;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AuthorServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		AuthorDao authorDao=new AuthorDAOImpl();
		
		
			
			if(action.equals("create"))
			{
			
			String name=request.getParameter("name");
			
			
			
			String number=request.getParameter("books");
			Integer books=Integer.parseInt(number);
			
		
			
			Author author=new Author();
			
			author.setAuthorName(name);
		
			author.setNumOfBooks(books);
			Gson g=new Gson();
			
			String gson=g.toJson(author);
			
			response.getWriter().print(gson);
			
			
			
			authorDao.addAuthor(author);
			
			response.getWriter().print(g.toJson("status:success"));
			
			}
	
		else if(action.equals("getAll"))
		{
			
			getAll(request, response);
		}
			
		else if(action.equals("update"))
		{
			String aid=request.getParameter("id");
			
	       Integer id=Integer.parseInt(aid);
			
			String name=request.getParameter("name");
			
			
			
			String nBooks=request.getParameter("books");
			
			Integer books=Integer.parseInt(nBooks);
			

			Author author=new Author();
			
			author.setAuthorId(id);
			
			author.setAuthorName(name);
			
			author.setNumOfBooks(books);
			
			authorDao.update(author);
			
			response.setContentType("javascript/json");
			
			Gson gson = new Gson();
			
			String obj = gson.toJson(author);
			
			response.getWriter().print(obj);
		}
			
			else if(action.equals("delete"))
			{
				String aid=request.getParameter("id");
				Integer id=Integer.parseInt(aid);
				
				Author author=authorDao.getById(id);
				
				authorDao.delete(author);
			}
			else if(action.equals("changeLocation"))
			{
				response.sendRedirect("AuthorJsp.jsp");
			}
	}
	
	
	protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
		 
		 	AuthorDao dao=new AuthorDAOImpl();
		 	
			List<Author> list=new ArrayList();
			
			list=dao.getAll();
			
			
			
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
