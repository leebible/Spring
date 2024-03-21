<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12/cookieDesc.jsp</title>
</head>
<body>
<h4>Cookie</h4>
<pre>
	Http : ConnectLess, StateLess
	? Http가 가진 stateless 특성의 단점을 보완하기 위해 최소한의 상태 정보를 클라이언트 사이드에 저장하는 구조.
	** 쿠키 사용 방법
	1. 쿠키 생성(name/value)
	2. 쿠키의 부가 옵션 설정.
	3. response에 포함시켜 클라이언트로 전송
	
	4. 브라우저가 가진 쿠키 저장소에 저장(response header)
	 
	5. 다음번 요청이 발생할때, 쿠키를 서버로 재전송함. (request header)
	6. 재전송된 request cookie헤더를 통해 상태 복원. 
	 <%
		Cookie firstCookie = new Cookie("firstName", "FIRSTVALUE");
		response.addCookie(firstCookie);
		Cookie koreanCookie = new Cookie("Korean", URLEncoder.encode("한글값","UTF-8"));
		response.addCookie(koreanCookie);
		Cookie otherPathCookie = new Cookie("path11Cookie","PATH_11_VALUE");
		
		otherPathCookie.setPath(request.getContextPath() + "/11");
		response.addCookie(otherPathCookie);
		
		Cookie allPathCookie = new Cookie("allPathCookie", "ALL_PATH_VALUE");
		allPathCookie.setPath(request.getContextPath());
		response.addCookie(allPathCookie);
		
		Cookie longLiveCookie = new Cookie("longLiveCookie", "LONG~LIVE~VALUE");
		longLiveCookie.setPath(request.getContextPath());
		longLiveCookie.setMaxAge(60*60*24*7); //일주일
		response.addCookie(longLiveCookie);
		
		int[] array = new int[]{1,2,3};
		String json = new ObjectMapper().writeValueAsString(array);
		Cookie arrayCookie = new Cookie("arrayCookie", URLEncoder.encode(json,"UTF-8"));
		
		arrayCookie.setPath(request.getContextPath());
		response.addCookie(arrayCookie);
		
	%> 
	<a href="cookieView.jsp">동일 경로에서 확인</a>
	<a href="../11/cookieView.jsp">다른 경로에서 확인</a> <!-- ../하면 webapp이 아니라 context roof -->
	
	**쿠키 속성의 종류
	1. name(required) : 변수(identifier) 생성 규칙에 따른 이름. //공백X 
	2. value(required) : 특수문자가 포함된 값은 인코딩(URLEncoding)해서 전송함.
	--> optional
	3. domain/host : 쿠키의 재전송 여부를 결정하는 조건.
					생략시 기본값으로 쿠키 생성시의 도메인이 반영됨.
				domain name 구조
				3레벨(GTLD) www.naver.com // .com을 상위레벨 그 왼쪽으로는 하위레벨. www < naver < com //Global Top Level Domain
				4레벨(NTLD) www.naver.co.kr //National Top Level Domain
				ex) cookie's domain : .naver.com, naver.com의 모든 호스트 서버로 재전송 되는 쿠키 설정.
				 //email.naver.com : 네이버의 이메일서버로만 할당하겠다 는 뜻. 그렇다면 .naver.com 은? (하위레벨이 생략) : 모든 서버를 갈 수 있다 
	4. path : 쿠키의 재전송 여부를 결정하는 조건. 설정된 경로 이하로 발생하는 요청을 통해 재전송.
				생략시 기본값으로 쿠키의 생성 경로가 반영됨.
	
	5. max-age/expires : 쿠키의 만료 시한 설정.
</pre>

</body>
</html>