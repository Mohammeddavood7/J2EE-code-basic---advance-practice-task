package book.table;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.register.all.dml.operation.DatabaseConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
     	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
     	{
     		Connection con = DatabaseConnection.connectToDatabase();
     		PrintWriter p = response.getWriter();
     		try 
     		{
				PreparedStatement ps = con.prepareStatement("UPDATE BOOKS SET BOOKPRICE = ? WHERE BOOKID = ?");
				ps.setDouble(1, Double.parseDouble(request.getParameter("price")));
				ps.setInt(2, Integer.parseInt(request.getParameter("id")));
				int executeUpdate = ps.executeUpdate();
				p.println("<html><body><center>");
				if(executeUpdate > 0)
				{
					p.print("<h1 text='blue'>Book Price Updated Successfull</h1>"+request.getParameter("id"));
				}
				else
				{
					p.println("<h1 text='red'>Book Not Updated,Wrong Book ID</h1>");
				}
				p.print("</center></body></html>");
				
			}
     		catch (SQLException e) 
     		{
				e.printStackTrace();
			}
     		
     		
	    }

}























