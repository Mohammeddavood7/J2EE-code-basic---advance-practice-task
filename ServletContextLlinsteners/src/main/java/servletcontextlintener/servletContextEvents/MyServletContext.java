package servletcontextlintener.servletContextEvents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class MyServletContext implements ServletContextListener
{
	Connection con;

    public void contextInitialized(ServletContextEvent sce) 
    { 
    	try 
    	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SERVLET","TIGER");
			ServletContext sc = sce.getServletContext();
			sc.setAttribute("oracle", con);
		} 
    	catch (ClassNotFoundException | SQLException e)
    	{
			e.printStackTrace();
		}
    	
    }

	
    public void contextDestroyed(ServletContextEvent sce)
    {
    	try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}




















