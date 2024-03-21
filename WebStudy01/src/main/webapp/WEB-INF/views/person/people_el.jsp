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
<div id="detail"></div>
<c:set value="${pageContext.request.contextPath }" var="cPath" scope="application" />
<form name="personForm" action="/people.do" method="post">
	<input type="text" name="who" />
</form>

<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${people }" var="once"> <!-- 임시블록변수 :  --> 
		<tr>
			<td>${once.id }</td>
			<td><a href="javascript:;" onclick="clickHandler(event);" data-member-id="${once.id }">${once.name }</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<script>

	
function clickHandler(event){
	event.preventDefault();
	let aTag = event.target;
	console.log(aTag.dataset.memberId);
	var memberId = aTag.dataset.memberId
	//document.personForm.who.value = aTag.dataset.memberId;
	//document.personForm.requestSubmit();
      fetch("<%=request.getContextPath() %>/people.do",{
      //메소드, 헤더, 바디 넣기
      method : 'POST',
      headers : {'Content-Type':'application/x-www-form-urlencoded'},
      body : 'who='+memberId
      })
      .then((response => {console.log(response) 
            return response.text()}))
      .then(data => {console.log(data);
      document.querySelector('#detail').innerHTML=data;})
      .catch(error => console.log(error))
	}
	

</script>
</body>
</html>