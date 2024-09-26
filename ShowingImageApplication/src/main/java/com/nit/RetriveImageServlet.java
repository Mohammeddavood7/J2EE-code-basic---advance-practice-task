package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/getimage")
public class RetriveImageServlet  extends HttpServlet{

	private static final long serialVersionUID = -2930504765584659454L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String id = req.getParameter("id");
		PrintWriter pw = resp.getWriter();
		try
		{
			Connection con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from imgtable WHERE ID=?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				byte[] img = rs.getBytes(3);
				String base64 = Base64.getEncoder().encodeToString(img);
				
				pw.print(id1+"<br>");
				pw.print(name+"<br>");
				pw.print(" <img style='width:250px;height:400px;' src=\"data:image/png;base64, "+base64+" alt=\"Red dot\" />");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
