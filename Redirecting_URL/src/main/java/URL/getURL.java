package URL;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getURL extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter p = response.getWriter();
		String s1 = request.getParameter("b1");
		String s2 = request.getParameter("b2");
		String s3 = request.getParameter("b3");
		
		p.println("<html><body> <center>");
		
		
		if(!s1.equals("null"))
		{
			p.println(s1+"<br>");
			
		}
		if(!s2.equals("null"))
		{
			p.println(s2+"<br>");
			
		}
		if(!s3.equals("null"))
		{
			p.println(s3+"<br>");
			
		}
		
		
		p.println("<center></body></html>");
		
		
		

		
	}

}

















