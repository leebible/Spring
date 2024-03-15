<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/sessionDesc.jsp</title>
</head>
<body data-context-path="<%=request.getContextPath() %>">
<h4>session(HttpSession)</h4>
<pre>
	세션 ???
	connectFull : connection 과 session 이 동일한 의미의 통로로 정의됨 
	connectLess(HTTP) : 시간으로 정의됨. 
				한 세션이 시작되고, 해당 세션 내에서 더이상의 명령이 발생하지 않을때까지의 기간.
				timeout 이란, 마지막 요청이 발생하고, 이후 새로운 요청이 발생할때까지 시간의 간격.
				
	세션의 생명주기
	시작 : 특정 클라이언트가 최초의 요청을 발생시키면 세션 시작. ==> 세션 아이디가 부여됨.
		세션 아이디 : <%=session.getId() %>
		세션 생성 시점 : <%= new Date(session.getCreationTime())%>
		세션 timeout : <%=session.getMaxInactiveInterval() %>s <!-- return 타입이 int. 초단위라는 의미! -->
		세션 내에서 마지막 요청시점 : <%= new Date(session.getLastAccessedTime()) %> <!-- long이면 시간단위는 밀리세컨드 -->
		유지방법(tracking mode) : 클라이언트가 서버가 동일한 세션 아이디를 공유
			1) COOKIE
			2) URL : <a href="sessionDesc.jsp;jsessionid=<%=session.getId() %>">엣지(쿠키없음.)에서 세션 유지</a> <!-- ; : 매트릭스변수 -->
			3) SSL : secure socket layer 구조를 이용해 전송되는 모든 데이터를 암호화하는 방식.
	종료
		timeout 이내에 새로운 요청이 발생하지 않는 경우. ==> dummy session이 남게됨 //30분 지나면 종료 되는거 혹은 사용자가 브라우저를 끄는것..
		직접 세션을 invalidation 시키는 경우.(로그아웃에 적용)
		<%
			//session.invalidate();
		%>
</pre>
<h4>세션 타이머 : 
<span id="time-area" data-ts-timeout="<%=session.getMaxInactiveInterval() %>"></span></h4>
<span id="time-area" data-ts-timeout="180"></span></h4>
<button id="stopBtn">STOP</button>


<script src="<%=request.getContextPath()%>/resources/js/app/11/sessionDesc.js"></script>


<script>
//내가 짜려고 시도한 js
<%-- let span = window['time-area'];
let div = window['msg-area'];
window.onload=function(){
	
div.style.display="none";
let count=120;

var min = 0;
var sec = 0;

setInterval(function(){
--count;
min = parseInt(count/60);
sec = count%60 < 10 ? '0'+count%60 : count%60;
console.log(min+':'+sec)		
span.innerHTML=min+':'+sec

if(count==115){
	div.style.display="block";
}
},1000);

}


	
	
document.getElementById("yesBtn").addEventListener("click", function(){
fetch('<%=request.getContextPath()%>/11/sessionDesc.jsp')
	.then(function(resp){
		if(resp.ok) console.log("성공")
	})
	

	
});
 --%>
</script>
</body>
</html>