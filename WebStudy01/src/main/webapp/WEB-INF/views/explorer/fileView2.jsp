<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.folder{
		text-decoration: underline;
		color:blue;
	}
</style>
</head>
<body>

<ul>
	<c:forEach items="${fileList }" var="singleMap">
		<c:set value="${singleMap.file } " var="single"/>
		<li id="${singleMap.path }" class="${single.file?'file':'folder' }">${single.name }</li>
	</c:forEach>
</ul>	
	<ul>
		<c:forEach items="${fileMap }" var="entry">
		<c:set value="${entry.value }" var="single" />
			<li id="${entry.key }">${single.name }</li>
		</c:forEach>
	</ul>

<!-- 1/파일리스트는 request.scope안에 속성. el접근하기
2. 파일리스트 목록으로 대상으로 반복문. core태그 이용
3. 파일/클래스에 따라 다른 클래스네임이 부여되야함. 파일으 ㅣ조건에 따라 서로다른 값을 출력해야함(삼항연산자 필요)-->

</body>
<script >
document.addEventListener("dblclick",(e) =>{
	if(!e.target.class=='folder') return false;
	var base = e.target.id
	console.log(base)
	location.href=`?base=`+base
	
})

document.querySelectAll('.folder')
</script>
</html>