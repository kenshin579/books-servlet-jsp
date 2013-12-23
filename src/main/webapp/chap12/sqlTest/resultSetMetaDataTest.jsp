<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%
    Connection conn = null;
    String sql = "SELECT * FROM student";

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        out.println("컬럼 수 : " + rsmd.getColumnCount() + "<br>");
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            out.println(i + "번째 컬럼의 이름 : " + rsmd.getColumnName(i) + "<br>");
            out.println(i + "번째 컬럼의 타입 이름 : " + rsmd.getColumnTypeName(i) + "<br>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
