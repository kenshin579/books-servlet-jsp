<%@page import="vo.Dog" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<%
    Dog dog = (Dog) request.getAttribute("dog");
%>
<h1 align="center"><%=dog.getKind() %>�� ����</h1>
<table align="center" width="600">
    <tr bgcolor="orange">
        <td align="right">��ȸ�� :<%=dog.getReadcount() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="dogCartAdd.dog?id=<%=dog.getId()%>">��ٱ��� ���</a>
    </tr>
</table>

<table align="center" width="600">
    <tr>
        <td rowspan="7"><img src="<%=dog.getImage() %>.jpg"/></td>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <td>���� : <%=dog.getKind() %>
        </td>
    </tr>

    <tr>
        <td>�����: <%=dog.getCountry() %>
        </td>
    </tr>
    <tr>
        <td>����: <%=dog.getPrice()%>
        </td>
    </tr>
    <tr>
        <td>��ս���: <%=dog.getHeight()%>
        </td>
    </tr>
    <tr>
        <td>��ո�����: <%=dog.getWeight()%>
        </td>
    </tr>
    <tr>
        <td>Ư¡: <%=dog.getContent()%>
        </td>
    </tr>
    <tr>

    <tr>
        <td colspan="2" align="center"><a href="dogList.dog">��Ϻ���</a></td>
    </tr>

</table>
</body>
</html>