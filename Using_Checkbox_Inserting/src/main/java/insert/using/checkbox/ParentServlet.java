package insert.using.checkbox;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import Data.Access.Object.BeanOfPersonDetails;
import Data.Access.Object.PersonDetails_DAO;
import Data.Access.Object.connectToDataBase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/parent")
public class ParentServlet extends HttpServlet 
{
   Connection con ;
	private static final long serialVersionUID = 1L;
       
    
    public ParentServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
	   con = connectToDataBase.dataBaseConnection();
		
	}

	public void destroy()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
            BeanOfPersonDetails person = new BeanOfPersonDetails();
            person.setName(request.getParameter("name"));
			person.setId(Integer.parseInt(request.getParameter("age")));
			person.setMobile(Long.parseLong(request.getParameter("mobile")));
			person.setGender(request.getParameter("gender"));
			String h1 = request.getParameter("h1");
			String h2 = request.getParameter("h2");
			String h3 = request.getParameter("h3");
			String h4 = request.getParameter("h4");
			
			StringBuilder sb = new StringBuilder();
			StringBuilder append = sb.append(h1+",").append(h2+",").append(h3+",").append(h4);
			String str = new String(append);
			String[] split = str.split(",");
			
			String hob = "";
			
			for(String s : split)
			{
				if(!s.equals("null"))
				{
					hob = hob+" "+s;
				}
				
				
			}
			person.setHobbies(hob);
			int updateNumber = PersonDetails_DAO.insertPersonDetails(person);
			PrintWriter pw = response.getWriter();
			pw.println("<html><body bgcolor=white text=blue>");
			RequestDispatcher requestDispatcher;
			if(updateNumber > 0)
			{
				 requestDispatcher = request.getRequestDispatcher("registration.html");
				 requestDispatcher.include(request, response);
				 pw.println("<h1>You Have Successfully Registered</h1>");
			}
			else
			{
				 pw.println("<h1 bgcolor=white text=red>Not Registered,Something Went Wrong Do Again</h1>");
			}
			pw.println("</body></html>");

			
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		
		
	}

}
















