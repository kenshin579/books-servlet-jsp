<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "INSERT INTO student (num, name) VALUES (12,'Frank')";
    String sql2 = "SELECT * FROM student WHERE num=11";
    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();

        conn.setAutoCommit(false);

        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();

        pstmt = conn.prepareStatement(sql2);
        rs = pstmt.executeQuery();

        // num11�� �������� ������ rollback
        if (!rs.next()) {
            conn.rollback();
            out.println("<h3>������ ���Կ� ������ �߻��Ͽ� �ѹ��Ͽ����ϴ�.</h3>");
        } else {
            conn.commit();
            out.println("<h3>������ ������ ��� �Ϸ�Ǿ����ϴ�.</h3>");
        }
        pstmt.close();
        conn.setAutoCommit(true);
    } catch (Exception e) {
        out.println("<h3>������ ���Կ� �����Ͽ����ϴ�.</h3>");
        e.printStackTrace();
    }
%>
