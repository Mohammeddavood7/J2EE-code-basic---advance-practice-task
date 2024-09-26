package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/imgUploadOnBD")
@MultipartConfig
public class UploadImageOnDatabaseServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/plain"); 

        try (PrintWriter p = response.getWriter()) 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Part part = request.getPart("image");

            if (part != null) 
            {
               
                    try (Connection con = DBConnect.getConnection();
                         PreparedStatement ps = con.prepareStatement("INSERT INTO IMGTABLE VALUES(?,?,?)")) 
                    {
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setBytes(3, part.getInputStream().readAllBytes());
                        int executeUpdate = ps.executeUpdate();
                        if (executeUpdate > 0) 
                        {
                            p.println("Image successfully stored in database");
                        }
                    }
                
            } 
            else 
            {
                p.println("No image provided");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}