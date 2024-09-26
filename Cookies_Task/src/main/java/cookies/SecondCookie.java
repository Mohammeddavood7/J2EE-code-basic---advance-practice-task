package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie2")
public class SecondCookie extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	     String s1 = request.getParameter("degree");
	     String s2 = request.getParameter("year");
	     String s3 = request.getParameter("university");
	     
	     Cookie c1 = new Cookie("degree",s1);
	     response.addCookie(c1);
	     Cookie c2 = new Cookie("year",s2);
	     response.addCookie(c2);
	     Cookie c3 = new Cookie("university",s3);
	     response.addCookie(c3);

	     Cookie[] cookies = request.getCookies();
		 PrintWriter p = response.getWriter();


		
		
		p.println("<html><body><center>");
		for(Cookie c : cookies)
		{
			p.println(c.getValue()+"<br>");
		}
		p.println("</center></body></html>");
		
	}

}























