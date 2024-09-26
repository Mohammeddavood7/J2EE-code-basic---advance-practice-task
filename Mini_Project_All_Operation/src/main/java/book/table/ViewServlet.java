package book.table;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.register.all.dml.operation.DatabaseConnection;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con = DatabaseConnection.connectToDatabase();
		PrintWriter p = response.getWriter();
		try 
		{
			ArrayList<beanOfBook> al = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT *FROM BOOKS");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			
			p.println("<html><body><center>");
			for(int i = 1 ; i <= count ; i++)
			{
				p.println("<spam>"+rm.getColumnName(i)+"</spam>"+"&nbsp;&nbsp;");
				
			}
			p.println("<br>");
			
			while(rs.next())
			{
				beanOfBook b = new beanOfBook();
				b.setBookname(rs.getString(1));
				b.setBookPrice(rs.getDouble(2));
				b.setBookId(rs.getInt(3));
				p.println("<br>");
				al.add(b);
				
			}
			Iterator<beanOfBook> it = al.iterator();
			while(it.hasNext())
			{
				p.println(it.next());
				p.println("<br>");
			}
			
			p.print("</center></body></html>");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}























