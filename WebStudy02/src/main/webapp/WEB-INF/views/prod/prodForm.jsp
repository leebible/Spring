<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp" />
<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session" />
</c:if>

</head>
<body>
	<form method="post" enctype="application/x-www-form-urlencoded">
		<table class="table table-bordered">
			<tr>
				<th>상품명</th>
				<td><input type="text" name="prodName" value="${prod.prodName}"
					class="form-control" /><span class="text-danger">${errors.prodName}</span></td>
			</tr>

			<tr>
				<th>상품분류</th>
				<td><select name="prodLgu" data-init-value="${prod.prodLgu }">
						<option value>제품선택</option> <!-- 이곳을 선택하면 white space -->
						<c:forEach items="${lprodList }" var="lprod">
							<option value="${lprod.lprodGu }" >${lprod.lprodNm }</option>
						</c:forEach>
				</select> <span class="text-danger">${errors.prodLgu} </span></td>
			</tr>
			<tr>
				<th>거래처</th>
				<td><select name="prodBuyer" data-init-value="${prod.prodBuyer }">
						<option value>제조사 선택</option>
						<c:forEach items="${buyerList }" var="buyer">
							<option value="${buyer.buyerId }" class="${buyer.buyerLgu }">${buyer.buyerName }</option>
						</c:forEach>
				</select> <span class="text-danger">${errors.prodBuyer} </span></td>
			</tr>

			<tr>
				<th>구매가</th>
				<td><input type="number" name="prodCost"
					value="${prod.prodCost}" class="form-control" /> <span
					class="text-danger">${errors.prodCost} </span></td>
			</tr>
			<tr>
				<th>판매가</th>
				<td><input type="number" name="prodPrice"
					value="${prod.prodPrice}" class="form-control" /> <span
					class="text-danger">${errors.prodPrice} </span></td>
			</tr>
			<tr>
				<th>세일가</th>
				<td><input type="number" name="prodSale"
					value="${prod.prodSale}" class="form-control" /> <span
					class="text-danger">${errors.prodSale} </span></td>
			</tr>
			<tr>
				<th>요약정보</th>
				<td><input type="text" name="prodOutline"
					value="${prod.prodOutline}" class="form-control" /> <span
					class="text-danger">${errors.prodOutline} </span></td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td><input type="text" name="prodDetail"
					value="${prod.prodDetail}" class="form-control" /> <span
					class="text-danger">${error.prodDetail} </span></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="text" name="prodImg" value="${prod.prodImg}"
					class="form-control" /> <span class="text-danger">${errors.prodImg}
				</span></td>
			</tr>
			<tr>
				<th>총재고</th>
				<td><input type="number" name="prodTotalstock"
					value="${prod.prodTotalstock}" class="form-control" /> <span
					class="text-danger">${errors.prodTotalstock} </span></td>
			</tr>
			<tr>
				<th>입고일</th>
				<td><input type="date" name="prodInsdate"
					value="${prod.prodInsdate}" class="form-control" /> <span
					class="text-danger">${errors.prodInsdate} </span></td>
			</tr>
			<tr>
				<th>적정재고</th>
				<td><input type="number" name="prodProperstock"
					value="${prod.prodProperstock}" class="form-control" /> <span
					class="text-danger">${errors.prodProperstock} </span></td>
			</tr>
			<tr>
				<th>크기</th>
				<td><input type="text" name="prodSize" value="${prod.prodSize}"
					class="form-control" /> <span class="text-danger">${errors.prodSize}
				</span></td>
			</tr>
			<tr>
				<th>색상</th>
				<td><input type="text" name="prodColor"
					value="${prod.prodColor}" class="form-control" /> <span
					class="text-danger">${errors.prodColor} </span></td>
			</tr>
			<tr>
				<th>배송방법</th>
				<td><input type="text" name="prodDelivery"
					value="${prod.prodDelivery}" class="form-control" /> <span
					class="text-danger">${errors.prodDelivery} </span></td>
			</tr>
			<tr>
				<th>단위</th>
				<td><input type="text" name="prodUnit" value="${prod.prodUnit}"
					class="form-control"><span class="text-danger">${errors.prodUnit}
				</span></td>
			</tr>
			<tr>
				<th>입고량</th>
				<td><input type="number" name="prodQtyin"
					value="${prod.prodQtyin}" class="form-control" /> <span
					class="text-danger">${errors.prodQtyin} </span></td>
			</tr>
			<tr>
				<th>출고량</th>
				<td><input type="number" name="prodQtysale"
					value="${prod.prodQtysale}" class="form-control"><span
					class="text-danger">${errors.prodQtysale} </span></td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td><input type="number" name="prodMileage"
					value="${prod.prodMileage}" class="form-control" /> <span
					class="text-danger">${errors.prodMileage} </span></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="/WEB-INF/includee/postScript.jsp" />
	<script src="${pageContext.request.contextPath }/resources/js/app/prod/prodForm.js"></script>
</body>
</html>