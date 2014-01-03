<%@page import="project.DogShop.vo.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script>
        function checkQty(kind, qty) {
            if (qty != 1) {
                location.href = "dogCartQtyDown.dog?kind=" + kind;
            }
            else {
                return;
            }
        }
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<%
    ArrayList<Cart> cartList = (ArrayList<Cart>) request.getAttribute("cartList");
    int totalMoney = (Integer) request.getAttribute("totalMoney");
%>
<h1 align="center"><font color="black"><font size=15> 장바구니</font></font></h1>
<table width="600" align="center">
    <tr>
        <td align="right"><a href="dogList.dog">쇼핑계속하기</a></td>
    </tr>
</table>
<%
    if (cartList.size() == 0) {
%>
<h1 align="center">상품이 존재하지 않습니다.</h1>
<%
} else {
%>
<form action="dogCartRemove.dog" method="post" name="myForm">
    <table align="center" width="600" border="1">
        <tr align="center" bgcolor="orange">
            <td>번호</td>
            <td>상품이미지</td>
            <td>상품명</td>
            <td>가격</td>
            <td>수량</td>
            <td align="center">
                <input type="submit" name="delete" value="삭제"/>

            </td>

        </tr>

        <%
            int num = 1;
            for (int i = 0; i < cartList.size(); i++) {
        %>
        <tr align="center">
            <td><%=num++ %>
            </td>
            <td><img src="<%=cartList.get(i).getImage() %>.jpg" width="70" height="70"/></td>
            <td><%=cartList.get(i).getKind() %>
            </td>
            <td><%=cartList.get(i).getPrice() %>
            </td>
            <td>
                <a href="dogCartQtyUp.dog?kind=<%=cartList.get(i).getKind() %>">
                    <img src="images/up.jpg" width="15" height="15" border="0"/>
                </a>
                <br>
                <%=cartList.get(i).getQty() %><br>
                <a href="javascript:checkQty('<%=cartList.get(i).getKind() %>',<%=cartList.get(i).getQty() %>)">
                    <img src="images/down.jpg" width="15" height="15" border="0"/>
                </a>
                <br>
            </td>
            <td align="center">
                <input type="checkbox" name="delete" value="<%=cartList.get(i).getKind()%>"/>
            </td>
        </tr>

        <%
            }
        %>
    </table>
</form>
<table align="center" width="600" border="0">
    <tr align="center" bgcolor="yellow">
        <td align="right" colspan="6"><font color="gray" size="5">총 결제금액 : </font><font color="black"
                                                                                        size="8"><%=totalMoney%>원</font>
        </td>
    </tr>
</table>
<%
    }
%>
</body>
</html>