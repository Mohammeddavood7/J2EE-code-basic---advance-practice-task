<%@ page import="java.time.*" contentType="application/vnd.ins-excel"%>
<%@ include file = "count.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><% LocalTime lt = LocalTime.now(); %></h1>
<h1><%= lt %></h1>
<h1><%= LocalTime.now() %></h1>
</body>
</html>