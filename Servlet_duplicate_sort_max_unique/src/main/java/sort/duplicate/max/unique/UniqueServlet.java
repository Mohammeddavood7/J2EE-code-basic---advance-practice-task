package sort.duplicate.max.unique;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/unique")
public class UniqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String numbers = request.getParameter("numbers");
		String[] number = numbers.split(",");
		HashSet<Integer> hs = new HashSet<>();
		for(String n : number)
		{
			hs.add(Integer.parseInt(n));
		}
		PrintWriter p = response.getWriter();
		p.println("<html><body bgcolor=darkcyan text=white>");
		p.println("<h1>Unique Number</h1>");
        p.println("<h1>"+hs+"<br>"+"</h1>");
		p.println("</body></html>");
	}

}


















