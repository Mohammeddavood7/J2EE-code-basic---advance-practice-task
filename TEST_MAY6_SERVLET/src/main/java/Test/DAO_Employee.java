package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO_Employee 
{
	public static int insertData(beanOfEmployee emp)
	{
		 int executeUpdate = 0;
		Connection con = connectToDataBase.getDataBaseConnection();
		try
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPP1 VALUES(?,?,?,?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getSalary());
			ps.setString(4, emp.getAddress());
		    executeUpdate = ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return executeUpdate;
	}
}
