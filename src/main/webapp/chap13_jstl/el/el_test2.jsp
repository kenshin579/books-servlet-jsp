<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%
    request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
    <title>EL 내장객체 사용 예제</title>
</head>
<body>
<h3>${sessionScope.test}</h3>

<h3>${param.name }</h3>
</body>
</html>
