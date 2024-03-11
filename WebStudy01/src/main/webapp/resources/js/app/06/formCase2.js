/**
 * 
 */
// case1 : a 태그의 요청을 비동기로


let aTags = document.querySelectorAll("a")
console.log(aTags);
aTags.forEach(v=>{
	v.addEventListener("click", e=>{
		e.preventDefault();
		let url = e.target.href;
		let p5 = v.dataset.p5; //이름에 속지말자.set으로 되있지만 이친구는 map이다. 
		let options = {
			method : "post",
			headers:{
				"Accept" : "application/json",
				"Content-type" : "application/x-www-form-urlencoded" 
			},
			body : "p5="+p5
		};
		fetch(url,options)
			.then(resp=>{
				if(resp.ok){
					return resp.json()
				}else{
					throw new Error(`요청 처리 실패, 상태코드 : ${resp.status}`);
				}
			}).then(obj=>console.log(obj))
			.catch(err=>console.log(err)); 
	}); 
})

// case2 : form (get/post둘다 적용 가능. 파라미터 개수도 상관 없음.)
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
		"accept" : "text/html"
	};
	
	//request body
	let formData = new FormData(form); //form안에 파라미터값이 모두 들어있기에
	console.log(new URLSearchParams(formData).toString())
	let body = new URLSearchParams(formData).toString()
	
	let options = {
		method : method,
		headers : headers
	}
	
	if(method=="get"){
		url = `${url}?${body}`
	}else{
		options.body = body
	}
	
	fetch(url, options)
		.then((resp)=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`에러발생, 상태코드 : ${resp.status}`);
			}
		}).then(html=>{
			//document.body.innerHTML = document.body.innerHTML + html;
			resultArea.innerHTML=html; //(안좋은 코드임)
			})
		.catch(err=>console.log(err));
});

