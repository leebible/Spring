<%@page import="kr.or.ddit.vo.PersonVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 웹에서 기본 컨텐츠 타입으로 사용되는 HTML 컨텐츠를 생성하기 위한 view layer --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="detail"></div>
<form name="personForm" action="<%=request.getContextPath() %>/people.do" method="post">
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
	<% 
		List<PersonVO> people = (List) request.getAttribute("people");
		for(PersonVO once:people){
			%>
		<tr>
			<td><%=once.getId() %></td>
			<td><a href="javascript:;" onclick="clickHandler(event);" data-member-id="<%=once.getId()%>"><%=once.getName() %></a></td><%--javascript:;  : dummy script --%>
			<%--html은 대소문자를 구분하지 못하기 때문에 data-뒤에 camel표기법으로 이용하려면 memberId 이걸 member-id라고 하면 웹에서는 memberId로 보임!!!!!!! --%>
		</tr>
		<%
		}
	%>
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