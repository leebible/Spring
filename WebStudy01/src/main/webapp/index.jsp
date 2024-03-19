<%@page import="org.apache.catalina.Role"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.catalina.users.MemoryUser"%>
<%@page import="java.security.Principal"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String message = request.getParameter("message");
	//if(message!=null && !message.isEmpty()){ //null체크와 blank체크.
	if(StringUtils.isNotBlank(message)){ 
		
%>
<script>
	alert("<%=message%>");
</script>
<%
	}
%>
</head>
<body>
	<h4>웰컴페이지</h4>
	<%
		
		MemoryUser principal = (MemoryUser)request.getUserPrincipal(); //JAAS프레임워크
		//Principal principal = request.getUserPrincipal(); //JAAS프레임워크
		//String authId = (String) session.getAttribute("authId");
		//if(authId!=null && !authId.isEmpty()){
		if(principal!=null) {
			StringBuffer roldNames = new StringBuffer();
			Iterator<Role> roles =  principal.getRoles(); //Roles : 한사람이 여러개의 롤을 부여받을수 있다는 뜻
			//반복문 열기. role에대한..현재사용자가 어떤 role을 갖고있따.....(오늘의 미션)
			%>
			<%--<%=authId %>님. --%>
			<%-- <%=principal.getClass() %> --%>
			<%=principal.getName() %> 님. [<%=roldNames %>]
			<form name="logoutForm" method="post">
				<a href="<%=request.getContextPath()%>/login/logout.do"
					onclick="clickHandler(event);">로그아웃</a>
			<script>
				function clickHandler(event){
					event.preventDefault();
					document.logoutForm.action = event.target.href;
					document.logoutForm.requestSubmit();
				}
			</script> 
			</form>
			<%
		}else{
			%>
			<a href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인</a>
			<%
		}
	%>
</body>
</html>