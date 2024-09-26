package upadate.delete.login.register;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modification.classes.LRUD_DAO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		long pWord=Long.parseLong(request.getParameter("Password"));
		long phno=Long.parseLong(request.getParameter("phonenumber"));
		System.out.println(pWord);
		System.out.println(phno);
		int updatePassword = LRUD_DAO.updatePassword(pWord,phno);
		PrintWriter p = response.getWriter();
		if(updatePassword > 0) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("updateclass");
			rd.forward(request, response);
		}
		else
		{
			p.println("invalid phone number "+request.getParameter("phonenumber"));
			
		}
	}

}






