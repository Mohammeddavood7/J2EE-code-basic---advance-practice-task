package multipleHtmlandgetServletContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class EMPDAO 
{
	public static int register(beanOfEmployee emp)
	{
		int insertValue = 0;
		Connection con = DatabaseConnection.getConnect();
		try
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE_HTML VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getId());
			ps.setString(3, emp.getFname());
			ps.setString(4, emp.getLname());
			ps.setString(5, emp.getMail());
			ps.setLong(6, emp.getPhno());
			ps.setString(7, emp.getState());
			ps.setString(8, emp.getCountry());
			insertValue = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return insertValue;
	}
	
	public static beanOfEmployee login(HttpServletRequest request)
	{
		beanOfEmployee emp = null;
		
		Connection con = DatabaseConnection.getConnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM EMPLOYEE_HTML WHERE NAME = ? AND MAIL = ?");
			ps.setString(1, request.getParameter("name"));
			ps.setString(2, request.getParameter("mail"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				emp  = new beanOfEmployee();
				emp.setName(rs.getString(1));
				emp.setId(rs.getInt(2));
				emp.setFname(rs.getString(3));
				emp.setLname(rs.getString(4));
				emp.setMail(rs.getString(5));
				emp.setPhno(rs.getInt(6));
				emp.setState(rs.getString(7));
				emp.setCountry(rs.getString(8));
				
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return emp;
		
	}

}
