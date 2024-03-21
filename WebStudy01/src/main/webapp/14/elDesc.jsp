<%@page import="kr.or.ddit.vo.BtsVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14/elDesc.jsp</title>
</head>
<body>
<h4>EL(Expression Language, 표현 언어)</h4>
<pre>
	값을 출력하기 위한 목적으로 사용되는 스크립트 언어. //자바스크립트처럼 생각하자! 연산자 사용 가능!할당연산자, concat연산 사용불가.
	표현식을 대체하는 용도로 사용됨.
	
	scope를 통해 공유되고 있는 attribute만 사용 가능
	scope 네개를 순차적으로 검색해서 데려옴 ( page > request > session > application)
	
	<%=23 %>, ${23 }
	<%-- ${ } --%>
	<%
		String text = "TEXT";
		pageContext.setAttribute("textAttr3", text);
	%>
	<%=text %>, ${textAttr }, <%=session.getAttribute("textAttr") %>
	request : ${request }, ${pageContext.request } pageContext : ${pageContext }
	session : ${session }, ${pageContext.session }, application : ${application }
	
	<%
		pageContext.setAttribute("attr", "23");
	%>
	산술연산자 : ${23+12 }, ${attr+12 }, ${attr*12 }, ${attr/12 } , \${attr++ }
		=, ++, concat 은 지원하지 않음. (현재 업그레이드된  el에서는 다 지원함.하지만 우리나라에선 지원하는 el을 쓰지 않음 )
	논리연산자 : &&(and), ||(or), !(not) 
		${true && true }, //빨간줄이 뜨는 이유.오류는 아니지만 스페이스에 &nbsp;가 사용되기때문에 파싱될때 충돌되서!
		${true and true }, ${dummy and true }, ${not true }, ${not dummy } //이렇게 쓰는게 더좋음
	비교연산자 : >(gt),        <(lt),       ==(eq),  >=(ge),   <=(le),    !=(ne) //html태그와 충돌되기때문에 이름으로 표기
			greater then    less then    equal     
			${23 ne 35 } , ${23 lt 35}, ${23 ge 35 }
	삼항연산자 : 논리값? 참:거짓 
			${23 lt 35 ? '작다' :'크거나 같다'} //''를 안붙이면 안에 텍스트를 속성으로 찾기때문에 붙여줘야함
			<%
				pageContext.setAttribute("dummy", "  "); //공백이긴하지만 langs가 두개 늘어난것
				List sample = new ArrayList();
				sample.add("element1");
				pageContext.setAttribute("sample", sample);
				
				Map map = new HashMap();
				map.put("key1", "value1");
				map.put("key-2", "value2");
				pageContext.setAttribute("dummyMap", map);
				
				BtsVO bts = new BtsVO("B001","뷔","path");
				pageContext.setAttribute("bts", bts);
			%> 
	단항연산자(제일많이씀) : empty 
					${empty dummy } //dummy가 없는지 확인하겠다.  true : 속성이 있나? null인가? 판단함. isEmpty랑 기능 비슷.
					${not empty dummy } //dummy가 있는지 확인하겠다.
					sample의 존재여부 : ${empty sample ? "비어있음":"비어있지않음"}
					
					${sample.get(0) }, ${sample[0] } //둘다 되긴하지만 후자가 더 많이 이용됨  
					${dummyMap.get('key1') }, ${dummyMap.key1 }, ${dummyMap['key1'] }
					${dummyMap.get('key-2') }, ${dummyMap.key-2 }, ${dummyMap['key-2'] }
					
					${bts }
					${bts.getName() }, ${bts.name }, ${bts['name'] } //닷노테이션이 가능하다면 연산배열구조도 가능
</pre>
<script>
	let attr = 35;
	console.log(`\${attr}`)
</script>
</body>
</html>