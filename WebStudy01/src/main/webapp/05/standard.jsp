<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/standard.jsp</title>
</head>
<body>
<h4>JSP(Java Server Page)</h4>
<pre>
	: 자바와 서블릿 스펙을 기반으로 SSR을 구현하는 템플릿 엔진.
	SSR(Server Side Rendering) : document의 모든 엘리먼트가 서버에서 텍스트 템플릿으로 생성되는 구조.(JSP)
		템플릿 엔진 : 데이터와 템플릿이 분리되어 개발되고, 분리된 두 요소를 결합해 최종 컨텐츠를 생성하는 소프트웨어
			content -> Mime type (maintype/subtype)
			ex) HTML, JSON(JSON의 maintype은 application), Image, XML(application/xml)
	CSR(Client Side Rendering) : 엘리먼트는 클라이언트측에서 생성되고, 서버에서 데이터만 서비스 받는 구조.(React, VueJs)
	
	jsp 문법 구성요소
	1. 정적 텍스트 : 일반텍스트, HTML, JS, CSS
	2. 스크립틀릿(scriptlet,동적 요소를 위한 백그라운드 코드) 
		1) scriptlet : &lt;% //java code %&gt;
			<%
				//블럭 변수 --> 지역 변수 --> 인스턴스 변수 --> 클래스 정적(static) 변수 (전역변수)
				String data = "데이터";
				LocalDate now = LocalDate.now();
			%>
				
		2) directive(지시자) : &lt;%@  %&gt; --> 실행코드와 무관하게 jsp 페이지에 대한 부가적인 환경 설정에 사용.
			- page(required)  <!-- MIME텍스트 -->
			- taglib(optional) - custom tag 로딩에 사용.
			- include(optional) - 정적 include에 사용  
			
		3) expression(표현언어) : &lt;%= 출력할 값이나 표현식. %&gt;
		<%= data %> <%=now %>
		<% out.println(now); %>
		
		4) declaration(선언부) : &lt;%! %&gt; --> 전역 코드 선언에 사용.
		<%! 
			static String staticData = "전역 데이터";
			void dummy(){}
		%>
		5) comment : &lt;%-- --%&gt;
			주석의 종류
			- Client side comment : HTML, JS, CSS, Comment <!-- 클라이언트 주석은 되도록 안쓰는게 좋다. 이유 : 보안, 데이터양 등 -->
			- Server side comment : Java, JSP comment

	3. 기본객체<% %>
	4. action tag
	5. 표현언어(EL) ${attributeName }
	6. JSTL 커스텀 태그 라이브러리 			
			
			<!-- HTML 주석 -->
<!-- 		<style type="text/css">
			/* body {
				background-color : red;
			} */
		</style> -->
		<script type = "text/javascript">
			var dummy = "더미";
		</script>
		<%-- JSP주석 --%>
		

 </pre>
</body>
</html>