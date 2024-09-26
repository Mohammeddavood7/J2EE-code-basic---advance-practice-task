package upadate.delete.login.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modification.classes.ConnectToDataBase;
import modification.classes.LRUD_DAO;
import modification.classes.beanOfLRUD;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	Connection con;
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() 
    {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException 
	{
	   con = ConnectToDataBase.getDataBaseConnection();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		beanOfLRUD loginUser = LRUD_DAO.loginUser(request);
		
		PrintWriter p =  response.getWriter();
	    
		p.println("<html><body>");
		if (loginUser != null) 
		{
			  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			  rd.include(request, response);
			  p.println("<h1 text=blue>Login Successfully</h1>");
		}
		else
		{
			  p.println("<h1>Invalid Username/Password</h1>");

		}
	    p.println("</body></html>");

		
	}

}













