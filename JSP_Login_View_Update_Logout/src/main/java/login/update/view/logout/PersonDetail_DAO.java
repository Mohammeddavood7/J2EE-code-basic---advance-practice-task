package login.update.view.logout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class PersonDetail_DAO
{
	public static BeanOfPersonDetail login(HttpServletRequest request)
	{
		BeanOfPersonDetail person = null;
		Connection con = DatabaseAccess.connecting();
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM PERSONDETAIL WHERE NAME = ? AND PASSWORD = ? ");
		     ps.setString(1, request.getParameter("name"));
		     ps.setString(2, request.getParameter("password"));
		     ResultSet rs = ps.executeQuery();
		    
		     if(rs.next())
		     {
		    	 person = new BeanOfPersonDetail();
		    	 person.setId(rs.getInt(1));
		    	 person.setName(rs.getString(2));	
		    	 person.setPassword(rs.getString(3));;
		     }
		     
		     
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		 
		return person;
	}
	
	
	public static int registration(BeanOfPersonDetail person)
	{
		 Connection  con = DatabaseAccess.connecting();
		 int executeUpdate = 0;
		try 
		{
			PreparedStatement ps =  con.prepareStatement("INSERT INTO PERSONDETAIL VALUES(?,?,?)");
			ps.setInt(1, person.getId());
			ps.setString(2,person.getName());
			ps.setString(3, person.getPassword());
			 executeUpdate = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return executeUpdate;
	}
	

}
























