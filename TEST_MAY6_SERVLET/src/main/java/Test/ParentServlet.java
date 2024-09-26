package Test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/parent")
public class ParentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public ParentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		beanOfEmployee b = new beanOfEmployee();
		b.setId(Integer.parseInt(request.getParameter("id")));
		b.setName(request.getParameter("name"));
		b.setId(Integer.parseInt(request.getParameter("salary")));
		b.setAddress(request.getParameter("address"));
		
		int updateNumber = DAO_Employee.insertData(b);
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");

		if(updateNumber > 0)
		{
			 
			 pw.println("<h1>You Have Successfully Registered</h1>");
		}
		else
		{
			 pw.println("<h1 bgcolor=white text=red>Not Registered,Something Went Wrong Do Again</h1>");
		}
		pw.println("</body></html>");


		
		
		
		
	}

}
















