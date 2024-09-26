package basic;

import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream("D:\\HTML2024\\IMAGES2024\\kok.webp");
		int a = fis.available();
		byte[] b = new byte[a];
		fis.read(b);
		
		
		@SuppressWarnings("resource")
		FileInputStream fis1 = new FileInputStream("D:\\HTML2024\\IMAGES2024\\leo.webp");
        int ae = fis1.available();
        byte[] by = new byte[ae];
        fis1.read(by);
        
		
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
		sos.write(by);
		
	}

}







