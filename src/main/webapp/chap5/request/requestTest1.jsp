<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%--<%request.setCharacterEncoding("euc-kr");%>--%>
<html>
<head>
    <title>Request Test</title>
</head>
<body>
<h1>Request �����Դϴ�.</h1>
<table border="1" width="400">
    <tr>
        <td>�̸�</td>
        <td><%=request.getParameter("name") %>
        </td>
    </tr>
    <tr>
        <td>����</td>
        <td>
            <%if (request.getParameter("gender").equals("male")) {%>    ����
            <%} else {%>����<%} %>
        </td>
    </tr>
    <tr>
        <td>���</td>
        <td>
            <%
                String[] hobby = request.getParameterValues("hobby");
                for (int i = 0; i < hobby.length; i++) {
            %>
            <%=hobby[i] %>&nbsp;&nbsp;
            <%} %>
        </td>
    </tr>
</table>
</body>
</html>