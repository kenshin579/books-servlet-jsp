<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%
    session.setAttribute("test", "Session Test");
%>
<html>
<head>
    <title>EL 내장객체 사용 예제</title>
</head>
<body>
<form action="el_test2.jsp" method="post">
    <table border=1>
        <tr>
            <td>이름 :</td>
            <td><input type="text" name="name" value="홍길동"></td>
        <tr>
            <td colspan=2 align=center><input type="submit" value="입력"></td>
        </tr>
    </table>
</form>
</body>
</html>
