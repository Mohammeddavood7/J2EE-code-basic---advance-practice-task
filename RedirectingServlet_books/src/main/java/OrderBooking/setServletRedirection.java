package OrderBooking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class setServletRedirection extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    String s1 =	request.getParameter("book1");
	    String s2 =	request.getParameter("book2");
	    String s3 =	request.getParameter("book3");
	    
	    if(s1 != null)
	    {
	    	Cookie c = new Cookie(s1,"book11");
	    	response.addCookie(c);
	    	
	    }
	    
	    if(s2 != null)
	    {
	    	Cookie c1 = new Cookie(s2,"book22");
	    	response.addCookie(c1);
	    }

	    if(s3 != null)
	    {
	    	Cookie c2 = new Cookie(s3,"book33");
	    	response.addCookie(c2);
	    }
	    
	    PrintWriter p = response.getWriter();
	    p.println("<html><body> <center>");
	    p.println("<h1>Your Books Added To Cart Successfully</h1>");
	    p.println("<h1><a href=get>Next</a></h1>");
	    p.println(" </center></body></html>");
	}

}






















