package login.register.all.dml.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class DAO_CUSTOMERDETAILS 
{
	public static int register(CustomerDetails cust)
	{
		int executeUpdate = 0;
		Connection con = DatabaseConnection.connectToDatabase();
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO CUSTOMERDETAILS VALUES(?,?,?,?,?,?)");
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getPassword());
			ps.setString(3, cust.getFname());
			ps.setString(4, cust.getLname());
			ps.setString(5, cust.getMail());
			ps.setLong(6, cust.getPhno());
			executeUpdate = ps.executeUpdate();

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
       return  executeUpdate;
		
	}

	public static CustomerDetails login(HttpServletRequest request)
	{
		CustomerDetails cust = null;
		
		Connection con = DatabaseConnection.connectToDatabase();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM CUSTOMERDETAILS WHERE NAME = ? AND PASSWORD = ?");
			ps.setString(1, request.getParameter("name"));
			ps.setString(2, request.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cust = new CustomerDetails();
				cust.setName(rs.getString(1));
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cust;
	}
	
	
	
}





























