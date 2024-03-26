<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/includee/preScript.jsp"/>
<style type="text/css">
	tr[data-mem-id]{
		cursor: pointer;
	}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body data-context-path="${pageContext.request.contextPath}">
<table class="table table-bordered table-striped"> <!-- 부트스트랩 적용 -->
	<thead class="table-dark">
		<tr>
			<th>회원명</th>
			<th>기본주소</th>
			<th>상세주소</th>
			<th>집전화</th>
			<th>휴대폰</th>
			<th>메일주소</th>
			<th>마일리지</th>
		</tr>
	</thead>
	
	<tbody>
		<c:if test="${not empty mlist }">
			<c:forEach items="${mlist }" var="once">
				<tr class="tb" data-mem-id="${once.memId }" data-bs-toggle="modal"  data-bs-target="#exampleModal">
					<td>${once.memName }</td>
					<td>${once.memAdd1 }</td>
					<td>${once.memAdd2 }</td>
					<td>${once.memHp }</td>
					<td>${once.memMail }</td>
					<td>${once.memMileage }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty mlist }">
			<tr>
				<td colspan="6">회원 정보가 없습니다.</td>
			</tr>
		</c:if>
		
	</tbody>
	
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


</table>
<script src="${pageContext.request.contextPath}/resources/js/member/member.js"></script>
<jsp:include page="/WEB-INF/includee/postScript.jsp"/>
</body>
</html>