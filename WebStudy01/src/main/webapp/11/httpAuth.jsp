<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Http프로토콜 인증 시스템</h4>
<pre>
보안처리의 기본 구조
인증(Authentication) + 인가(Authorization) 기반의 접근 제어 구조를 통한 보안 처리.
인증 : '사용자'가 본인이 맞는지 신원을 확인하는 작업.
//WAS를 기반으로 한 inmemory 데이터
JAAS(Java Authenticatino Authorization Service) 프레임워크에 의해 처리
	: 인증된 사용자 정보를 Principal의 구현체로 표현함 
인가 : '보호자원'에 대한 접근 권한을 획득했는지 여부를 확인하는 작업.



1. 헤더 기반의 인증 (오늘 수업의 키포인트)
	ex)
	보호자원(/09/mbti)에 대해 미인증된 사용자가 접근한 경우,
	응답 으로 401 상태코드와 www-authenticate:authType[BASIC:BAERER] 헤더를 전송함.
	브라우저가 응답을 받고, 인증 정보를 입력받을 수 있는 UI를 선택함
	인증된 후 , 인증상태 정보 유지에 ()(authorizatino:authType[BASIC:BAERER] base64 인코딩된 사용자 정보) 헤더를 사용함.
		
	1) BASIC : 브라우저가 가진 기본 인증 UI 활용 방식.
	2) BAERER : 토큰 기반의 인증 시스템, oAuth 프로토콜에서 사용되는 인증 방식. 
	//HTTPS를 쓰지않더라도 암호화가 됌. 대신 이 프로토콜을 사용하려면 서버가 두개이상이여야함. 현재(학원에선)사용할수 없음..
		access token 표현 
			authorization : Baerer encrypt(base64(token)) //token에 사용자의 id, pass, name, email.. etc 모두 포함되어있음
	
2. 세션 기반의 인증
	1) FORM : form UI를 활용하는 방식.
		 action : j_security_check
		 id parameter : j_username
		 password parameter : j_password

1번과 2번의 차이 : 인증된 사용자를 표현하는 방식이 다름

</pre>
</body>
</html>