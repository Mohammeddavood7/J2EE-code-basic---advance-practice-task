package URL;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class setURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		p.println("<h1>Your Books Are Added To Cart</h1>");
		p.println("<a href=get?"+"b1="+s1+"&b2="+s2+"&b3="+s3+">Next</a>");
		p.println("</center></body></html>");
		
	}

}

















