package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class TableServlet
 */
public class TableServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public TableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        PrintWriter pw = response.getWriter();
        pw.println("<html><head>");
        pw.println("<style>");
        pw.println("table { border-collapse: solid; }");
        pw.println("td { border: 1px solid white; }");
        pw.println("</style>");
        pw.println("</head><body bgcolor='purple' text='white'>");
        pw.println("<table>");
        for(int i = 1; i <= 100; i++ )
        {
            pw.println("<tr>");
            pw.println("<td></td>");
            pw.println("<td> 5 </td>");
            pw.println("<td> x </td>");
            pw.println("<td>"+i+"</td>");
            pw.println("<td> = </td>");
            pw.println("<td>"+(i*5)+"</td>");
            pw.println("</tr>");
        }
        pw.println("</table>");
        pw.println("</body></html>");
    }



}
























