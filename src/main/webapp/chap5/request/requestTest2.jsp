<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@page import="java.util.Enumeration" %>
<html>
<head>
    <title>Request Test2</title>
</head>
<body>
<h1>������� ����</h1>
<table border="1">
    <tr>
        <td>����̸�</td>
        <td>�����</td>
    </tr>
    <%
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String headerName = (String) e.nextElement();
    %>
    <tr>
        <td><%=headerName %>
        </td>
        <td><%=request.getHeader(headerName) %>
        </td>
            <%}%>
</table>
</body>
</html>
