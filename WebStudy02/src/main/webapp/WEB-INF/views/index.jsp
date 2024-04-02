<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 여부(authMember)를 판단하고, -->
<!-- 로그인 된 경우, 해당 사용자의 이름을 출력. -->
<!-- 로그인 전인 경우, 로그인 페이지로 이동할 수 있는 a태그 출력. -->
<h4>Principal : ${pageContext.request.userPrincipal } </h4>
<c:choose>
	<c:when test="${not empty sessionScope.authMember }">
		<a href="<c:url value='/mypage'/>">${authMember.memName}</a>
		<form id="logoutForm" method="post"></form>
		<a href="<c:url value='/login/logout.do'/>" class="logoutBtn" data-target-form="#logoutForm">로그아웃</a>
		
		<script type="text/javascript">
			document.querySelector('a[data-target-form]').addEventListener("click",function(e){
		//1.클릭이벤트 중단
			e.preventDefault();
		//2.위 form 찾아내기
		//3.submit. post 발생. form의 action 비어짐 
			let aTag = e.target;
			let formSelector = aTag.dataset.targetForm;
			let formTag = document.querySelector(formSelector);
				if(formTag){
					formTag.action = aTag.href;
					formTag.requestSubmit();
				}
			});
		</script>
	</c:when>
	<c:otherwise>
		<a href="<c:url value='/login/loginForm.jsp'/>">로그인폼</a>
		<a href="<c:url value='/member/memberInsert.do'/>">가입하기</a>
	</c:otherwise>
	
</c:choose>

</body>
</html>