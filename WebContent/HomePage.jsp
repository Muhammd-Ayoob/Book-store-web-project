<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.pojos.User" %>
    
    <%@ page import="com.dao.UserDAO" %>
     
     <%@ page import="com.daoimpl.UserDAOImpl" %>
      <%@ page import="java.util.*" %>
    <%@ page import ="java.io.IOException"%>
    
    <%@ page import= "javax.servlet.http.HttpServlet"%>
    
    <%@ page import= "javax.servlet.http.HttpServletRequest"%>
    <%@ page import= "javax.servlet.http.HttpServletResponse"%>
      
      
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
		  		<style type="text/css">
   		body {
    background: #222D32;
    font-family: 'Roboto', sans-serif;
}

.login-box {
    margin-top: 75px;
    height: auto;
    background: #1A2226;
    text-align: center;
    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}

.login-key {
    height: 100px;
    font-size: 80px;
    line-height: 100px;
    background: -webkit-linear-gradient(#27EF9F, #0DB8DE);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

.login-title {
    margin-top: 15px;
    text-align: center;
    font-size: 30px;
    letter-spacing: 2px;
    margin-top: 15px;
    font-weight: bold;
    color: #ECF0F5;
}

.login-form {
    margin-top: 25px;
    text-align: left;
}

input[type=text] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    outline: 0;
    margin-bottom: 20px;
    padding-left: 0px;
    color: #ECF0F5;
}

input[type=password] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    outline: 0;
    padding-left: 0px;
    margin-bottom: 20px;
    color: #ECF0F5;
}

.form-group {
    margin-bottom: 40px;
    outline: 0px;
}

.form-control:focus {
    border-color: inherit;
    -webkit-box-shadow: none;
    box-shadow: none;
    border-bottom: 2px solid #0DB8DE;
    outline: 0;
    background-color: #1A2226;
    color: #ECF0F5;
}

input:focus {
    outline: none;
    box-shadow: 0 0 0;
}

label {
    margin-bottom: 0px;
}

.form-control-label {
    font-size: 10px;
    color: #6C6C6C;
    font-weight: bold;
    letter-spacing: 1px;
}

.btn-outline-primary {
    border-color: #0DB8DE;
    color: #0DB8DE;
    border-radius: 0px;
    font-weight: bold;
    letter-spacing: 1px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.btn-outline-primary:hover {
    background-color: #0DB8DE;
    right: 0px;
}

.login-btm {
    float: left;
}

.login-button {
    padding-right: 0px;
    text-align: right;
    margin-bottom: 25px;
}

.login-text {
    text-align: left;
    padding-left: 0px;
    color: #A2A4A4;
}

.loginbttm {
    padding: 0px;
}
   </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	
	
	
		<meta charset="utf-8">
 	 <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 	 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

              <!-- Modal -->
              <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                      <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                    </div>
                    <div class="modal-body">
                      <form>
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Name</label>
						    <input type="text" class="form-control" id="uname" name="uname" >
						  </div>
						  
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Password</label>
						    <input type="password" class="form-control" id="upassword" name="upassword" >
						  </div>
						  
						   <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Email</label>
						    <input type="text" class="form-control" id="email" name="email" >
						  </div>
						  
						  
						  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      <input type="submit" class="btn btn-primary" value="Save">
                    </div>
					</form>
        
                    </div>
                    
                  </div>
                </div>
              </div>
	
	
	
	
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    JSP LOGIN PAGE
                </div>

                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form action="doGet">
                            <div class="form-group">
                                <label class="form-control-label">USERNAME</label>
                                <input name="name" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="form-control-label">PASSWORD</label>
                                <input id="password" name="password" type="password" class="form-control">
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                                    <!-- Error Message -->
                                </div>
                                <div class="col-lg-6 login-btm login-button">
                                    <input id="click" type="submit" class="btn btn-outline-primary" value="LOGIN">
                                </div>
                                
                                <div>
                                    <button style="margin-top:-110px" type="button" data-toggle="modal" data-target="#myModal" class="btn btn-outline-primary">Register</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
      </div>
        <%!UserDAO dao=new UserDAOImpl();
        
        List<User> users=dao.getAll();
        
         boolean b=false;
         %>
        
        <%!protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        
        	
       		 String name=request.getParameter("name");
        
       		 String password=request.getParameter("password");
        
        
		
		 boolean b=false;
		 if(name!=null&&password!=null)
		 {
		 
				for(User user: users)
				{
					
					if(user.getUserName().equals(name)&&user.getPassword().equals(password))
					{
						
						
						b=true;
						break;
					}
					else
					{
						b=false;
					}
				}
				
				if(b)
				{
					response.sendRedirect("Home.html");
				}
			
		 }
		}%>
        
        
        <%!  User user=new User(); %>
       <%
       String userName=request.getParameter("uname"); 
       
       String userPassword=request.getParameter("upassword");
       
       String email=request.getParameter("email");
       
      if(userName!=null&&userPassword!=null&&email!=null)
      {
    	 
    	  
    	  user.setUserName(userName);
    	  
    	  user.setPassword(userPassword);
    	  
    	  user.setEmail(email);
    	 
    	  dao.addUser(user);

      }    
       
     %>
     
     
     
	
	</body>
	</html>