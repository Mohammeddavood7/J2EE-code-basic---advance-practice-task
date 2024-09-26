package tast;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection 
{
	static Connection con;
	
	public static Connection getConnect()
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
			return con;
		
	}

}














