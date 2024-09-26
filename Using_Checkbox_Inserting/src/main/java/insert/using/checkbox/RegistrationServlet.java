package insert.using.checkbox;

import java.io.IOException;
import java.io.PrintWriter;

import Data.Access.Object.BeanOfRegistration;
import Data.Access.Object.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BeanOfRegistration reg = new BeanOfRegistration();
		reg.setFname(request.getParameter("fname"));
		reg.setMname(request.getParameter("mname"));
		reg.setLname(request.getParameter("lname"));
		reg.setMobile(Long.parseLong(request.getParameter("mobile")));
		
		int registration = RegistrationDAO.insertRegistration(reg);
		
		PrintWriter p = response.getWriter();
		p.println("<html><body>");
		if(registration > 0)
		{
			p.println("<h1>Registered Successfully</h1>");
		}
		else
		{
			p.println("<h1>Not Registereds </h1>");

		}
		p.println("</body></html>");

		
	}

}
