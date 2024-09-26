package hidden.form.fields;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class Login_RegistrationDAO 
{
	/*public static int insertValue(beanOfRegistration bor)
	{
		int value = 0;
		
		Connection con = DatabaseConnection.getConnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO USER_INFO VALUES(?,?,?,?,?,?)");
			ps.setString(1, bor.getName());
			ps.setString(2, bor.getPass());
			ps.setString(3, bor.getFname());
			ps.setString(4, bor.getLname());
			ps.setString(5, bor.getMail());
			ps.setLong(6, bor.getPhno());
			 value = ps.executeUpdate();
	
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return value;
		
	}
	*/	
	
	public static  beanOfLogin login(beanOfLogin bol)
	{
		beanOfLogin res=null;
		Connection con = DatabaseConnection.getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try 
		{
			 ps = con.prepareStatement("SELECT *FROM USER_INFO WHERE NAME = ? AND PASS = ?");
			 ps.setString(1, bol.getName());
			 ps.setString(2, bol.getPass());
			  rs = ps.executeQuery();
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs.next())
			{
				if(rs.getString("name").equals(bol.getName()) && rs.getString("pass").equals(bol.getPass())) 
				{
					res = bol;
				}
			}
			else 
			{
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
	public static beanOfLogin login1(HttpServletRequest req)
	{
		beanOfLogin b= null;
		try {
			
			Connection con=DatabaseConnection.getConnect();
			PreparedStatement ps=con.prepareStatement("SELECT *FROM USER_INFO WHERE NAME = ? AND PASS = ?");
			ps.setString(1, req.getParameter("name"));
			 ps.setString(2, req.getParameter("pword"));
			 ResultSet rs = ps.executeQuery();
			 if(rs.next())
			 {
				b = new beanOfLogin();
				b.setName(rs.getString(1));
				b.setPass(rs.getString(2));
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;

     }
}

















