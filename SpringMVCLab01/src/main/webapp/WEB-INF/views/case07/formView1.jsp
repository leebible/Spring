<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h4>입력 양식 구성</h4>

<form:form modelAttribute="bank"> <!-- value="${bank.bankNo } 구조형성 (실제로 value를 넣어도 됨)  -->
	<form:input path="bankNo" placeholder="계좌번호"/> <!-- html의 모든 속성은 코드어시스트에 안보여도 다 쓸수 있음 -->
	<form:errors path="bankNo" />
	<form:input path="bankName" placeholder="은행명"/>
	<form:errors path="bankName" />
	<form:input path="bankUserName" placeholder="계좌주"/>
	<form:errors path="bankUserName" />
	<form:input path="bankDate" placeholder="계좌개설일"/>
	<form:errors path="bankDate" />
	<button type="submit">전송</button>
</form:form>
<%-- <form method="post" enctype="application/x-www-form-urlencoded"> --%>
<%--  	<input type="text" name="bankNo" placeholder="계좌번호" value="${bank.bankNo }"/> --%>
<%-- 	<input type="text" name="banName" placeholder="은행명" value="${bank.bankName }"/> --%>
<%-- 	<input type="text" name="bankUserName" placeholder="계좌주" value="${bank.bankUserName }"/> --%>
<%-- 	<input type="date" name="bankDate" placeholder="계좌개설일" value="${bank.bankDate }"/> --%>
<!-- 	<button type="submit">전송</button> -->
<%-- </form> --%>