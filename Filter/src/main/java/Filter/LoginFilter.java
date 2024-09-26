package Filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/welcome")
public class LoginFilter extends HttpFilter implements Filter {
  
	private static final long serialVersionUID = 3086206282075781118L;

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		beanOfLogin login = Login_RegistrationDAO.login1(request);
		
		PrintWriter p = response.getWriter();
		p.println("<html><body><center>");
		if(login != null)
		{
		   p.println("Welcome LoginFilter ");
		}
		else
		{
			p.println("invalid username/password");
		}
		p.println("</center></body></html>");
		chain.doFilter(request, response);
	}
}



















