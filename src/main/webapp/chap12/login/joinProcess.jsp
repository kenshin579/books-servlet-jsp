<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    request.setCharacterEncoding("euc-kr");
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();

        pstmt = conn.prepareStatement("INSERT INTO member VALUES (?,?,?,?,?,?)");
        pstmt.setString(1, id);
        pstmt.setString(2, pass);
        pstmt.setString(3, name);
        pstmt.setInt(4, age);
        pstmt.setString(5, gender);
        pstmt.setString(6, email);
        int result = pstmt.executeUpdate();

        if (result != 0) {
            out.println("<script>");
            out.println("location.href='loginForm.jsp'");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("location.href='joinForm.jsp'");
            out.println("</script>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
