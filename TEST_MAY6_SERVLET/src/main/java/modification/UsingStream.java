package modification;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Stream;

import Test.beanOfEmployee;
import Test.connectToDataBase;


public class UsingStream 
{
   public static void main(String[] args) throws SQLException
   {
	   System.out.println("hello");
	   ArrayList<beanOfEmployee> la = new ArrayList<>();
	  
	   Connection con = connectToDataBase.getDataBaseConnection();
	   PreparedStatement ps = con.prepareStatement("SELECT *FROM EMPP1");
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next())
	    {
	    	beanOfEmployee emp = new beanOfEmployee();
	    	int int1 = rs.getInt(1);
	    	String string1 = rs.getString(2);
	    	int int2 = rs.getInt(3);
	    	String string2 = rs.getString(4);
	    	
	    	emp.setId(int1);
	    	emp.setName(string1);
	    	emp.setSalary(int2);
	    	emp.setAddress(string2);
	    	la.add(emp);
	    
	    	
	    }
	    
	    
		/*    Stream<beanOfEmployee> map = la.stream().map(n->
		{
			if(n.getName().startsWith("S")) 
			{
			  
			}
			        return n;
		});
		  map.forEachOrdered(System.out::println);*/
	    
	    la.stream().filter(x->x.getName().startsWith("S")).forEach(System.out::println);
	
   }

}













