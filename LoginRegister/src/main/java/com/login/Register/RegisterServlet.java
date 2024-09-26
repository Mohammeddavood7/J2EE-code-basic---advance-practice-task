package com.login.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet 
{
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
			
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO UINFO VALUES(?,?,?,?)");
			
			String s1 = request.getParameter("fname");
			String s2 = request.getParameter("lname");
			String s3 = request.getParameter("username");
			String s4 = request.getParameter("password");

			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			
			int executeUpdate = pstmt.executeUpdate();
			
			PrintWriter pw = response.getWriter();

			
			pw.println("<html><body bgcolor=red text=yellow>");
			pw.println("<center>");
			if(executeUpdate > 0)
			{
				pw.println("Registered successfully !!!");
				pw.println("<br><a href=login.html>Login</a> ");
				pw.println("</center>");
			}
			else 
			{
				pw.println("already existed username");
				pw.println("/<center>");

				
			}
			pw.println("</body></html>");

			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}

































