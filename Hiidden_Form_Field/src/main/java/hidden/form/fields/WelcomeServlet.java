package hidden.form.fields;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	
		response.setContentType("text/html");
		String name = request.getParameter("name");
		PrintWriter pw = response.getWriter();
		pw.print("<html><body text=blue> <center><h1>");
		pw.println("Login successfully : "+name);
		pw.print(" </h1></center></body></html>");

	}

}
