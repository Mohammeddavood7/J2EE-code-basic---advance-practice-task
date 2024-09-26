package tast;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int delete = DAO_Products.delete(request);
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		if(delete > 0)
		{
		   p.print("<h1>Products Delete successfully</h1>"+request.getParameter("id"));
		}
		else
		{
			   p.print("<h1>Products not Delete </h1>");

		}
		p.println("</center></body></html>");

		
	}

}






















