package upadate.delete.login.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

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
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet 
{
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() 
    {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
	   con = ConnectToDataBase.getDataBaseConnection();
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
		
        beanOfLRUD lrud = new beanOfLRUD();
        lrud.setUname(request.getParameter("uname"));
        lrud.setPassword(Long.parseLong(request.getParameter("password")));
        lrud.setFname(request.getParameter("fname"));
        lrud.setLname(request.getParameter("lname"));
        lrud.setAddress(request.getParameter("address"));
        lrud.setMailid(request.getParameter("mail"));
        lrud.setPhno(Long.parseLong(request.getParameter("phno")));
        int updateValue = LRUD_DAO.newUser(lrud);

       PrintWriter p =  response.getWriter();
       
       p.println("<html><body>");
       if (updateValue > 0)
       {
		  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		  rd.include(request, response);
		  p.println("<h1>Registered Successfully</h1>");
	   }
       else
       {
 		  p.println("<h1>Not Registered</h1>");

       }
       p.println("</body></html>");


		
	}

}




















