<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--코어태그 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="${pageContext.request.parameterMap.url[0] }" var="url"/>
<c:set value="${pageContext.request.parameterMap['view-source'][0] }" var="srcFlag"/>
<form>
	<input type="text" name="url" value="${url }" />
	<input type="checkbox" name="view-source" value="true" ${srcFlag ? 'checked' : ''}/>소스로보기
	<button type="submit">브라우징</button>
</form>

<div>
	<c:if test="${not empty url }">
		<c:import url="${url }" var="site" />
		<c:out value="${site }" escapeXml="${srcFlag eq true }" />
	</c:if>
</div>
<script>

</script>

</body>
</html>