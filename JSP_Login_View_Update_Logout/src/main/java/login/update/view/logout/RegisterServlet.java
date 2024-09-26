package login.update.view.logout;

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
	    BeanOfPersonDetail person = new BeanOfPersonDetail();
	    person.setId(Integer.parseInt(request.getParameter("id")));
	    person.setName(request.getParameter("name"));
	    person.setPassword(request.getParameter("password"));
	    
	    int registration = PersonDetail_DAO.registration(person);
	    PrintWriter p = response.getWriter();
	    p.println("<html><body><center>");
	    if(registration > 0)
	    {
	    	p.println("<h1>Your Registered Successfully</h1>");
	    	request.getRequestDispatcher("login.html").include(request, response);

	    }
	    else
	    {
	    	p.println("<h1>something went wrong, please register again</h1>");
	    	request.getRequestDispatcher("register.html").include(request, response);

	    }
	    p.println("</center></body></html>");

		
	}

}



















