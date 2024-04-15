<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="calForm" method="post">
	<input type="number" name="leftOp" value="${leftOp}"  />
	+
	<input type="number" name="rightOp" value="${rightOp}" />
	<button type="submit">=</button>
	<span id="result-area">${result }</span>
</form>
<%-- <script src="<c:url value='/resources/js/case6Mission.js'/>"></script> --%>
<script> <!-- 시간관계상 해당페이지에 js작성하는것임 -->
	const $resultArea = $("#result-area");
	//이벤트처리단계 1.이벤트타겟고르기 2.이벤트종류 3.핸들러구현 4.
	$("[name='calForm']").on("submit", function(event){
		event.preventDefault();
		let url = this.action; //this : html element
		let method = this.method;
		let data = $(this).serialize();
		$.ajax({
			url : url
			, method : method
			, data: data
			, dataType:"json" // accept : application/json
			, success : function({result}){ //java의 구조분해문법을 사용해보자
// 			, success : function(outer){ //java의 구조분해문법을 사용해보자
				$resultArea.html(result);
// 				$("#result-area").html( outer.result ); //success안에 span태그가있으면 반복적으로 트래거싱이 발생할수 있어서 안좋은 코드
			}
		});
	});
</script>