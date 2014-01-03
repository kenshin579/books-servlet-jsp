<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%
    Connection conn = null;
    String sql = "INSERT INTO student (num,name) VALUES (6,'홍길동')";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();
        Statement stmt = conn.createStatement();

        int result = stmt.executeUpdate(sql);
        if (result != 0) {
            out.println("<h3>레코드가 등록되었습니다.</h3>");
        }
    } catch (Exception e) {
        out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
        e.printStackTrace();
    }
%>
