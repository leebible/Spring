<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<h4>상품목록</h4>
<table class="table table-bordered">
	<thead class="table-dark">
		<tr>
			<th>일련번호</th>
			<th>상품명</th>
			<th>분류명</th>
			<th>거래처명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<tr>	
					<td>${prod.rnum }</td>
					<td>
						<c:url value="/prod/prodDetail.do" var="detailUrl">
							<c:param name="what" value="${prod.prodId }" />
						</c:url>
						<a href="${detailUrl }">${prod.prodName }</a>
					</td>
					<td>${prod.lprod.lprodNm }</td>
					<td>${prod.buyer.buyerName }</td>
					<td>${prod.prodCost }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodMileage }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="6">상품 없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		
		<tr>
			<td colspan="7">
				<div id="searchUI">
					<select name="searchType">
						<option value>전체</option>
						<option value="prodBuyer">거래처</option>
						<option value="prodLgu">분류</option>
						<option value="prodName">상품명</option>
					</select>
					<input type="text" name="searchWord" />
					<button id="searchBtn">검색</button>
				</div>
				${pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>
<form action="<c:url value='/prod/prodList.do'/>" id="searchForm">
	<input type="text" name="searchType" />
	<input type="text" name="searchWord" />
	<input type="text" name="currentPage" />
</form>


<script>
	$("[name='searchType']").val(${condition.searchType})
	$("[name='searchWord']").val(${condition.searchWord})
	
	
	function paging(page){
// 		location.href="?currentPage="+page;
		searchForm.currentPage.value = page;
		$searchForm.submit();
	}
	
// 	searchBtn을 클릭하면, searchUI 가 가진 모든 입력값을 searchForm으로 복사하고, searchForm을 전송
const $searchForm = $("#searchForm");
	$("#searchBtn").on("click", function(event){
		let $searchUI = $(this).parents("#searchUI");
		$searchUI.find(":input[name]").each(function(idx, ipt){//인덱스, input태그 하나    :input : input태그를 가진 모든,, 
			let name = this.name;
			let value = $(this).val(); 
// 			searchForm.searchType.value = value;
// 			$searchForm.find(`[name='\${name}']`).val(value); //el이라 역슬래시 붙이기 (아래 연산배열구조로 코드 줄일수 있음)
			searchForm[name].value= value;
		})
		$searchForm.submit(); //알아서 submit이벤트 발생
	});
</script>


















