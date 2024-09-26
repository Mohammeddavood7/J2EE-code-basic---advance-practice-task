package login.update.view.logout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		
		if(hs==null)
		{
			request.getRequestDispatcher("expire.jsp").forward(request, response);
		}
		else
		{
			BeanOfPersonDetail  person =  (BeanOfPersonDetail) hs.getAttribute("login");
			
			PrintWriter p = response.getWriter();
		    p.println("<html><body><center>");
		    if(person != null)
		    {
		    	p.println("<h1>View The Personal Details</h1>");
		    	p.println("Id: "+person.getId()+"<br>");
		    	p.println("Name: "+person.getName()+"<br>");
		    	p.println("password: "+person.getPassword()+"<br>");
		    }
		    else
		    {
		    	request.getRequestDispatcher("login.html").include(request, response);

		    }
		    p.println("</center></body></html>");
			
		}
	}

}
