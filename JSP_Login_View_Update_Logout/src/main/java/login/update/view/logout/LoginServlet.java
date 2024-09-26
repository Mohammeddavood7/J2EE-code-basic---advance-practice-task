package login.update.view.logout;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		BeanOfPersonDetail login = PersonDetail_DAO.login(request);
		
		 PrintWriter p = response.getWriter();
		    p.println("<html><body><center>");
		    if(login != null)
		    {
		    	HttpSession session = request.getSession();
		    	session.setAttribute("login", login);
		    	p.println("<h1>Login Successfully</h1>");
		    	request.getRequestDispatcher("Success.jsp").forward(request, response);

		    }
		    else
		    {
		    	request.getRequestDispatcher("LoginFail.jsp").include(request, response);

		    }
		    p.println("</center></body></html>");
		
		
		
		
	}

}





















