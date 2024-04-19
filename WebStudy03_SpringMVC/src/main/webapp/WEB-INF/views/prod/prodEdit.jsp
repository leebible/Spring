<%@page import="kr.or.ddit.prod.controller.ProdUpdateController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="<%=ProdUpdateController.MODELNAME%>"
	method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>상품코드</th>
			<td><form:input type="text" path="prodId" required="true"
					class="form-control" />
				<form:errors path="prodId" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><form:input type="text" path="prodName" required="true"
					class="form-control" />
				<form:errors path="prodName" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>상품분류</th>
			<td><form:input type="text" path="prodLgu" required="true"
					class="form-control" />
				<form:errors path="prodLgu" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>거래처</th>
			<td><form:input type="text" path="prodBuyer" required="true"
					class="form-control" />
				<form:errors path="prodBuyer" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>구매가</th>
			<td><form:input type="number" path="prodCost" required="true"
					class="form-control" />
				<form:errors path="prodCost" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>판매가</th>
			<td><form:input type="number" path="prodPrice" required="true"
					class="form-control" />
				<form:errors path="prodPrice" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>세일가</th>
			<td><form:input type="number" path="prodSale" required="true"
					class="form-control" />
				<form:errors path="prodSale" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>요약정보</th>
			<td><form:input type="text" path="prodOutline" required="true"
					class="form-control" />
				<form:errors path="prodOutline" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td><form:input type="text" path="prodDetail"
					class="form-control" />
				<form:errors path="prodDetail" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<input type="file" name="prodImage"/>
				<form:hidden path="prodImg" required="true" />
				<form:errors path="prodImg" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>총재고</th>
			<td><form:input type="number" path="prodTotalstock"
					required="true" class="form-control" />
				<form:errors path="prodTotalstock" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>입고일</th>
			<td><form:input type="date" path="prodInsdate"
					class="form-control" />
				<form:errors path="prodInsdate" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td><form:input type="number" path="prodProperstock"
					required="true" class="form-control" />
				<form:errors path="prodProperstock" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>크기</th>
			<td><form:input type="text" path="prodSize" class="form-control" />
				<form:errors path="prodSize" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>색상</th>
			<td><form:input type="text" path="prodColor"
					class="form-control" />
				<form:errors path="prodColor" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td><form:input type="text" path="prodDelivery"
					class="form-control" />
				<form:errors path="prodDelivery" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>단위</th>
			<td><form:input type="text" path="prodUnit" class="form-control" />
				<form:errors path="prodUnit" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>입고량</th>
			<td><form:input type="number" path="prodQtyin"
					class="form-control" />
				<form:errors path="prodQtyin" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>출고량</th>
			<td><form:input type="number" path="prodQtysale"
					class="form-control" />
				<form:errors path="prodQtysale" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><form:input type="number" path="prodMileage"
					class="form-control" />
				<form:errors path="prodMileage" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="저장"
				class="btn btn-primary" /> <input type="reset" value="취소"
				class="btn btn-danger" /> <input type="button" value="뒤로가기"
				class="btn btn-secondary" onclick="history.back();" /></td>
		</tr>
	</table>
</form:form>
<script
	src="${pageContext.request.contextPath }/resources/js/app/prod/prodForm.js"></script>










