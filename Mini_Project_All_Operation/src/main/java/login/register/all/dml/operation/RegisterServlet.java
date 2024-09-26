package login.register.all.dml.operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CustomerDetails c = new CustomerDetails();
		c.setName(request.getParameter("name"));
		c.setPassword(request.getParameter("password"));
		c.setFname(request.getParameter("fname"));
		c.setLname(request.getParameter("lname"));
		c.setMail(request.getParameter("mail"));
		c.setPhno(Long.parseLong(request.getParameter("phno")));
		int register = DAO_CUSTOMERDETAILS.register(c);
		PrintWriter p = response.getWriter();
		
		p.println("<html><body><center>");
		if (register > 0) 
		{
			p.println("<h1>Registered Successfully </h1>"+c.getName());
		}
		else
		{
			p.println("<h1>Not Registered Something Went Wrongs Try Again</h1>");
		}
		p.println("</center></body></html>");
		
	}

}


















