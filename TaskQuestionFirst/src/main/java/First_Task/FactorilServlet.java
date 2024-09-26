package First_Task;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class FactorilServlet
 */
public class FactorilServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FactorilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		int num = 5;
		int mul = 1;
		int c = 0;
		
		int arr[] = new int[num];
 		for(int i = 1; i <= num ; i++)
		{
		    arr[c++] = mul*=i;
		}
 		for(int i = arr.length-1; i >=0 ; i-- )
 		{
 			pw.print(arr[i]+" ");
 		}
 	   
 		
	}

}
















