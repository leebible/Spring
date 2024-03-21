<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public String data = "DATA";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext(pageContext)</title>
</head>
<body>
<h4>pageContext(pageContext)</h4>
<pre>
	기본객체 중 가장 먼저 생성되고, 나머지 기본객체에 대한 참조를 가진 객체.
	<%=request==pageContext.getRequest()%>
	<%=session==pageContext.getSession()%>
	<%=request.getContextPath() %>, ${pageContext.request.contextPath }
	
	Scope(Map) : 웹어플리케이션에서 공유 데이터를 저장하기 위한 저장소.
			생명주기가 다른 4개의 기본객체가 가진 map.
			scope를 통해 공유되는 name/value로 구성된 데이터 : attribute
	1. page scope : pageContext가 관리하는 map //데이터 공유하는 목적으로 사용불가. 한 페이지내에서만 사용가능. custom태그만들때 필요할때가 있다!
	2. request scope : request가 관리하는 map
	3. session scope : session이 관리하는 map
	4. application scope : ServletContext가 관리하는 map
	
	- 각 map이 가질수 있는 메소드 3개
	setAttribute(name, value), getAttribute(name), removeAttribute(name)
	<%
		pageContext.setAttribute("pageAttr", "페이지속성");
		request.setAttribute("requestAttr1","요청 속성1");
		pageContext.setAttribute("requestAttr2","요청속성2", PageContext.REQUEST_SCOPE);
		session.setAttribute("sessionAttr", "세션 속성");
		application.setAttribute("applicationAttr", "어플리케이션 속성");
	
		/* request.getRequestDispatcher("/13/attrView.jsp").include(request, response); */
		response.sendRedirect(request.getContextPath() +"/13/attrView.jsp");
	%>
	<!-- <a href="<%=request.getContextPath()%>/13/attrView.jsp">속성 확인</a> -->
	
	class A{
		public String c;
	}
	class B{
		public String d;
	}
	A a = new A();
	B b = new B();
	a.
	
</pre>
</body>
</html>