package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class TimeServlet
 */
public class DateServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public DateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		Date d = new Date();
	    pw.println("<html><head><meta http-equiv='refresh' content='1'></head><body bgcolor='red' text='white' align='center'>");
	    pw.println(d.getHours()+" : "+d.getMinutes()+" : "+d.getSeconds());
	    pw.println("</html></body>");

	}
	

}










