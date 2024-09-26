package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       int count;
    /**
     * @see GenericServlet#GenericServlet()
     */
    public CountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		pw.println("Number of user views : "+ count++);
	}

}
