package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UsingStream 
{
   public static void main(String[] args) throws SQLException
   {
	   System.out.println("hi");
	   ArrayList<beanOfEmployee> la = new ArrayList<>();
	  
	   Connection con = connectToDataBase.getDataBaseConnection();
	    Statement statement = con.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT *FROM EMPP1 WHERE NAME LIKE 'S%'");
	    
	    while(rs.next())
	    {
	    	beanOfEmployee emp = new beanOfEmployee();
	    	int int1 = rs.getInt("ID");
	    	String string1 = rs.getString("NAME");
	    	int int2 = rs.getInt("SALARY");
	    	String string2 = rs.getString("ADDRESS");
	    	
	    	
	    	emp.setId(int1);
	    	emp.setName(string1);
	    	emp.setSalary(int2);
	    	emp.setAddress(string2);
	    	la.add(emp);
	    
	    	
	    }
	    
	    
	  la.stream().forEach(f->System.out.println(f));
	   
   }

}
