/**
 * 
 */
const cPath = document.body.dataset.contextPath
let modal = document.querySelector('.modal-body')

$(document).on('click', '' )
let target = document.querySelectorAll('.tb');
target.forEach((tg)=> tg.addEventListener('click', function(){
	memId = tg.dataset.memId;
	console.log(memId);
	$.ajax({
		url:`${cPath}/member/memberDetail.do`,
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		data : {
			memId : memId
		},
		success : function(resp){
			console.log(resp.mvo);
			code = `<table border='1'>`;
			Object.entries(resp.mvo).forEach(([key, value]) => {
			code += `
			<tr>
			<td>${key}</td>
			<td>${value}</td>
			</tr>`;
			})
			code += `</table>`
			modal.innerHTML=code;
		}
	})
})
)	