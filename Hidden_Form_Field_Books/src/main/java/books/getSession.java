package books;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getSession extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		
		PrintWriter p = response.getWriter();
		 
		     
		    p.println("<html><body> <center>");
		   
		      if(!s1.equals("null"))
		      p.println("<h1>"+s1+"</h1>");
		      
		      if(!s2.equals("null"))
		      p.println("<h1>"+s2+"</h1>");
		      
		      if(!s3.equals("null"))
		      p.println("<h1>"+s3+"</h1>");
		      
		      
		   p.println("</center></body></html>");

		
	}

}





















