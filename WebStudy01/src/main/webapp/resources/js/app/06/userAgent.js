/**
 * 
 */
let aTags = document.querySelectorAll("a")
console.log(aTags);
aTags.forEach(v=>{
	v.addEventListener("click", e=>{
		e.preventDefault();
		let url = e.target.href;
		let options={
			method : "post",
			headers:{
				"Accept" : "text/html",
				"Content-type" : "application/x-www-form-urlencoded" //body로 보낼 내용이 없기에 이 구문은 없어도됌
			}
		};
		fetch(url,options)
			.then(resp=>{
				if(resp.ok){
					return resp.text();
				}else{
					throw new Error(`요청 처리 실패, 상태코드 : ${resp.status}`);
				}
			}).then(html=>{
				msgArea.innerHTML = html;
				})
			.catch(err=>console.log(err))
	})
})


//선생님이 해주신 js
document.addEventListener("click", e=>{
	if(!e.target.classList.contains("asyncA")) return false;
	e.preventDefault();
	let aTag = e.target;
	let url = aTag.href;
	//let method = aTag.dataset.method ? aTag.dataset.method : "get"; //삼항연산자
	let method = aTag.dataset.method ?? "get"; //중복 최소화
	let headers = {
		"Accept": "text/html"
	}
	let options = {
		method : method,
		headers : headers
	}	
	fetch(url, options) //프로미스 리절브함수와 리젝트 함수 필요함
		.then(resp=>{
			if(resp.ok){
				return resp.text();//프로미스가 반환. 이유는 dom parser가 동작해야되기 때문. 파싱할수있는 시간을 벌기 위해 프로미스가 반환
			}else{
				throw new Error(`처리 실패 상태코드 : ${resp.status}`);
			}
		}).then(html=>{ 
			msgArea.innerHTML = html; //특정엘리먼트가 갖고있는 id속성은 바로 가져올수 있음
		}) //리절브함수
		.catch() //리젝트함수
})

document.getElementById("btn").addEventListener("click", e=>{
	e.preventDefault();
	let nua =  navigator.userAgent;
	nuaa = nua.toUpperCase();
	let browserName;
		if(nuaa.indexOf("EDGE")>-1) browserName = "엣지";
		else if(nuaa.indexOf("FIREFOX")>-1) browserName ="파이어폭스";
		else if(nuaa.indexOf("CHROME")>-1) browserName ="크롬";
		else if(nuaa.indexOf("SAFARI")>-1) browserName = "사파리";
		else browserName = "기타";
	msgArea.innerHTML = `현재 당신이 사용하는 브라우저는 ${browserName} 입니다`;
	
})