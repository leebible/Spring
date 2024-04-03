<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/includee/preScript.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- SSR방식 -->
<!-- View : BootStrap, Jquery -->
<table class="table table-bordered table-striped"> <!-- 부트스트랩 적용 -->
	<thead class="table-dark">
		<tr>
			<th>상품코드</th>
			<th>거래처코드(거래처명)</th>
			<th>분류코드(분류명)</th>
			<th>상품명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>마일리지</th>
			<th>입고일</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<tr>
					<td>
<!-- 					/prod/prodDetail.do?what=P101000001 -->
					<c:url value="/prod/prodDetail.do" var="detailUrl">
						<c:param name="what" value="${prod.prodId}" />
					</c:url>
					<a href="${detailUrl }">${prod.prodName }</a>
					</td>
					<td>${prod.buyer.buyerName }</td>
					<td>${prod.lprod.lprodNm }</td>
					<td>${prod.prodName }</td>
					<td>${prod.prodCost }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodMileage }</td>
					<td>${prod.prodInsdate }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="8">상품 정보가 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
	



</table>
<script src="${pageContext.request.contextPath}/resources/js/member/memberList.js"></script>
<jsp:include page="/WEB-INF/includee/postScript.jsp"/>
</body>
</html>