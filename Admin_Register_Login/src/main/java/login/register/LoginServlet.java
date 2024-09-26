package login.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import register.modification.classes.DatabaseConnection;
import register.modification.classes.Login_RegistrationDAO;
import register.modification.classes.beanOfLogin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		con = DatabaseConnection.getConnect();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() 
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		beanOfLogin bol = new beanOfLogin();
		
//		bol.setName(request.getParameter("name"));
//		bol.setPass(request.getParameter("pword"));
		
		beanOfLogin login =Login_RegistrationDAO.login1(request);
		
		PrintWriter pw = response.getWriter();
		
		
		try 
		{
			pw.println("<html><body bgcolor=white text=red>");
			if(login != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}
			else
			{
				pw.println("<h1>Invalid Username/Password<h1>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			    rd.include(request, response);

			}
			pw.println("</body></html>");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}






















