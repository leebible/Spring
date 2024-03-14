<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String message = (String) request.getAttribute("message"); //Parameter는 String으로 전송이 되지만 Attribute는 Object로 전달됨
if(message!=null && !message.isEmpty()){ //문자열이기 때문에 null과 isempty 둘다 해줘야함
%>
<script>
	alert("<%=message%>");
</script>
<%
}
%>


</head>
<body>

<form action="<%=request.getContextPath() %>/login/loginProcess.do" method="post" enctype="application/x-www-form-urlencoded">
<%
	String paramId = Optional.ofNullable(request.getParameter("memId"))
							.orElse("");
%>
	<input type="text" name="memId" placeholder="아이디" value="<%=paramId%>"/>
	<input type="password" name="memPass" placeholder="비밀번호"/>
	<button type="submit">로그인</button>
</form>
</body>
</html>