package com.login.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
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
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SERVLET","TIGER");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
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
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM UINFO WHERE UNAME = ? AND PASSWORD = ?");
			
			String s1 = request.getParameter("uname");
			String s2  = request.getParameter("pword");

			ps.setString(1, s1);
			ps.setString(2, s2);
			
			ResultSet rs = ps.executeQuery();
			
			PrintWriter pw = response.getWriter();
			
			pw.println("<html><body bgcolor=red text=yellow><h1>");
			
			if(rs.next())
			{
				pw.println("successfully login !!");
			}
			else
			{
				pw.println("invalid username/password");
				pw.println("<a href=login.html>Login</a>");

			}
			pw.println("</h1></body></html> ");
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}





















