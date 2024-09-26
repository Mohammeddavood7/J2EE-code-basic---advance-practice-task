package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class FirstCookie extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("age");
		String s3 = request.getParameter("mobile");
		
		if(s1 != null)
		{
			Cookie c = new Cookie("name",s1);
			response.addCookie(c);
		}
		
		if(s2 != null)
		{
			Cookie c = new Cookie("age",s2);
			response.addCookie(c);
		}
		
		if(s3 != null)
		{
			Cookie c = new Cookie("mobile",s3);
			response.addCookie(c);
		}
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		p.println("<h1>Cookies Are Added Successfully</h1>");
		request.getRequestDispatcher("cookie2.html").include(request, response);
		p.println("</center></body></html>");
		
		

	}

}






















