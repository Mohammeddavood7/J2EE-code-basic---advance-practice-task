package login.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import register.modification.classes.DatabaseConnection;
import register.modification.classes.Login_RegistrationDAO;
import register.modification.classes.beanOfRegistration;


@WebServlet("/reg")
public class registerServlet extends HttpServlet
{
	Connection con ;
	private static final long serialVersionUID = 1L;
       
    
    public registerServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
		con = DatabaseConnection.getConnect();
	}

	
	public void destroy()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		beanOfRegistration bor = new beanOfRegistration();
		
		bor.setName(request.getParameter("name"));
		bor.setPass(request.getParameter("pass"));
		bor.setFname(request.getParameter("fname"));
		bor.setLname(request.getParameter("lname"));
		bor.setMail(request.getParameter("mail"));
		bor.setPhno(Long.parseLong(request.getParameter("phno")));
		
		int val = Login_RegistrationDAO.insertValue(bor);
		System.out.println(val);
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		if(val > 0)
		{
			pw.println("<h1>Registered Successfully</h1>");
			pw.println("<a href=Login.html>Login</a>");
		}
		else 
		{
			pw.println("<h1> Not Registered</h1>");
		}
		pw.println("</body></html>");

		
		
	}

}






























