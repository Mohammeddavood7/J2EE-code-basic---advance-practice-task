package login.update.view.logout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con = DatabaseAccess.connecting();
		try
		{
			PreparedStatement ps = con.prepareStatement("UPDATE PERSONDETAIL SET PASSWORD = ? WHERE ID = ?");
			ps.setString(1, request.getParameter("password"));
			ps.setInt(2, Integer.parseInt(request.getParameter("id")));
			int executeUpdate = ps.executeUpdate();
			
			PrintWriter p = response.getWriter();
		    p.println("<html><body><center>");

			if(executeUpdate > 0)
			{
				p.print("Updated Successfully"+"<br>");
				request.getRequestDispatcher("login.html").include(request, response);
				
				
			}
			else 
			{
				p.print("Not Updated,Update Again");
				request.getRequestDispatcher("update.jsp").include(request, response);;

			}
		    p.println("<html><body><center>");

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}



















