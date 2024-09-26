package com.login.validatefromdatabase;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("id");
		String s2 = request.getParameter("fname");
		String s3 = request.getParameter("lname");
		String s4 = request.getParameter("mail");
		String s5 = request.getParameter("phno");
		
		PrintWriter pw = response.getWriter();
		
		pw.println(s1);
		pw.println(s2);
		pw.println(s3);
		pw.println(s4);
		pw.println(s5);

		
		
		
		
		
	}

}
