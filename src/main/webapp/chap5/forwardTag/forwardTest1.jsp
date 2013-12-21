<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%request.setCharacterEncoding("euc-kr"); %>
<html>
<body>
<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
    <jsp:param name="tel" value="034-1234-5678"/>
</jsp:forward>
</body>
</html>
