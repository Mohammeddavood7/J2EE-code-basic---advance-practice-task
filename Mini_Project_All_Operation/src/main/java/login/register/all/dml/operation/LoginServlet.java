package login.register.all.dml.operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		CustomerDetails login = DAO_CUSTOMERDETAILS.login(request);
		
        PrintWriter p = response.getWriter();
        
		p.println("<html><body><center>");
		if (login != null) 
		{
			p.println("<h1>Login Successfully </h1>"+login.getName());
			
			request.getRequestDispatcher("opendml.html").include(request, response);
			
		}
		else
		{
			p.println("<h1>Invalid Username/Password</h1>");
		}
		p.println("</center></body></html>");
		
		
	}

}















