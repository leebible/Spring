<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<style type="text/css">
			form{
				background-color : blue;
			}
		
		</style>
		<%
			String imageCookieValue = (String) request.getAttribute("imageCookieValue");
			if(StringUtils.isNotBlank(imageCookieValue)){
				%>
				<script>
					document.addEventListener("DOMContentLoaded",()=>{
						document.forms[0].name.value = "<%=imageCookieValue%>";
						document.forms[0].requestSubmit();
					});			
				</script>
				<%
				
			}
		%>
    <body>
        <form action="${pageContext.request.contextPath }/image.do" method="get">
            <select name="name">
            ${options }
            </select>
            <button type="submit">이미지 랜더링</button>
        </form>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/04/imageForm.js"></script>
        <script>
        
        </script>
    </body>
</html>
    