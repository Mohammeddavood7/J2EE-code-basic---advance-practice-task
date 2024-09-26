package modification.classes;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateclass")
public class UpdateClass extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String parameter = request.getParameter("Password");
		PrintWriter p = response.getWriter();
		p.println("password successfully changed: "+parameter);
	}
	

}














