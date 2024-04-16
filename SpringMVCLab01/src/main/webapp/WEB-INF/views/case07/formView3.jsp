<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<pre>
검증대상 : ${adrs }
검증 결과 : ${requestScope["org.springframework.validation.BindingResult.adrs"] }
</pre>
<!-- value를 초기화하기 쉽도록 form:form을 쓰는것. -->
<form:form method="post" modelAttribute="adrs"> <!-- value="${bank.bankNo } 구조형성 (실제로 value를 넣어도 됨)  -->
	<form:input path="adrsNo" placeholder="주소록번호"/> <!-- html의 모든 속성은 코드어시스트에 안보여도 다 쓸수 있음 -->
	<form:errors path="adrsNo" />
	<form:input path="memId" placeholder="회원아이디"/>
	<form:input path="adrsName" placeholder="이름"/>
	<form:input path="adrsTel" placeholder="번호"/>
	<form:errors path="adrsTel" />
	<form:input path="adrsAdd" placeholder="주소"/>
	<button type="submit">전송</button>
</form:form>
<%-- <form method="post" enctype="application/x-www-form-urlencoded"> --%>
<%--  	<input type="text" name="bankNo" placeholder="계좌번호" value="${bank.bankNo }"/> --%>
<%-- 	<input type="text" name="banName" placeholder="은행명" value="${bank.bankName }"/> --%>
<%-- 	<input type="text" name="bankUserName" placeholder="계좌주" value="${bank.bankUserName }"/> --%>
<%-- 	<input type="date" name="bankDate" placeholder="계좌개설일" value="${bank.bankDate }"/> --%>
<!-- 	<button type="submit">전송</button> -->
<%-- </form> --%>