package upadate.delete.login.register;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modification.classes.LRUD_DAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
 
    public DeleteServlet() 
    {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int deleteUser = LRUD_DAO.deleteUser(request);
		
		PrintWriter p = response.getWriter();
		p.println("<html><body>");
		if (deleteUser > 0) 
		{
			p.println("<h1>"+"deleted user successfully : "+request.getParameter("phno")+"</h1>");
		}
		else
		{
			p.println("<h1>"+"not deleted "+request.getParameter("phno")+"</h1>");
		}
		p.println("</body></html>");

	}

}






