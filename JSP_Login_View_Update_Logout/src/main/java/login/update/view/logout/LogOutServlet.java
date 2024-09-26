package login.update.view.logout;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession s = request.getSession(false);
		if(s != null)
		{
			s.invalidate();
	      	request.getRequestDispatcher("logout.jsp").include(request, response);
	      	
		}
    }

}


















