package Hidden.Forms.Field;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
       
		
		
		String s1 = request.getParameter("degree");
		String s2 = request.getParameter("degree");
		String s3 = request.getParameter("university");

		PrintWriter p = response.getWriter();
		p.println("<html><body><center><form action='first' method='get'>");
		p.println("<input type='hidden' name='degree' value= "+s1+">");
		p.println("<input type='hidden' name='degree' value= "+s2+">");
		p.println("<input type='hidden' name='university' value= "+s3+">");
		p.println("<input type='submit' >");
		p.println("</form></center></body></html>");

		
	}

}













