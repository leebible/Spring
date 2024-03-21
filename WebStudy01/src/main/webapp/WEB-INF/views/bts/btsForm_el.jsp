<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp" />
</head>
<body>
<%-- <%
	Map<String, String[]> btsMap = (Map) application.getAttribute("btsMap");
	
%> --%>
<form method="post" name="btsForm"> 
	<select name="member" onchange="this.form.requestSubmit();" required>
		<option value>선택</option>
			<c:forEach items="${btsMap }" var="entry">
				<option value="${entry.key }" label="${entry.value[0]}"></option>
			</c:forEach>
	</select>
</form>
<div id="bts-area">

</div>
<%-- <script src="<%=request.getContextPath() %>/resources/js/bts/btsForm.js"></script> --%>
<script>
	document.btsForm.addEventListener("submit",(e)=>{ //구조분해문법
		e.preventDefault(); //동기요청 중단
		
		let form = e.target;
		let url = form.action;
		let method = form.method;
		let headers = { //property이름을 넣을때는 하이픈을 사용할수 없음. 연산배열구조로 써야함
			"content-type" : form.enctype,
			"accept" : "text/html"
		}
		
		lef formData = new FormData(form);
		let body = new URLSearchParams(formData).toString();
		fetch(url, {
			method:method,
			headers : headers,
			body : body
		}).then((resp)=>resp.text())
		.then(txt=>window['bts-area'].innerHTML = txt)
		.catch(e=>console.error(e));
		
	})
</script>
<jsp:include page="/WEB-INF/includee/postScript.jsp" />
</body>
</html>