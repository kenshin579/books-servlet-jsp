<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<p>페이지 영역의 속성 값은 한 페이지에서만 공유가 가능하므로 제대로 출력되지 않지만, request 영역은 하나의 요청을
    처리하는 영영역에서 공유가 가능하므로 속성 값이 출력된다.</p>

pageValue = <%=pageContext.getAttribute("pageScope") %><br>
requestValue = <%=request.getAttribute("requestScope") %>
</body>
</html>