package servletcontextlintener.servletContextEvents;
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
         
          
		beanOfLogin login =Login_RegistrationDAO.login1(request);
		PrintWriter pw = response.getWriter();
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("pword");
		
		HttpSession hs = request.getSession();
		hs.setAttribute("names", s1);
		hs.setAttribute("pwordd", s2);
		String url = response.encodeURL("welcome");
		try 
		{
			pw.println("<html><body bgcolor=white text=red>");
			
			if(login != null)
			{
				response.sendRedirect(url);
				
			}
			else
			{
				pw.println("<h1>Invalid Username/Password<h1>");
			}
			pw.println("</body></html>");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}






















