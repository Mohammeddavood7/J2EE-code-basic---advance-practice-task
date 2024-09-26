package dynamically.take.database.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DynamicallyDataBase
 */
public class DynamicallyDataBase extends HttpServlet 
{
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicallyDataBase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		
		ServletContext sc = config.getServletContext();
		
		
		
		try 
		{
		  String s1 = 	sc.getInitParameter("driver");
		  String s2 = 	sc.getInitParameter("url");
		  String s3 = 	sc.getInitParameter("username");
		  String s4 = 	sc.getInitParameter("password");
		  
		  Class.forName(s1);
		  con = DriverManager.getConnection(s2,s3,s4);
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s1 = request.getParameter("uname");
		String s2 = request.getParameter("pword");
		PreparedStatement ps = null;
		try 
		{
			ps = con.prepareStatement("SELECT *FROM UINFO WHERE UNAME = ? AND PASSWORD = ?");
			ps.setString(1, s1);
			ps.setString(2, s2);
		    ResultSet rs = ps.executeQuery();
            
		    PrintWriter pw = response.getWriter();
		    
		    
			pw.println("<html><body>");
			if(rs.next())
			{
				pw.println("<h1>login succssfully</h1>"+rs.getString("uname").toUpperCase()+"!!!!!");
			}
			else 
			{
				pw.println("<h1>invalid username/password</h1>");
				pw.println("<a href=login.html>Login</a>");

				
			}
			pw.println("</body></html>");

			
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		

		
		
	}

}






















