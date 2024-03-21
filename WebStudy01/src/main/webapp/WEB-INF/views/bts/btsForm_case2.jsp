<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.BtsVO"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
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
	List<BtsVO> btsList = (List) request.getAttribute("btsList");
%> --%>
<!-- form의 name : document의 프로퍼티명으로 반영  -->
<!--  form에 action이 없을경우 브라우저의 상단의 주소로 반환함 -->
<form method="post" name="btsForm"> <!-- 액션이 없으면 똑같은방식으로 Get요청이 발생하는것. 메소드로 식별이 되어야함. -->
	<select name="member" onchange="this.form.requestSubmit();" required><!-- 멤버라는이름의 파라미터가 전송 --> <!-- select의 name :  form의 프로퍼티명으로 반영 -->
																<!-- boolean타입일땐 required="required" 오른쪽 값을 생략할수 있음. -->
		<option value>선택</option> <!-- prompt text -->
		<%-- 	<%
			for(BtsVO entry : btsList){
				pageContext.setAttribute("bts", entry);
			%> --%>
			<c:forEach items="${btsList }" var="bts"> <!-- 임시블록변수 :  --> 
				<option value="${bts.code }" label="${bts['name']},${bts['count'] }" /> 
			</c:forEach>
			<%-- <option value="<%=entry.getCode() %>" label="<%=entry.getName() %>, <%= entry.getCount() %>"></option> --%>
<%-- 		<%
		}
	%> --%>
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