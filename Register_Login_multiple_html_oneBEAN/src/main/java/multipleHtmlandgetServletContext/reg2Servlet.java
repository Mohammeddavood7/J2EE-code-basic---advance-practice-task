package multipleHtmlandgetServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg2Servlet")
public class reg2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext sc = this.getServletContext();
		beanOfEmployee emp =(beanOfEmployee)sc.getAttribute("empolyee");
		emp.setLname(request.getParameter("lname"));
		emp.setMail(request.getParameter("mail"));
	    emp.setPhno(Long.parseLong(request.getParameter("phno")));
	    RequestDispatcher rd = request.getRequestDispatcher("reg3.html");
    	rd.include(request, response);
	    PrintWriter p = response.getWriter();
	    p.println("<html><body text=blue>");
	    p.println("<h1>Previous Added Into Data Base</h1>");
	    p.println("</html></body>");

	    
		
	}

}










