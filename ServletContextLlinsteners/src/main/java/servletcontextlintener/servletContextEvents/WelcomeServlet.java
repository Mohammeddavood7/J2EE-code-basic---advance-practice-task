package servletcontextlintener.servletContextEvents;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public WelcomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		HttpSession hs = request.getSession(false);
		String  name =(String) hs.getAttribute("names");

		PrintWriter pw = response.getWriter();
		pw.print("<html><body text=blue> <h1>");
		pw.println("Login successfully : "+name);
		pw.print(" </h1></body></html>");

	}

}
