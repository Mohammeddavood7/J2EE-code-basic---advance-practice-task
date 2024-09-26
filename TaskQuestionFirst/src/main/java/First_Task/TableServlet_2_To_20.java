package First_Task;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class TableServlet_2_To_20
 */
public class TableServlet_2_To_20 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public TableServlet_2_To_20() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
	     PrintWriter p = response.getWriter();	
	     p.println();
	     response.setContentType("text/html");
	     for(int i = 1 ; i <= 10; i++)
	     {
	    	 for(int j = 2 ; j <= 20 ;j++)
	    	 {
	    		p.print(j+" * "+i+" = "+(j*i)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	    	 } 
	    	 p.print("<br>");
	    	 
	     }
	     
	}

}












