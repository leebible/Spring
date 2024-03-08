<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/requestDesc.jsp</title>
</head>
<body>
<h4>request(HttpServletRequest)</h4>
<form method="post" >
	<input type="hidden" name="_method" value="put"/> <!-- post이지만 사실 put을 위한 메소드. hidden : 전송하기 위한 메소드 -->
	<input type="hidden" name="_method" value="delete"/> <!-- post이지만 사실 delete 위한 메소드 -->
	<input type="text" name="param1" value="VALUE1" />
	<input type="text" name="param2" value="VALUE2" />
	<input type="file" name="sendFile" />
	<button type="submit">전송</button>
</form>
<pre>
	: http 프로토콜로 패키징된 요청에 대한 정보와 해당 요청을 발생시킨 클라이언트에 대한 정보를 가진 객체.
	
	HTTP(Hyper Text Transfer Protocol) ; HTML 문서 전송시 패키징 규칙성에 대한 정의 
	1. Request Line : URL(명사, 자원에 대한 식별자), request Method (편지봉투1)
		request Method(자원에 대한 행위를 표현하는 동사) : 요청의 목적(의도)과 패키징 구조에 대한 표현
		GET-R (클라이언트가 사용하는 기본 method) : 조회 
		POST-C : 새로운 자원 등록
		PUT/PATCH-U : 기존 자원의 수정 (수정방식의 차이) <!-- body가 필요 -->
		DELETE-D : 기존 자원의 삭제 <!-- 때에 따라서 body가 필요한경우 있음(비밀번호 보낼때) -->
		OPTION : preFlight 요청에 사용됨 (서버의 상태를 확인하는 용도로 사용)
		HEAD : response body가 없는 line과 header로만 구성된 response 받기 위한 요청
		TRACE : 대부분의 요청은 이 옵션을 막고 있음
		
		RESTful URI 구조.
		
		ex) /member/memberInsert.do
		ex) /member/memberDelete.do
		
		ex) /member GET
		ex) /member POST
		ex) /member PUT
		ex) /member DELETE
		
		
		
	2. Request Header : 클라이언트의 요청을 부가적으로 수식해주는 메타데이터의 영역 (편지봉투2)
	(다 외우진 못해도 이정도는 외우기 Accept, content, user-agent)
		header name : header value
		Accept-*
		Accept : response content-type 을 표현
		 	ex) text/html
		 		application/json
		Accept-Language : response language 표현
			ex) ko_KR,ko,en-US,en (language의 우선순위)
		Accept-Encoding : response data compress 방식 표현 (압축포맷방식)
			ex) gzip
			
		Content-* : POST 요청으로 request body 가 있음.
		Content-Type : request body content mime type 설정.	
			ex) application/x-www-form-urlencoded (편지내용이 텍스트, 그림)
				multipart/form-data (편지지가 여러장)
		Content-length : body content length 표현
		User-Agent : 클라이언트가 사용하고 있는 시스템이나 브라우저 랜더링 엔진에 대한 표현. (ex 모바일/웹 구분)
		
	3. Request Body(Content Body, Message Body) : POST 요청에서만 형성되는 영역으로 전송 컨텐츠의 영역.(편지내용)
		1) request parameter : application/x-www-form-urlencoded MIME에 따라 
				전송 가능한 직렬화된 문장으로 데이터가 전송됨. (파라미터가 넘어갈때는 String으로 넘어감 )
				ex) name=value&name=value
				파라미터 형태의 전송데이터는 BODY가 없는 경우, 제한적으로 request line 을 통해 전송되기도 함.
				--> Query String
				GET : URL? (편지지가 없기 때문에 ?뒤에 Query String이 붙는것!)
		2) multipart data : multipart/form-data MIME에 따라
				body 영역이 여러개의 part로 분리되고, 각 part에 입력 데이터가 포함되어 전송됨.
		3) object payload : application/json MIME에 따라 
				body 영역을 통해 json이나 xml 페이로드를 전송하게 됨.(필드에선 가장 많이 사용됨. 객체 대 객체로 전송)
				
</pre>
</body>
</html>