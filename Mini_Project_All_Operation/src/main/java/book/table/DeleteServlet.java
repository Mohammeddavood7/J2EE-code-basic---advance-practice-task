package book.table;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.register.all.dml.operation.DatabaseConnection;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con = DatabaseConnection.connectToDatabase();
		PrintWriter p = response.getWriter();
		try
		{
			PreparedStatement ps = con.prepareStatement("DELETE FROM BOOKS WHERE BOOKID = ?");
			ps.setInt(1, Integer.parseInt(request.getParameter("id")));
			int executeUpdate = ps.executeUpdate();
			
			p.println("<html><body><center>");
			if(executeUpdate > 0)
			{
				p.print("<h1 text='blue'>Book Delete Successfull</h1>");
			}
			else
			{
				p.println("<h1 text=red>Book Not Delete,Wrong Book ID</h1>");
			}
			p.print("</center></body></html>");
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}






















