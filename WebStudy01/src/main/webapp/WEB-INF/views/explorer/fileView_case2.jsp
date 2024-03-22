<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp" />
<style>
    .folder {
        text-decoration: underline;
        color: blue;
    }
</style>
</head>
<body data-context-path="${pageContext.request.contextPath }">
<div class="row">
<ul class="col-6"> 
   <c:forEach var="wrapper" items="${wrapperList }">
   		<li id="${wrapper.path }" class="${wrapper.file?'file':'folder' }">
   			<c:choose>
   				<c:when test="${wrapper.folder }">
					<c:url value="/case2/serverFile" var="fileURL">
		   				<c:param name="base" value="${wrapper.path }"/>
			   		</c:url>
			   		<a data-click="all" data-dblclick="folder" href="${fileURL }">
			   		${wrapper.name }
			   		</a>
   				</c:when>
   				<c:otherwise>
   					${wrapper.name }
   				</c:otherwise>
   			</c:choose>
   		</li>
   </c:forEach>
</ul>
<div data-url="<c:url value='/case2/fileInfo' />" id="right-area" class="card col-6">
</div>
</div>uyyyyh
<script src=" <c:url value='/resources/js/app/explorer/fileView_case2.js' /> "></script>

<jsp:include page="/WEB-INF/includee/postScript.jsp" />
</body>
</html>