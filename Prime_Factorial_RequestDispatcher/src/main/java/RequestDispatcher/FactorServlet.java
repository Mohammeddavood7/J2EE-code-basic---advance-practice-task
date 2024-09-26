package RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/factor")
public class FactorServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
       
    
    public FactorServlet() {
        super();
        
    }
    
    public static StringBuilder factor(Integer num)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	for(Integer i = 1 ; i <= num ; i++)
    	{
    		if(num % i == 0)
    		{
    		   sb.append(i).append(" ");	
    		}
    	}
    	return sb;
    }
    
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		  String parameter = request.getParameter("num"); 
		  Integer num = Integer.parseInt(parameter);
		  StringBuilder factor = factor(num);
		  
		  
		  PrintWriter pw = response.getWriter(); pw.println("<html><body text=red>");
		  pw.println("<h1>Foctor Of Number:  "+factor.toString()+" "+"</h1>"); 
		  RequestDispatcher rd = request.getRequestDispatcher("input.html"); 
		  rd.include(request, response);
		  pw.println("</body></html>");
		 

		
		
		
		
	}

}















