package Data.Access.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO 
{
	public static int insertRegistration(BeanOfRegistration reg)
	{
		int k = 0;
		try 
		{
			Connection con = connectToDataBase.dataBaseConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?)");
			ps.setString(1, reg.getFname());
			ps.setString(2, reg.getMname());
			ps.setString(3, reg.getLname());
			ps.setLong(4, reg.getMobile());
			k = ps.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}

}











