<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	 int num= 5;
	 String maxParam = request.getParameter("num");
	 if(maxParam!=null && !maxParam.isEmpty()){
		 try{
		 	num = Integer.parseInt(maxParam); //바로
		 	if(num<0 || num>10) num=5;
		 	
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
</head>
<%!
	int sigma(int num){
	int sum=0;
		for(int i=1; i<=num; i++){
			sum+=i;
		}
		return sum;
	}

	int factorial(int num){
		int sum=1;
		for(int i=1; i<=num; i++){
			sum*=i;
		}
		return sum;
	}

%>
<body>
<form> <!-- action을 안줘도 기본값 들어가있음 -->
<!-- 네? -->
	<input type="number" name="num" min="1" max="10" value="<%=num %>" />
	<button type="submit">전송</button>
</form>
<h4>누적 합 : <%=sigma(num) %></h4> <!-- 시그마 연산 -->
<h4>누적 곱 : <%=factorial(num) %></h4> <!-- 팩토리얼 연산 -->
</body>
</html>