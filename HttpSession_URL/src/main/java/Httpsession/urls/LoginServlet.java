package Httpsession.urls;
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
import jakarta.servlet.http.HttpSession;

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
		try (PrintWriter pw = response.getWriter()) {
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

}






















