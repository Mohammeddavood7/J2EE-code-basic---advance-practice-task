package OrderBooking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getServletCookies extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie c [] = request.getCookies();
		PrintWriter p = response.getWriter();
		p.println("<html><body>");
		for(Cookie c1 : c)
		{
			p.println(c1.getName()+"<br>");	
		}
		p.println("</body><html>");
		
	}

}















