<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%
    Connection conn = null;
    String sql = "INSERT INTO student (num,name) VALUES (?,'ȫ�浿')";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        for (int i = 7; i <= 10; i++) {
            stmt.setInt(1, i);
            if (stmt.executeUpdate() != 0) {
                out.println("<h3>" + i + "�� ���ڵ带 ����Ͽ����ϴ�.</h3>");
            }
        }
    } catch (Exception e) {
        out.println("<h3>���ڵ� ��Ͽ� �����Ͽ����ϴ�.</h3>");
        e.printStackTrace();
    }
%>
