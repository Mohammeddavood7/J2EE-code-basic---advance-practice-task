package httpSession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cookie1")
public class FirstCookie extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("age");
		String s3 = request.getParameter("mobile");
		HttpSession s = request.getSession();
		s.setMaxInactiveInterval(10);
		if(s1 != null)
		{
			s.setAttribute("name",s1);
		}
		
		if(s2 != null)
		{
			s.setAttribute("age",s2);
		}
		
		if(s3 != null)
		{
			s.setAttribute("mobile",s3);
		}
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		p.println("<h1>Cookies Are Added Successfully</h1>");
	  response.sendRedirect("cookie2.html");
		p.println("</center></body></html>");
	}

}






















