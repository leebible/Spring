<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp" />
<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session"/>
</c:if>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/member/memberDelete.do" enctype="application/x-www-form-urlencoded">
		<table class="table table-bordered">
			<tr>
				<th>회원번호</th>
				<td><input type="text" name="memId" 
					value="${member.memId}" class="form-control" /><span
					class="text-danger">${errors.memId}</span></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="memPass" class="form-control" />
					<span class="text-danger">${errors.memPass}</span></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">삭제</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="/WEB-INF/includee/postScript.jsp" />
</body>
</html>













