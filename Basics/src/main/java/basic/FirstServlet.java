package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		
		
		  response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        pw.println("<html>");
	        pw.println("<head><title>Asterisk</title></head>");
	        pw.println("<body style='background-color:pink; color:black;'>");
	        pw.println("<h1>first servlet program</h1>");
	        pw.println("</body>");
	        pw.println("</html>");
		
	}

}
