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
<h1 align="center"><%=dog.getKind() %>의 정보</h1>
<table align="center" width="600">
    <tr bgcolor="orange">
        <td align="right">조회수 :<%=dog.getReadcount() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="dogCartAdd.dog?id=<%=dog.getId()%>">장바구니 담기</a>
    </tr>
</table>

<table align="center" width="600">
    <tr>
        <td rowspan="7"><img src="<%=dog.getImage() %>.jpg"/></td>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <td>종류 : <%=dog.getKind() %>
        </td>
    </tr>

    <tr>
        <td>출생지: <%=dog.getCountry() %>
        </td>
    </tr>
    <tr>
        <td>가격: <%=dog.getPrice()%>
        </td>
    </tr>
    <tr>
        <td>평균신장: <%=dog.getHeight()%>
        </td>
    </tr>
    <tr>
        <td>평균몸무게: <%=dog.getWeight()%>
        </td>
    </tr>
    <tr>
        <td>특징: <%=dog.getContent()%>
        </td>
    </tr>
    <tr>

    <tr>
        <td colspan="2" align="center"><a href="dogList.dog">목록보기</a></td>
    </tr>

</table>
</body>
</html>