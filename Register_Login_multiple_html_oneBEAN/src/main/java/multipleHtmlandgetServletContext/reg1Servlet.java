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

@WebServlet("/reg1Servlet")
public class reg1Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		beanOfEmployee emp =new beanOfEmployee();
		emp.setName(request.getParameter("name"));
		emp.setId(Integer.parseInt(request.getParameter("id")));
	    emp.setFname(request.getParameter("fname"));
	    
	    ServletContext sc = this.getServletContext();
	    sc.setAttribute("empolyee", emp);
	    RequestDispatcher rd = request.getRequestDispatcher("reg2.html");
	    rd.include(request, response);
	    PrintWriter p = response.getWriter();
	    p.println("<html><body text=blue>");
	    p.println("<h1>Previous Added Into Data Base</h1>");
	    p.println("</html></body>");
	}

}


















