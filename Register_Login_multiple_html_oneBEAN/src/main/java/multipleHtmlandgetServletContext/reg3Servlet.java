package multipleHtmlandgetServletContext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reg3Servlet")
public class reg3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		    ServletContext sc = this.getServletContext();
		    beanOfEmployee emp =(beanOfEmployee)sc.getAttribute("empolyee");
		    emp.setState(request.getParameter("state"));
		    emp.setCountry(request.getParameter("country"));
		    
		    int register = EMPDAO.register(emp);
		    
		    
		    PrintWriter p = response.getWriter();
		    p.println("<html><body text=blue> <center>");
		    if(register > 0)
		    {
		        p.println("<h1>You Have Successfully Registered</h1>");
		        RequestDispatcher rd = request.getRequestDispatcher("Homepage.html");
			    rd.include(request, response);
		    }
		    else
		    {
		    	p.println("<div text=red>");
		    	p.println("<h1>Oops! Try Again To Register</h1>"+"<br>");
		    	p.println("<h1 text=red><a href=reg1.hmtl>Register</a></h1>");
		    	p.println("</div>");

		    }
		    
		    p.println("</center></html></body>");
	}

}
