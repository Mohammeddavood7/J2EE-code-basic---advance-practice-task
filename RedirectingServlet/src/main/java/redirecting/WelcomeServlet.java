package redirecting;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public WelcomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		/*Cookie c[] = request.getCookies();
		String name = c[0].getName();*/
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body text=blue> <h1>");
		pw.println("Login successfully : "+request.getParameter("name"));
		pw.print(" </h1></body></html>");

	}

}
