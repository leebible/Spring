<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form id="mbti-form" method="post" enctype="application/x-www-form-urlencoded"><!-- 메소드 생략하면 Get방식, Get방식은 enctype필요없음 -->
        <select name="type" onchange="this.form.requestSubmit()"> <!-- onchange뒤는 익명함수임. submit만 쓰면 이벤트 핸들러 동작X -->
			<option value="rm">RM</option>
			<option value="jin">진</option>
			<option value="suga">슈가</option>
			<option value="jhop">제이홉</option>
			<option value="jimin">지민</option>
			<option value="bui">뷔</option>
			<option value="jungkuk">정국</option>
        </select>
    </form>
    <div id="mbti-area">
    
    </div>
</body>
</html>