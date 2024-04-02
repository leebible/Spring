/**
 * 
 */
let forms = document.forms;

forms[0].addEventListener("submit", e=>{
	e.preventDefault();
	let form = e.target;
	
	let url = form.action;
	let method = form.method;
	
	let headers = {
		"content-type" : form.enctype,
		"accept" : "text/html"
	}
	
	let formData = new FormData(form);
	let body = new URLSearchParams(formData).toString();
	console.log(body)
	console.log(formData)
		
	
	let options = {
		method: method,
		headers : headers,
		body : body
	}
	
	fetch(url, options)
		.then((resp)=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`에러발생, 상태코드 : ${resp.status}`);
			}
		}).then(html=>{
			window['bts-area'].innerHTML=html;
			})
		.catch(err=>console.log(err));
});
		
	
	
	
