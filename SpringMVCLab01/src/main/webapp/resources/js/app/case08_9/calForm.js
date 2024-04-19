/**
 * 
 */
document.calForm.addEventListener("submit",(e)=>{
	e.preventDefault();
	let form = e.target;
	let url = form.action;
	let method = form.method;
	
	let headers = {
		"Content-type" : "application/json",
		"Accept" : "application/json"
	};
	let target = {
		leftOp : form.leftOp.value;
		rightOp : form.rightOp.value;
		operator : form.operator.value;
	};
	let body = JSON.stringify(target); //마샬링
	//JSON.parse : 언마샬링
	fetch(url,{
		method:method,
		headers:headers,
		body:body
	}).then(resp=>resp.json()) //프로미스 반환
	.then(cv=>console.log(cv)); //json이 언마샬링 된 이후
})