package RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/square")
public class SquareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SquareServlet() {
        super();
    }
     public static Long square(Integer num)
     {
    	 return (long)(num*num*num);
     }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String num = request.getParameter("num");
		int number = Integer.parseInt(num);
	
		    PrintWriter pw = response.getWriter();
		    pw.println("<html><body text=red>");
			pw.println("<h1>Square Of The Number:  "+square(number)+" "+"</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("input.html");
			rd.include(request, response);
		    pw.println("</body></html>");
		
	}

}















