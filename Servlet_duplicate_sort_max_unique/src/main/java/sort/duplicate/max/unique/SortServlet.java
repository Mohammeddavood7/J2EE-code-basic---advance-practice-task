package sort.duplicate.max.unique;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sort")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String numbers = request.getParameter("numbers");
		String[] number = numbers.split(",");
		int num [] = new int[number.length];
		int i = 0;
		for(String n : number)
		{
			num[i++] = Integer.parseInt(n);
		}
		Arrays.sort(num);
		PrintWriter p = response.getWriter();
		
		p.println("<html><body bgcolor=darkcyan text=white>");
		p.println("<h1>Sorted Order</h1>");
		  for(int j = 0 ; j < num.length ; j++)
		  {
			  p.println(num[j]+"<br>");
		  }
		p.println("</body></html>");
		
		
	}

}














