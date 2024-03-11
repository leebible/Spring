<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>POST 요청</h4>
<!-- Case2 : 모든 방식(비동기,동기)이 post방식으로 -->
<form action="<%=request.getContextPath() %>/06/case2Req.do" method="post">
	<pre>
		<a href="<%=request.getContextPath() %>/06/case2Req.do" data-p5="34">요청1</a> <!-- a태그는 별개로 동작. form태그 전송을 눌러도 넘어가지 않음 -->
		<!-- (비동기로 받고 싶을때) 이벤트핸들러로 받을때 메소드 변경하면..됨(?) -->
		<input type="text" name="p1" placeholder="p1"/>
		<input type="number" name="p2" placeholder="p2"/>
		<input type="text" name="p2" placeholder="p2"/>
		<input type="date" name="p3" placeholder="p3"/>
		<input type="datetime-local" name="p4" placeholder="p4"/>
		<input type="text" id="p6" placeholder="p6"/>
		<input type="radio" id="p7_y" name="p7" value="TRUE" checked/> true
		<input type="radio" id="p7_f" name="p7" value="FALSE"/> false
		<label><input type="checkbox" name="p8" id="p8_1" value="CH1"/>ch1</label>
		<input type="checkbox" name="p8" id="p8_2" value="CH2"/>
		<label for="p8_2">ch2</label>
		<input type="checkbox" name="p8" id="p8_3" value="CH3"/>ch3
		<select name="p9">
			<option value>선택</option>
			<option value="value1">text1</option>
			<option value="value2">text2</option>
		</select>
		<select name="p10" multiple>
		<!-- <option value>선택</option> multiple일때는 선택을 안하면 안넘어가기때문에 프롬프트텍스트를 쓰지 않는다!!--> 
			<option value="value1">text1</option>
			<option value="value2">text2</option>
		</select>
		<!-- 키보드로 입력받지 않은 타입은 선택하지않는 이상 파라미터로 넘어가지 않는다. -->
		<!-- 따로 value를 입력할수 없기에 input type 안에 미리 설정해야한다 -->
		<!-- input이란 태그는 파라미터에 값이 없어도 넘어감 -->
		<!-- name이 없는 input태그는 의미가 없다. name속성을 갖고있는 input태그만 파라미터에 포함한다. -->
		<!-- type이 다 다르지만 넘어갈땐 무조건 String(문자열)이다. -->
		<button type="submit">전송</button>
		<button type="reset">취소</button>
	</pre>
</form>
<div id="resultArea"></div>
<script src="<%=request.getContextPath() %>/resources/js/app/06/formCase2.js"></script>
</body>
</html>