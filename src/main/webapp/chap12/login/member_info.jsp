<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    String id = null;
    if ((session.getAttribute("id") == null) ||
            (!((String) session.getAttribute("id")).equals("admin"))) {
        out.println("<script>");
        out.println("location.href='loginForm.jsp'");
        out.println("</script>");
    }

    String info_id = request.getParameter("id");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Context init = new InitialContext();
        DataSource ds =
                (DataSource) init.lookup("java:comp/env/jdbc/servlet_jsp");
        conn = ds.getConnection();

        pstmt = conn.prepareStatement("SELECT * FROM member WHERE id=?");
        pstmt.setString(1, info_id);
        rs = pstmt.executeQuery();
        rs.next();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
</head>
<body>
<center>
    <table border=1 width=300>
        <tr align=center>
            <td>아이디 :</td>
            <td><%=rs.getString("id") %>
            </td>
        </tr>
        <tr align=center>
            <td>비밀번호 :</td>
            <td><%=rs.getString("pass") %>
            </td>
        </tr>
        <tr align=center>
            <td>이름 :</td>
            <td><%=rs.getString("name") %>
            </td>
        </tr>
        <tr align=center>
            <td>나이 :</td>
            <td><%=rs.getString("age") %>
            </td>
        </tr>
        <tr align=center>
            <td>성별 :</td>
            <td><%=rs.getString("gender") %>
            </td>
        </tr>
        <tr align=center>
            <td>이메일 주소 :</td>
            <td><%=rs.getString("email") %>
            </td>
        </tr>
        <tr align=center>
            <td colspan=2><a href="member_list.jsp">리스트로 돌아가기</a></td>
        </tr>
    </table>
</center>
</body>
</html>
