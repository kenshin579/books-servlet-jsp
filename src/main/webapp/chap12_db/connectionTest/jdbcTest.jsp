<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%
    Connection conn = null;

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/servlet_jsp";

    Boolean connect = false;

    try {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "root", "1234");

        connect = true;

        conn.close();
    } catch (Exception e) {
        connect = false;
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>JDBC ���� �׽�Ʈ ����</title>
</head>
<body>
<h3>
    <%if (connect == true) { %>
    ����Ǿ����ϴ�.
    <%} else { %>
    ���ῡ �����Ͽ����ϴ�.
    <%} %>
</h3>
</body>
</html>
