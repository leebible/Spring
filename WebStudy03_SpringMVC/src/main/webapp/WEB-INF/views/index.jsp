<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!-- 로그인 여부(authMember)를 판단하고,  -->
<!-- 로그인 된 경우, 해당 사용자의 이름을 출력. -->
<!-- 로그인 전인 경우, 로그인 페이지로 이동할 수 있는 a 태그 출력. -->
<h4>Principal : ${pageContext.request.userPrincipal }</h4>
<c:set value="${pageContext.request.userPrincipal }" var="principal"/>
<c:choose>
	<c:when test="${not empty principal }">
		
	</c:when>
	<c:otherwise>
		<a href="<c:url value='/login/loginForm.jsp'/>">로그인폼</a>
		<a href="<c:url value='/member/memberInsert.do'/>">가입하기</a>
	</c:otherwise>
</c:choose>

















