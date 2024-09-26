package hidden.form.fields;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html");
		beanOfLogin login =Login_RegistrationDAO.login1(request);
		PrintWriter pw = response.getWriter();
		String s1 = request.getParameter("name");
		

		  PrintWriter p = response.getWriter();
		
			pw.println("<html><body bgcolor=white text=red> <center>");
			p.println("<form action='welcome' method='post'>");
			if(login != null)
			{
				
				p.println("<input type='hidden' name='name' value="+s1+">");
				p.println("<input type='submit' value='Submit'>");
				
			}
			else
			{
				pw.println("<h1>Invalid Username/Password<h1>");
			}
			pw.println("</form></center></body></html>");
			
		
		
		
		
		
	}

}






















