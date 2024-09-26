package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ret")
public class RetrieveServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
       
    
    public RetrieveServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 Connection con = connectToDataBase.getDataBaseConnection();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT *FROM EMPP1 WHERE ID = ?");
			int int1 = Integer.parseInt(request.getParameter("iden"));
			ps.setInt(1, Integer.valueOf(int1));
			ResultSet rs = ps.executeQuery();
			PrintWriter pw = response.getWriter();
            
			pw.println("<html><body>");
            while(rs.next())
            {
			pw.println(rs.getInt(1));
			pw.println(rs.getString(2));
		    pw.println(rs.getInt(3));
		    pw.println(rs.getString(4));
            }
            
			pw.println("</body></html>");

            

			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}








