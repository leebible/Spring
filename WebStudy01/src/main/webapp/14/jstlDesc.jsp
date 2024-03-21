<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14/jstlDesc.jsp</title>
</head>
<body>
<h4>JSTL(Jsp Standard Tag Library)</h4>
<pre>
	: 커스텀 태그 라이브러리
	*** 커스텀 태그 로딩이 필요함. &lt;%@ taglib uri="태그식별" prefix="namespace" %&gt; //&lt;  : 레퍼런스문자
	&lt;namespace:tagname attribute_name="attribute_value"&gt;
	*** Core 태그(c 태그)
	1. EL변수(속성) 지원 : set, remove
		<c:set var="dummy" value="TEXT" scope="session"/>
		${dummy }
		<%-- <c:remove var="dummy" scope="session"/> --%>
		<!-- flash attribute -->
		${dummy }
		<c:set var="dummyClone" value="${not empty dummy ? dummy : 'default' }"/>
		${dummyClone }
	2. 조건문 : if, choose_when_otherwise //switch_case_default역할을함 !
		<c:if test="${not empty dummy } ">
			${dummy } 
		</c:if>
		<c:if test="${empty dummy }">
			default
		</c:if>
		
		<c:choose>
			<c:when test="${not empty dummy }">
				${dummy }
			</c:when>
			<c:otherwise>
			default
			</c:otherwise> <%-- if 와 else 구조 --%>
		</c:choose>
	
	
	3. 반복문 : foreach, forTokens
		for(선언절;조건절;증감절)
		<c:forEach var="i" begin="1" step="2" end="5" varStatus="vs"> 
		<%--var="i" begin="1" : int i=1 , step="1" : i++ , end="5" : i<=5 --%>
		<%--위 var 속성은 pagescope(?)에 들어있기때문에 el로 표현--%>
			<%--아래 정보들을 갖고있는데 varStatus --%>
			첫번째 반복문 여부 : ${vs.first } <%--first : booean타입 변수 (첫번째 반복문일때만 true) --%>
			마지막 반복문 여부 : ${vs.last } <%--last : 마지막 반복일대만 true --%>
			몇번째 반복문 : ${vs.count }
			{i }
		</c:forEach>
		토큰? 문장의 구성요소중에 의미를 부여할수 있는 최소한의 단위
		intnumber=3; //한개의 토큰으로 구성된 문장
		int nubmer = 3 ; //다섯개의 토큰으로 구성됨 (공백 체크) int라는 토큰 + number라는 토큰 +..+ ;세미콜론이라는 토큰. 
		아버지가 방에 들어가신다
		아버지 가방에 들어가신다
		<c:forTokens items="아버지 가방에 들어가신다" delims=" " var="token">
			${token }
		</c:forTokens>
		<c:set var="numbers" value="1,2,3,4,5"/>
		<c:forTokens items="${numbers}" delims="," var="num">
			${num * 100 } 
		</c:forTokens>
		<%--numbers라는 속성이 값을 가지고 있음 --%>
		<%--el은 연산자가 main이기때문에 num이 원래는 string이지만 int로 변환해서 숫자로 계산해줌!! --%>
	4. 흐름제어용 : redirect
		<%-- <c:redirect url="/14/elDesc.jsp"/> --%><%--로케이션 헤더를 결정 --%>
	5. 기타 : url, out, import
		<c:url value="/14/elDesc.jsp" var="elDesc">
			<c:param name="q1" value="v1"/>
			<c:param name="q2" value="v2"/>
		</c:url>
		${elDesc }
		<c:out value="<h4>출력텍스트</h4>" escapeXml="false"/>
		
		<c:set var="htmlSource" value="<h4>출력텍스트</h4>" />
		<c:out value="${htmlSource }" escapeXml="true"></c:out>
</pre>
<%-- <jsp:include page="http://www.naver.com"></jsp:include> --%> <%--불가 --%>
<c:import url="https://www.naver.com" var="naver"></c:import>
<c:out value="${naver }"  escapeXml="false" />
</body>
</html>