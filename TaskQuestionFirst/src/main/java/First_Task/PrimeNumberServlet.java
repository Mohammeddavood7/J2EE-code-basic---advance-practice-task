package First_Task;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class PrimeNumberServlet
 */
public class PrimeNumberServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public PrimeNumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		pw.println();
		
		
	           int count = 0;
		        int num = 2; 


		        while (count < 4)
		        {
		            boolean isPrime = true;

		            for (int i = 2; i <= num/2; i++) 
		            {
		                if (num % i == 0) 
		                {
		                    isPrime = false;
		                    break;   
		                }
		            }

		            
		            if (isPrime)
		            {
		                pw.print(num+ " ");
		                count++;
		            }

		            num++;
		        }
   }
		

		
		
			
			
		
	}











