package modification.classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDataBase
{
	static Connection con;
	static 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SERVLET","TIGER");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public static Connection getDataBaseConnection()
	{
		return con;
	}

}













