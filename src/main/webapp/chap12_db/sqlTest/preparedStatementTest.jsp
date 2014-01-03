<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%
    Connection conn = null;
    String sql = "INSERT INTO student (num,name) VALUES (?,'홍길동')";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        for (int i = 7; i <= 10; i++) {
            stmt.setInt(1, i);
            if (stmt.executeUpdate() != 0) {
                out.println("<h3>" + i + "번 레코드를 등록하였습니다.</h3>");
            }
        }
    } catch (Exception e) {
        out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
        e.printStackTrace();
    }
%>
