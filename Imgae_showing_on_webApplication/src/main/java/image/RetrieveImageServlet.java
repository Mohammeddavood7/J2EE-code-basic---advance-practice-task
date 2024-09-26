package image;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getimage")
public class RetrieveImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter p = response.getWriter();
        Connection con = DBConnect.getConnection();
        try 
        {
			PreparedStatement ps = con.prepareStatement("SELECT *FROM IMGTABLE WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				
				
				byte[] image = rs.getBytes(3);
				
				
				String img = Base64.getEncoder().encodeToString(image);
				
				p.println(rs.getInt(1)+"<br>");
				p.println(rs.getString(2)+"<br>");
	            p.println("<img src='data:image/jpeg;base64," + img + "'>");
			}
			
			
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
        
        
        

        
    }
}

















