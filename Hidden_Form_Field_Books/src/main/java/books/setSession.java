package books;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class setSession extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");  
		
	   PrintWriter p = response.getWriter();
	   p.println("<html><body><center><form action='get' method='post'>");
	   p.println("<h1>Your Books Are Added To Cart</h1>");
	   p.println("<input type=hidden name=book1 value="+s1+">");
	   p.println("<input type=hidden name=book2 value="+s2+">");
	   p.println("<input type=hidden name=book3 value="+s3+">");
	   p.println("<input type=submit value=Submit>"); 
	   p.println("</form></center></body></html>");

		

		
		
		
	}

}


















