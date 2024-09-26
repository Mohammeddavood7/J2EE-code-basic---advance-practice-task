package sort.duplicate.max.unique;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/super")
public class SuperServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String s = request.getParameter("dml");
		
		if(s.equals("PrintDuplicate"))
		{
			 RequestDispatcher rd = request.getRequestDispatcher("duplicate");
			 rd.forward(request, response);
		}
		else if(s.equals("PrintSorting"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("sort");
			 rd.forward(request, response);
			
		}
		else if(s.equals("PrintMax"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("max");
			 rd.forward(request, response);
			
		}
		else if(s.equals("PrintUnique"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("unique");
			 rd.forward(request, response);
			
		}


		
	}

}



















