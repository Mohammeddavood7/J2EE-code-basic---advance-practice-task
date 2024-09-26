package multipleHtmlandgetServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		beanOfEmployee login = EMPDAO.login(request);
		PrintWriter p = response.getWriter();
	    p.println("<html><body text=blue> <center>");
	    if(login != null)
	    {
	        p.println("<h1>Login Successfully</h1>"+"<br>");
	        p.println("<h1>Welcome User: </h1>"+login.getName());
	    }
	    else
	    {
	    	p.println("<div text=red>");
	    	p.println("<h1>Invalid Name/Mail</h1>"+"<br>");
	    	p.println("<h1 text=red><a href=Homepage.html>Login</a></h1>");
	    	p.println("</div>");

	    }
	    
	    p.println("</center></html></body>");
		
	}

}



















