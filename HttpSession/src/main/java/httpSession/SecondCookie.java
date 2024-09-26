package httpSession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cookie2")
public class SecondCookie extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter p = response.getWriter();
		
	     String s1 = request.getParameter("degree");
	     String s2 = request.getParameter("year");
	     String s3 = request.getParameter("university");
	     
	    HttpSession s = request.getSession(false);
	    s.setAttribute("degree",s1);
	    s.setAttribute("year",s2);
	    s.setAttribute("university",s3);
	    HttpSession s4 = request.getSession(false);

       String o1 = (String) s4.getAttribute("name");
       String o2 = (String) s4.getAttribute("age");
       String o3 = (String) s4.getAttribute("mobile");
       String o4 = (String) s4.getAttribute("degree");
       String o5 = (String) s4.getAttribute("year");
       String o6 = (String) s4.getAttribute("university");

		
		
		p.println("<html><body><center>");
		
			p.println(o1+"<br>");
			p.println(o2+"<br>");
			p.println(o3+"<br>");
			p.println(o4+"<br>");
			p.println(o5+"<br>");
			p.println(o6+"<br>");

		p.println("</center></body></html>");
		
		
		
		
	}

}























