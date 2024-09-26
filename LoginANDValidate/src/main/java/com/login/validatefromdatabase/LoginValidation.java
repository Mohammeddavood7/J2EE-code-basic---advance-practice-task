package com.login.validatefromdatabase;

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
 * Servlet implementation class LoginValidation
 */
public class LoginValidation extends HttpServlet
{
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SERVLET","TIGER");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT *FROM UINFO WHERE UNAME = ? AND PASSWORD = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    String s1 = request.getParameter("uname");
		String s2 = request.getParameter("pword");
		

		try
		{
			ps.setString(1, s1);
			ps.setString(2, s2);
			
			ResultSet rs = ps.executeQuery();
			
			PrintWriter pw = response.getWriter();
			
			pw.println("<html> <body bgcolor=red text=yellow>");
			
			if(rs.next())
			{
				pw.println("login successfully !!!!");
			}
			else
			{
				pw.println("<h1>invalid username/password</h1>");
				pw.println("<h1><a href=Validation.html>Login</a></h1>");
			}
			pw.println("</body> </html> ");

			
			
			
			
			
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		

	}

}




