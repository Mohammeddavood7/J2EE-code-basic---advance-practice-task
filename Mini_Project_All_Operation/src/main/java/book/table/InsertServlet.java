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

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("price");
		String s3 = request.getParameter("id");
		PrintWriter p = response.getWriter();
	    Connection con = DatabaseConnection.connectToDatabase();
	    try
	    {
			PreparedStatement ps = con.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?)");
			ps.setString(1, s1);
			ps.setDouble(2, Double.parseDouble(s2));
			ps.setInt(3,Integer.parseInt(s3));
			int executeUpdate = ps.executeUpdate();
			p.println("<html><body><center>");
			if(executeUpdate > 0)
			{
				p.print("<h1 text='blue'>Book Added Successfull</h1>");
				request.getRequestDispatcher("opendml.html").include(request, response);
			}
			else
			{
				p.println("<h1 text='red'>Book Not Added Chech Once,Try Again</h1>");
			}
			p.print("</center></body></html>");
			
			
			
		}
	    catch (SQLException e)
	    {
			e.printStackTrace();
		}
	    

	}

}





















