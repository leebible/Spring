<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	 int num= 5;
	 String numStr = request.getParameter("num");
	 if(numStr!=null && !numStr.isEmpty()){
		 try{
		 num = Integer.parseInt(numStr);
		 }catch(NumberFormatException e){
			 response.sendError(400, e.getMessage());
			 return;
		 }
	 }
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
	long sigma(int num){ /* 재귀호출구조 */
		if(num < 1 || num > 10)
			throw new IllegalArgumentException("1부터 10 사이의 피연산자만 처리 가능");  /* 예외 */
		if(num==1) return 1;
		else
			return num + sigma(num-1);
		//sigma(1) = 1
		//sigma(2) = 2 + sigma(1)
		//sigma(3) = 3 + sigma(2)
	}
	long factorial(int num){
		if(num < 1 || num > 10)
			throw new IllegalArgumentException("1부터 10 사이의 피연산자만 처리 가능");  /* 예외 */
			/* 예외처리를 잘쓰면 조건문처럼 잘 쓸 수 있다!
			이런 검증을 안해주면 client가 조작했을경우 500에러가 뜨는데, 500에러면 개발자탓이기때문에 400처리가 나오게하도록 처리를 잘해줘야함*/
		if(num==1) return 1;
		else
			return num * factorial(num-1);
	}
%>

<body>
<form> <!-- action을 안줘도 기본값 들어가있음 -->
<!-- 네? -->
	<input type="number" name="num" min="1" max="10" value="<%=num %>" />
	<button type="submit">전송</button>
</form>
<%
try{
%>
<h4>누적 합 : <%=sigma(num) %></h4> <!-- 시그마 연산 -->
<h4>누적 곱 : <%=factorial(num) %></h4> <!-- 팩토리얼 연산 -->
<%
}catch(IllegalArgumentException e){
	response.sendError(400,e.getMessage());
}
%>
</body>
</html>