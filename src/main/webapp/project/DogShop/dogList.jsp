<%@page import="project.DogShop.vo.Dog" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
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
    List<Dog> dogs = (List<Dog>) request.getAttribute("dogs");
//request : ���� ��ü : jsp ��ü���� �����Ǵ� ���� ��ü
    int num = 1;
%>
<h1 align="center"> ������ ���</h1>

<P></P>
<table align="center">
    <%
        if (dogs != null) {
    %>
    <tr>
        <%
            for (int i = 0; i < dogs.size(); i++) {
                Dog dog = dogs.get(i);
        %>

        <td>
            <a href="dogView.dog?id=<%=dog.getId()%>"><img src="<%=dog.getImage()+".jpg"%>" height="100" width="100"
                                                           border="0"></a><br>
            ��ǰ�� : <%=dog.getKind() %><br>���� : <%=dog.getPrice() %>��
        </td>
        <%
            if (i == 0 || i % 4 != 0) {
                continue;
            } else {
        %>
    </tr>
    <tr>
            <%
	}
}
%>
    <tr>
            <%
}
%>
</table>
<br><br>

<h1 align="center">���� �� �� ��ǰ</h1>
<table align="center" width="600">
    <tr>
        <%
            ArrayList<String> images =
                    (ArrayList<String>) request.getAttribute("images");
            if (images != null & images.size() > 0) {
                for (int i = 0; i < images.size(); i++) {
        %>
        <td align="center">
            <img src="<%=images.get(i)+".jpg"%>">
        </td>
        <%
                }
            }
        %>
    </tr>
</table>
</body>
</html>