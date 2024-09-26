package redirecting;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	Connection con;
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException 
	{
		con = DatabaseConnection.getConnect();
	}

	
	public void destroy() 
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		beanOfLogin login =Login_RegistrationDAO.login1(request);
		PrintWriter pw = response.getWriter();
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("pword");
		
		try 
		{
			pw.println("<html><body bgcolor=white text=red>");
			if(login != null)
			{
				/*if(s1 != null)
				{
				    Cookie c = new Cookie(s1,"uname");
				    response.addCookie(c);
				}
				if(s2 != null)
				{
				    Cookie c = new Cookie(s2,"pword");
				    response.addCookie(c);
				}*/
				response.sendRedirect("welcome"+"?name="+s1+"&pword="+s2);
				
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






















