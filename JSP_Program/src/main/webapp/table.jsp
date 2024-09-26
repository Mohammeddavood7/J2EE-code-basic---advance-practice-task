<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% for(int i = 1 ; i <= 100 ; i++) {%>


	<table border=5px>
	              <tr> <td> <%= 2 %></td>
	                    <td> x </td>
	                    <td> <%= i %> </td>
	                    <td> = </td>
	                    <td> <%= i*2 %> </td>
	              </tr> 
	</table>

<% } %>
</body>
</html>