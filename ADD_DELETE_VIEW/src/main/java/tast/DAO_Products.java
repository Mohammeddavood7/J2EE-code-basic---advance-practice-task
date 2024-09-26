package tast;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DAO_Products 
{
	public static int addProducts(HttpServletRequest request)
	{
		int executeUpdate = 0;
		String s1 = request.getParameter("id");
		String s2 =request.getParameter("name");
		String s3 =request.getParameter("price");
		String s4 =request.getParameter("quantity");
		
		Connection con = DatabaseConnection.getConnect();
		try 
		{
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(s1));
			ps.setString(2, s2);
			ps.setInt(3, Integer.parseInt(s3));
			ps.setInt(4, Integer.parseInt(s4));
			 executeUpdate = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return executeUpdate;
	}
	
	
	public static int delete(HttpServletRequest request)
	{
		int executeUpdate = 0;
		Connection con = DatabaseConnection.getConnect();
		String s1 = request.getParameter("id");
		try 
		{
			PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCTS WHERE ID = ?");
			ps.setInt(1, Integer.parseInt(s1));
			executeUpdate = ps.executeUpdate();
			
		} catch (SQLException e)
		{
		  e.printStackTrace();
		}
		return executeUpdate;
		
	}
	
	
	public static void viewProducts(HttpServletResponse request) 
	{
		
		Connection con = DatabaseConnection.getConnect();
		try 
		{
			PrintWriter p = request.getWriter();
			PreparedStatement ps = con.prepareStatement("SELECT *FROM PRODUCTS");
			ResultSet rs = ps.executeQuery();
			p.println("<html><body><center>");

			while(rs.next())
			{
				p.println(rs.getInt(1)+"&nbsp;");
				p.println(rs.getString(2)+"&nbsp;");
				p.println(rs.getInt(3)+"&nbsp;");
				p.println(rs.getInt(4)+"<br>");	
			}
			p.println("</center></body></html>");

				
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}





























