package image;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/imgUploadOnBD")
@MultipartConfig
public class UploadImageOnDatabaseServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	PrintWriter p = response.getWriter();
    	response.setContentType("text/plain");
    	try 
    	{
    		
    		Part part = request.getPart("image");
    		Connection con = DBConnect.getConnection();
    		PreparedStatement ps = con.prepareStatement("INSERT INTO IMGTABLE VALUES(?,?,?)");
    		ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    		ps.setString(2, request.getParameter("name"));
    		ps.setBytes(3, part.getInputStream().readAllBytes());
    		int up = ps.executeUpdate();
    		if(up > 0)
    		{
    			con.commit();
    			p.println("image store in database successfuly");
    		}
    		else
    		{
    			p.println("image not store");

    		}
    		
			
		} 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}













