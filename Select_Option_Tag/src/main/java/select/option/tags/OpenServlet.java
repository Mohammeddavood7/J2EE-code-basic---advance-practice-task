package select.option.tags;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/openServlet")
public class OpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("s1");
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		if(s1.equals("Telangana"))
		{
			p.println("<h1>Your Selected State</h1>");
			p.println("<h1>"+s1+"</h1>"+"<br>");
			p.println("captial is Hyderabad");
			
		}
		
		else if(s1.equals("TamilNadu"))
		{
			p.println("<h1>Your Selected State</h1>");
			p.println("<h1>"+s1+"</h1>"+"<br>");
			p.println("captial is Chennai");

		}
		
		else if(s1.equals("Kerala"))
		{
			p.println("<h1>Your Selected State :  </h1>");
			p.println("<h1>"+s1+"</h1>"+"<br>");
			p.println("captial is Thirmananthapuram");
			
		}
		
		else if(s1.equals("Bangalore"))
		{
			p.println("<h1>Your Selected State</h1>");
			p.println("<h1>"+s1+"</h1>"+"<br>");
			p.println("captial is Bengalure");

			
		}
		
		else if(s1.equals("Goa"))
		{
			p.println("<h1>Your Selected State</h1>");
			p.println("<h1>"+s1+"</h1>"+"<br>");
			p.println("captial is Pune");

			
		}
        p.println("</center></body></html>");
		
	}

}



















