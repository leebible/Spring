<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>JQuery와 bootstrap 사용 가능 페이지</h4>
<%
	
	String content = (String) request.getAttribute("content");

%>
<jsp:include page="<%=content %>"/>