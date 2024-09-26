package RequestDispatcher;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cal")
public class ParenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ParenterServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String button = request.getParameter("button");
		
		if(button.equals("Prime"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("prime");
			rd.forward(request, response);
		}
		else if(button.equals("Factor"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("factor");
			rd.forward(request, response);
			
		}
		else if(button.equals("Factorial"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("factorial");
			rd.forward(request, response);
			
		}
		else if(button.equals("Square"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("square");
			rd.forward(request, response);
			
		}
		
		
	}

}















