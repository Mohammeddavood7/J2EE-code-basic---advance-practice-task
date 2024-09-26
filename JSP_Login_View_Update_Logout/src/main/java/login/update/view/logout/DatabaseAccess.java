package login.update.view.logout;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseAccess
{
    static Connection con;
    
    static
    {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SERVLET","TIGER");
			
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static Connection connecting()
    {
    	return con;
    }
    
	
}















