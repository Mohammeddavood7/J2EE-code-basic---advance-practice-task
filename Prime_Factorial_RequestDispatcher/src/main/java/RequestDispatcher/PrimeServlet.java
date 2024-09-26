package RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrimeServlet() {
        super();
    }

    public static boolean isPrime(Integer num)
    {
    	
    	if(num <= 1 )
    	{
    		return false;
    	}
    	
    	for(int i = 2 ; i <= num/2 ;i++)
    	{
    		if(num%2==0)
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String num = request.getParameter("num");
		int number = Integer.parseInt(num);
		boolean prime = isPrime(number);
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body text=red>");
		if(prime)
		{
			pw.println("<h1>It Is A Prime Number</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("input.html");
			rd.include(request, response);
		}
		else 
		{
			pw.println("<h1>It Is Not A Prime Number</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("input.html");
			rd.include(request, response);

			
		}
		pw.println("</body></html>");

	}

}



















