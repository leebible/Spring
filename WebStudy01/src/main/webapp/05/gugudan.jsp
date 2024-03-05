<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int min=1;
	int max=1;
	String minDan = request.getParameter("min");
	String maxDan = request.getParameter("max");
	if(minDan!=null && !minDan.isEmpty() && maxDan!=null && !maxDan.isEmpty()){
		try{
		min = Integer.parseInt(minDan);
		max = Integer.parseInt(maxDan);
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
	void gugudan(int min, int max){
		if(min<1||min>10||max<1||max>10)
			throw new IllegalArgumentException("1부터 10 사이의 피연산자만 처리 가능"); 
		if(max<min)
			throw new IllegalArgumentException("Max보다 Min이 크면 안됩니다.");
}


%>
<form>
	<input type="number" name="min" min="1" max="9" />
	<input type="number" name="max" min="1" max="9" />
	<button type="submit">전송</button>
</form>

<body>

<table>
	<%
	try{
	gugudan(min,max);
	for(int i=0; i<=(max-min); i++){ %>
	<tr>
		<th><%=min+i %>단</th>
		<% for(int j=1;j<10;j++) {
			int sum=(min+i)*j;
			%>
		<td><%=(min+i) %>*<%=j %>= <%=sum %></td>
		<%
		}
	}
	}catch(IllegalArgumentException e){
		response.sendError(400, e.getMessage());
	}
		%>
	</tr>
</table>
</body>
</html>