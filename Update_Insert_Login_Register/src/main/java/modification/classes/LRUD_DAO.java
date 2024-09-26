package modification.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class LRUD_DAO
{

	public static int newUser(beanOfLRUD lrud)
	{
		int updateVal = 0;
		
		try 
		{
			 Connection con = ConnectToDataBase.getDataBaseConnection();

			PreparedStatement ps = con.prepareStatement("INSERT INTO LRUD VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, lrud.getUname());
			ps.setLong(2, lrud.getPassword());
			ps.setString(3, lrud.getFname());
			ps.setString(4, lrud.getLname());
			ps.setString(5, lrud.getAddress());
			ps.setString(6, lrud.getMailid());
			ps.setLong(7, lrud.getPhno());
			updateVal = ps.executeUpdate();

			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return updateVal;
		
	}
	
	public static beanOfLRUD loginUser(HttpServletRequest req)
	{
		beanOfLRUD beanoflrud = null;
		ResultSet rs = null;
	try
	{
		 Connection con = ConnectToDataBase.getDataBaseConnection();

		PreparedStatement ps = con.prepareStatement("SELECT *FROM LRUD WHERE UNAME = ? AND PASSWORD = ? ");
		ps.setString(1, req.getParameter("uname"));
		ps.setLong(2, Long.parseLong(req.getParameter("Password")));
		rs = ps.executeQuery();
		if (rs.next()) 
		{
			beanoflrud = new beanOfLRUD();
			beanoflrud.setUname(rs.getString(1));
			beanoflrud.setPassword(rs.getLong(2));
			beanoflrud.setFname(rs.getString(3));
			beanoflrud.setLname(rs.getString(4));
			beanoflrud.setAddress(rs.getString(5));
			beanoflrud.setMailid(rs.getString(6));
			beanoflrud.setPhno(rs.getLong(7));
			
		}
		
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	   
		
		return beanoflrud;
		
	}
	
	public static int updatePassword(long pWord,long phno)
	{
		int executeUpdate = 0;
		try
		{
			 Connection con = ConnectToDataBase.getDataBaseConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE LRUD SET PASSWORD = ? WHERE PHNO = ?");
			ps.setLong(1,pWord);
			
			ps.setLong(2,phno);
			executeUpdate = ps.executeUpdate();
		}
		catch (NumberFormatException | SQLException e)
		{
			e.printStackTrace();
		}
		return executeUpdate;
	}
	
	
	public static int deleteUser(HttpServletRequest request)
	{
		int updateValue = 0;
		try 
		{
			 Connection con = ConnectToDataBase.getDataBaseConnection();

			PreparedStatement ps = con.prepareStatement("DELETE FROM LRUD WHERE PHNO = ?");
			long phno=Long.parseLong(request.getParameter("phno"));
			ps.setLong(1,phno);
			updateValue = ps.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return updateValue;
	}
	
	
	
	
	

}











