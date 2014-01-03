<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();

        pstmt = conn.prepareStatement("SELECT * FROM member WHERE id=?");
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            if (pass.equals(rs.getString("pass"))) {
                session.setAttribute("id", id);

                out.println("<script>");
                out.println("location.href='main.jsp'");
                out.println("</script>");
            }
        }

        out.println("<script>");
        out.println("location.href='loginForm.jsp'");
        out.println("</script>");
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
