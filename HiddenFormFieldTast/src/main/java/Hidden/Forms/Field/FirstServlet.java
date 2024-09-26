package Hidden.Forms.Field;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/first")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("age");
		String s3 = request.getParameter("mobile");

		PrintWriter p = response.getWriter();
		
		p.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        div{\r\n"
				+ "            width: 500px;\r\n"
				+ "            background-color: cyan;\r\n"
				+ "            margin: auto;\r\n"
				+ "            padding: 20px;\r\n"
				+ "        padding-right: 40px;\r\n"
				+ "        }\r\n"
				+ "        input{\r\n"
				+ "            padding: 10px;\r\n"
				+ "        }\r\n"
				+ "        pre\r\n"
				+ "        {\r\n"
				+ "            font-size: x-large;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div>\r\n"
				+ "        <form action=\"first\" method=\"get\">\r\n"
				+ "       \r\n"
				+"<input type='hidden' name='name' value= "+s1+">"
				+"<input type='hidden' name='age' value= "+s2+">"
				+"<input type='hidden' name='mob' value= "+s3+">"
				
				+ "        <pre>Highest Degree : <input type=\"text\" name=\"degree\" ></pre>\r\n"
				+ "        <pre>Years Of Pass  : <input type=\"text\" name=\"year\" ></pre>\r\n"
				+ "        <pre>University     : <input type=\"text\" name=\"university\" ></pre>\r\n"
				+ "        <pre>            <input type=\"submit\" name=\"submit\" value=\"Submit\"></pre>\r\n"
				+ "    </form>\r\n"
				+ "    </div>\r\n"
				+ "    \r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mob = req.getParameter("mob");
		resp.setContentType("text/html");
		String degree = req.getParameter("degree");
		String year = req.getParameter("year");
		String university = req.getParameter("university");
		
		PrintWriter p = resp.getWriter();
		p.print(name+"<br>");
		p.print(age+"<br>");
		p.print(mob+"<br>");
		p.print(degree+"<br>");
		p.print(year+"<br>");
		p.print(university);
		
	}

}























