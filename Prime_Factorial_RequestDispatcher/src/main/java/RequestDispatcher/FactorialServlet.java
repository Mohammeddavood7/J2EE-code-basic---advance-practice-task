package RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FactorialServlet() {
        super();
    }
    
    
    
    public static StringBuilder factorial(Integer num) 
    {
    	StringBuilder sb = new StringBuilder();
    	Integer sum = 1;
    	while(num != 0)
    	{
    	    sum *= num;
    		sb.append(num--).append(" x ");
    	}
    	sb.append(" : "+sum);
    	
    	return sb;
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String parameter = request.getParameter("num");
		Integer num = Integer.parseInt(parameter);
		StringBuilder factorail = factorial(num);
		
		
		    PrintWriter pw = response.getWriter();
		    pw.println("<html><body text=red>");
			pw.println("<h1>Foctorial Of The Number:  "+factorail+" "+"</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("input.html");
			rd.include(request, response);
		    pw.println("</body></html>");
	}

}
