package order;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Order_DAO 
{
	public static void receivedOrderDetails(HttpServletRequest request,HttpServletResponse response)
	{
		
		
		String name = request.getParameter("name");
		String crust = request.getParameter("crust");
		
		String[] topping = request.getParameterValues("topping");
		
		

        String apt = request.getParameter("apt");
	
		String address = request.getParameter("address");
		String c1 = request.getParameter("visa");
		String c2 = request.getParameter("mastercard");
		String c3 = request.getParameter("americanexpress");
        String creditCard = c1+" "+c2+" "+c3;
        String[] credit = creditCard.split(" ");
        
        String creditCardType = "";
        
        for(String creditcard : credit)
        {
        	if(creditcard != null)
        	{
        		creditCardType = creditcard;
        		break;
        	}
        }
		String cn = request.getParameter("creditcard");
		String rcn = request.getParameter("repeatcreditcard");
		
		BeanOfOrder boo = new BeanOfOrder();
		boo.setCustomerName(name);
		boo.setCrust(crust);
		boo.setToppings(Arrays.toString(topping));
		boo.setAppetizer(apt);
		boo.setAddress(address);
		boo.setCreditCard(creditCardType);
		boo.setCreditCardNumber(cn);
		boo.setRepeatCreditCardNumber(rcn);
		
		request.setAttribute("BeanOfOrder", boo);

        try {
			request.getRequestDispatcher("orderdetails.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	
		
		
	}

}
