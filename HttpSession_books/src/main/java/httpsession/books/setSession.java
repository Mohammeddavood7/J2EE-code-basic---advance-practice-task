package httpsession.books;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/set")
public class setSession extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");  
		HttpSession s = request.getSession(true);

	   if(s1 != null)
	   {
		   
		   s.setAttribute("book1", s1);
		   
	   }
	   
	   if(s2 != null)
	   {
		   s.setAttribute("book2", s2);

	   }
	   
	   if(s3 != null)
	   {
		   s.setAttribute("book3", s3);
	   }
	   PrintWriter p = response.getWriter();
	   p.println("<html><body><center>");
	   p.println("<h1>Your Books Are Added To Cart</h1>");
	   p.println("<h1> <a href=get> Next </a> </h1>");
	   p.println("</center></body></html>");

		

		
		
		
	}

}


















