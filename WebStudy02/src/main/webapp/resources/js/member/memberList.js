/**
 * JQuery 설명!!
 */






$(document).ready(function(){

	
   const $modal = $("#exampleModal").on("show.bs.modal", function(event) {
	
    let modalElement = this;
    let tr = event.relatedTarget;
    let memId = $(tr).data("memId");

    let url = `${cPath}/member/memberDetail.do`;
    let method = "GET";

// 수정 버튼 눌렀을때
	$("button[name='update']").click(function(){
		let updateUrl = `${cPath}/member/memberUpdate.do?memId=${memId}`
		location.href=updateUrl
	})
// 삭제 버튼 눌렀을때
	$("button[name='delete']").click(function(){
		let deleteUrl = `${cPath}/member/memberDelete.do?memId=${memId}`
		location.href=deleteUrl
	})
    $.ajax({
        url: url,
        method: method,
        dataType: "json",
        data: {
            who: memId
        },
        success: function({ member }, status, jqXHR) {
            console.log(member?.memId);
            $modal.find("td[id]").each(function(index, td) {
                let propName = td.id;
                td.innerHTML = member[propName];
            });
        },
        error: function(jqXHR, status, errorText) {
            console.log(jqXHR, status, errorText);
        }
    });
}).on("hidden.bs.modal", function(event) {
    $modal.find("td[id]").html("");
});
});
	
const cPath = document.body.dataset.contextPath;
//document.addEventListener("DOMContenLoaded")
$(function(){ //1) $(document).on("ready", function()  2) $(document).ready(function()
	
		
	
//	document.querySelectorAll("tr[data-mem-id]") //집합객체. 바닐라스크립트는 여기서 반복문을 돌려야하지만 jquery는 필요없음

//	1번방식 : CSR방식으로 만들어진다면 tr태그가 없는 상태니 불안정함.
//	$("tr[data-mem-id]").on("click", function(){  //$() : jquery 생성자로 호출, [] : 속성.
//	document.addEventListener("click", function(){})
//	$(document).on("click","tr[data-mem-id]",function(){//바닐라와 비슷하지만 jquery는 안에 파라미터(디센던트)를 넣을수 있음
//		this.dataset.newKey="value"; //dataset : String map. 속성의 값은 문자열밖에 못줌
//		$(this).data("newKey", {}); //jQuery는 문자열이 아닌 {} 객체 형태로 올수 있음!
//		$(this).data(k,v) //this가 jquery객체인지 html element인지 판별해야함. $()로 jquery 객체로 만들어주기!
		//$(this).dataset : 사용불가! $(this).data <- 이렇게 써야함!!
		
		
		//'$' modal : jquery객체를 표현    ,     $("#exampleModal") : 글로벌변수를 jquery객체화 시킨것.
	const $modal = $("#exampleModal").on("show.bs.modal",function(event){ //"click"이벤트 대신 사용하는 부트스트랩 이벤트
		let modalElement = this;
		
		let tr = event.relatedTarget; //
		let memId = $(tr).data("memId");
		
		//jquery 일때
		//라인
		let url =`${cPath}/member/memberDetail.do`;
		let method = "GET";
		//헤더
		let headers = {
			"accpet" : "application/json",
		}
		
		//ajax일때
		$.ajax({
			url : url,
			method : method,
			dataType : "json",// text, html, json, xml : 4가지 상수임! 사실은 application/json을 표현한것.
			data : { //파라미터 쿼리스트링
				who:memId //fetch를 이용하면 form data, urlsearchparams를 이용해야함
			}, success:function({member}, status, jqXHR){ // {} : 구조 분해 문법 사용 가능
				console.log(member?.memId); //optional chainig . java의 optional api와 비슷
				$modal.find("td[id]").each(function(index,td){//find : 자식 검색. jquery에서는 foreach가 each!
					let propName = td.id;
					td.innerHTML = member[propName];//리터럴을 통해 프로퍼티 값을 가져오려면 연산배열구조가 필요함
				});
				$updateBtn.data("who",member.memId);
				
				
				//?? : null 병합 연산자. (삼항연산자와 비슷)
			}, error : function(jqXHR, status, errorText){
				console.log(jqXHR, status, errorText)
			}
		});
		
	}).on("hidden.bs.modal",function(event){
		$modal.find("td[id]").html("");
		$updateBtn.removeData("who");
	})
	
//새로입력받은 회원 모달창 띄우기 javascript 만들기
//1.tr태그중에서
//2.data-mem-id를 갖고 있는 tr
//3.active를 갖고있는 클래스

//trigger는 강제이벤트발생 / on은 이벤트 핸들러 발생
	$("tr[data-mem-id].active").trigger("click");
	

});