<%@ page import="order.BeanOfOrder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String name,crust,topping,appetizer,address,cr,cn,rcn; %>
<%
BeanOfOrder boo = (BeanOfOrder)request.getAttribute("BeanOfOrder");
 name = boo.getCustomerName();
 crust = boo.getCrust();
 topping = boo.getToppings();
 appetizer = boo.getAppetizer();
 address = boo.getAddress();
 cr = boo.getCreditCard();
 cn = boo.getCreditCardNumber();
 rcn = boo.getRepeatCreditCardNumber();
%>     
  <h1>Your Order Successfully Placed  Details</h1>
		<table border="5px">
		 <caption>Your Order Details</caption>
		 <tr>
		     <th>Name</th> <td><%=name %></td>
		 </tr>
		 <tr>
		     <th> crust</th> <td><%=crust%></td>
		 </tr>
		 <tr>
		     <th> topping</th> <td><%=topping%></td>
		 </tr>
		 <tr>
		     <th> appetizer</th> <td><%=appetizer%></td>
		 </tr>
		 <tr>
		     <th> address</th> <td><%=address%></td>
		 </tr>
		 <tr>
		     <th>Credit Card</th> <td><%=cr%></td>
		 </tr>
		 <tr>
		     <th>CreditCard Number </th> <td><%=cn%></td>
		 </tr>
		 <tr>
		     <th>Repeated CreditCard Number</th> <td><%=rcn%></td>
		 </tr>
		 
		</table>
</body>
</html>