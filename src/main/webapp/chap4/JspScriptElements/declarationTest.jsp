<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<h1><%=getStr() %>
</h1>
<%--
아래는 선언문
--%>

<%!
    private String getStr() {
        str += "테스트입니다.";
        return str;
    }

    private String str = "선언문 ";
%>