package add.delete.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first")
public class firstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int add = DAO_Products.addProducts(request);
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		if(add > 0)
		{
		   p.print("<h1>Products Added successfully</h1>");
		}
		else
		{
			   p.print("<h1>Products are not Added,try again</h1>");

		}
		p.println("</center></body></html>");

	}

}




















