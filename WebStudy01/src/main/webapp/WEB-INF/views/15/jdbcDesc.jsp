<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@page import="kr.or.ddit.utils.NamingUtils"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body data-context-path="${pageContext.request.contextPath }">
<h4>JDBC(Java DataBase Connectivity) 프로그래밍 방법론</h4>
<pre>
	1. jdbc 드라이버를 빌드패스에 로딩. //로딩되었다고 해서 메모리에 올라간건 아님. 실제 사용할수 있도로 클래스메모리에 로딩해줘야함.
		/WEB-INF/lib/ojdbc6.jar
	2. classloader 를 이용해 드라이버를 메모리에 로딩.
	3. 연결(Connection) 수립. //session과 비슷 / auto commit,,
	4. 쿼리 객체 생성 // 명령을 내리는
		- Statement //미리 쿼리문이 컴파일 되어있지 않음. 실행하는 단계에서 쿼리문을 동적으로 바꾸는게 가능, SQL injection 가능
		- PreparedStatement //쿼리문의 형태를 미리 컴파일을 해주는 객체
		- CallableStatement //콜의 대상이 되는건 plsql에서 만들어진 function 혹은 프로시저 처럼 집합 명령어를 사용하고 싶을때
	5. 쿼리 실행 //결과가 존재 or DB변경사항 반영
		- ResultSet executeQuery : SELECT//돌아오는 결과집합이 있을때!
		- int executeUpdate : INSERT, UPDATE, DELETE//rowcount로 받아옴. 레코드에 영향.
	6. 결과 집합 핸들링 //집합이기에 레코드간의 중복허용X. primary key로 구분.
	7. ★★★★ Connection, Statement, ResultSet release//db는 connectfull 방식, 모든 객체를 close해줘야함. 모든 서버에는 가용자원이 있는데 
</pre>
<table border=1>
	<thead id="head-area"> <!-- 메타데이터 출력 -->
		<tr>
<%-- 			<c:forEach items="${headers }" var="colName"> --%>
<%-- 				<th>${colName }</th> --%>
<%-- 			</c:forEach> --%>
		</tr>
	</thead>
	<tbody id="data-area"> <!-- 실데이터 출력(36개) -->
<%-- 		<c:forEach items="${resultList }" var="propsMap"> --%>
<!-- 		<tr> -->
<%-- 			<c:forEach items="${propsName }" var="propName"> --%>
<%-- 				<td>${propsMap[propName] }</td> <!-- PROPERTY_NAME에서 propertyName으로 바뀐 상태 --> --%>
<%-- 			</c:forEach> --%>
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
	</tbody>
</table>
<script src=" <c:url value='/resources/js/app/15/jdbcDesc.js' /> "></script>
</body>
</html>