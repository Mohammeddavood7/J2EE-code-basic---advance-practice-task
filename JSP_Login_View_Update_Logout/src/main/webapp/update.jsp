<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="login.update.view.logout.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
   div{
            width: 400px;
            background-color: darkcyan;
            color: white;
            padding: 10px;
            padding-left: 20px;
            margin: auto;

        }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<% BeanOfPersonDetail ub=(BeanOfPersonDetail)session.getAttribute("login");%>
<form action="update" method="get">
            <pre>          <strong> <ins> Update Page </ins></strong></pre>
        <pre>User Identity [ID]    <input type="text" name="id" placeholder=<%=ub.getId() %>></pre>
        <pre>Enter New Password    <input type="text" name="password" placeholder=<%= "YourOldPassword:"+ub.getPassword() %>></pre>
        <pre>                          <input type="submit" value="Submit"></pre>
    </form>
    </div>
</body>
</html>