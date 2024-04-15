/**
 * 
 */

let forms = document.forms;
forms[0].addEventListener("submit", e=>{
	//폼의 이벤트를 중단 시키기
	e.preventDefault();
	let form = e.target;
	
	//request line
	let url = form.action;
	let method = form.method;
	
	//request header
	let headers = {
		"content-type" : form.enctype,
		"accept" : "application/json"
	};
	
	//request body
	let formData = new FormData(form); //form안에 파라미터값이 모두 들어있기에
	console.log(new URLSearchParams(formData).toString())
	let body = new URLSearchParams(formData).toString()
	
	let options = {
		method : method,
		headers : headers
	}
	
	fetch(url, options)
		.then((resp)=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error(`에러발생, 상태코드 : ${resp.status}`);
			}
		}).then(data=>{
			console.log(data)
			})
		.catch(err=>console.log(err));
});

