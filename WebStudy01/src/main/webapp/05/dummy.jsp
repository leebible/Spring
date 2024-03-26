<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	 int max= 6;
	 String maxParam = request.getParameter("max");
	 if(maxParam!=null && !maxParam.isEmpty()){
		 try{
		 	max = Integer.parseInt(maxParam); //바로
		 	if(max<0) max=10;
		 }catch(NumberFormatException e){
			 response.sendError(HttpServletResponse.SC_BAD_REQUEST);//에러코드 :400
			 return;
		 }
	 }
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.odd{
	background-color : yellow;
}
.even{
	background-color : red;
}
</style>
</head>
<%!
	StringBuffer printNumber(int max){
		String liPtrn = "<li class='%s'>%d</li>";
		StringBuffer liTags = new StringBuffer();
		for(int i=1; i<=max; i++){
			boolean odd = i%2 ==1;
			String clzValue = odd ? "odd" : "even";
			liTags.append(String.format(liPtrn, clzValue,i));
		}
		return liTags;
	}

%>


<%-- 스크립틀릿 기호와 출력식만 가지고 1~10까지 li태그 출력 --%>
<%-- 짝수:빨간색, li태그에inline styleX --%>
<body>
<a href="?max=5">더미</a>
<img src="" />
<!-- max 파라미터를 받고, 해당 파라미터 만큼 li태그를 반복 생성. -->
<!-- 단, 파라미터가 없거나, 음수로 전달된 경우, 기본 10개의 li태그 생성 -->
<form>
	<input type="number" name="max" value="<%=max%>"/>
	<button type="submit">전송</button> <!-- 옵션종류 button, submit, reset -->
</form>



	<ul> 
		<%= printNumber(max) %>
	
		
	</ul> 
	
	
<%-- 	<ul>
<% 
	for(int i=1; i<11; i++){
		boolean odd = i%2 ==1;
		String clzValue = odd ? "odd" : "even";
		%>
		<li class="<%=clzValue %>"><%=i %></li>
	</ul>
	<% 
	}
%>	 --%>
</body>
</html>