package Filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		beanOfLogin login = Login_RegistrationDAO.login1(request);
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		p.println("welcome "+login.getName());
		p.println("</center></body></html>");
		
	}

}

















