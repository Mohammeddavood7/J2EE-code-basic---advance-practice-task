package sort.duplicate.max.unique;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/duplicate")
public class DuplicateServlet extends HttpServlet {
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
		PrintWriter p = response.getWriter();
		p.println("<html><body bgcolor=darkcyan text=white>");
		//1,2,1,3,4,2
		HashSet<Integer> duplicate = new HashSet<>();
		for(int j = 0 ;j < num.length-1; j++ )
		{
			for(int k = j+1 ; k < num.length; k++)
			{
				if(num[j] == num[k])
				{
					duplicate.add(num[j]);

				}
			}
		}
		p.println("<h1>"+duplicate+"</h1>");
		p.println("</body></html>");

		
		
		
		
	}

}




















