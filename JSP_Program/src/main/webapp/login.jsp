<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
<jsp:declaration>
    Connection con = null;
    public void jspInit() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SERVLET", "TIGER");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
</jsp:declaration>

<%
if(request.getMethod().equals("POST")) {
        String s1 = request.getParameter("name");
        String s2 = request.getParameter("pass");

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM USER_INFO WHERE NAME = ? AND PASS = ?");
            ps.setString(1, s1);
            ps.setString(2, s2);
            rs = ps.executeQuery();
            if(rs.next()) {
%>
                <h1>Login Successful</h1>
                <h1>Welcome <%= rs.getString(1) %></h1>
<%
            } else {
%>
                <h1>Login Failed</h1>
<%
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if(rs != null) rs.close(); } catch(SQLException e) { e.printStackTrace(); }
            try { if(ps != null) ps.close(); } catch(SQLException e) { e.printStackTrace(); }
        }
    }
%>
</body>
</html>
