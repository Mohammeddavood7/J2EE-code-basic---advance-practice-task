package httpsession.books;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/get")
public class getSession extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession hs = request.getSession(false);
		
		String s1 =(String)hs.getAttribute("book1");
		String s2 =(String)hs.getAttribute("book2");
		String s3 =(String)hs.getAttribute("book3");
		
		 PrintWriter p = response.getWriter();
		 
		     
		    p.println("<html><body> <center>");
		   
		      if(s1 != null)
		      p.println("<h1>"+s1+"</h1>");
		      
		      if(s2 != null)
		      p.println("<h1>"+s2+"</h1>");
		      
		      if(s3 != null)
		      p.println("<h1>"+s3+"</h1>");
		      
		      
		   p.println("</center></body></html>");

		
	}

}





















