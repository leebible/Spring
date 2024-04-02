/**
 * 
 */
const cPath = document.body.dataset.contextPath
const log = console.log;//상수선언


document.querySelectorAll("li.folder>a").forEach(a=>{ //자식엘리먼트 안에 있는 a태그
	a.addEventListener("click", e=>{
		e.preventDefault();
		let type= a.dataset.click;
		let url= `${a.href}&type=${type}`;
		let method="get";
		let headers = {
			"accept" : "application/json",
			
		};
		fetch(url, {
			method : method,
			headers:headers
		}).then(resp=>resp.json())
		.then(outter=>{ //json원문데이터가 언마샬링된 이후의 객체가 들어와야함
			let jsonObj = outter.wrapperList; //위에 상수 선언. javaScript는 함수의 레퍼런스를 받을수 있는 구조. -> 다음주에 java에서 람다를 표현하는 걸 배울 예정이라 잘 기억해두기!
			log(jsonObj)
			
			let ulTag2 ='<ul class="col-6">';
			for(let wrapper of jsonObj)	{//향상된 for문
				ulTag2 += `
					<li data-name="${wrapper.name}" id="${wrapper.path }" class="${wrapper.file?'file':'folder' }">${wrapper.name}</li>
				`;
			}
			ulTag2 += "</ul>";
			log("js의ulTag2:"+ulTag2);
			
			window['right-area'].innerHTML = ulTag2 //div id변수 받는 방법 1. 글로벌변수에서 연산배열 2.document..로받아오기
			
		}).catch(e=>console.error(e));
	
	});
	
	a.addEventListener("dblclick", e=>{
		e.preventDefault();
		let type= a.dataset.dblclick;
		let url= `${a.href}&type=${type}`;
		window.location.href = url;
		
	})
	
})

document.querySelector("#right-area").addEventListener("click",(e)=>{
	if(!e.target.classList.contains('file')) return false;
	
	let url = `${cPath}/case2/fileInfo`;
	let method = "get";
	let headers = {
		"accept" : "application/json",
	};
	let urlSearchParams = new URLSearchParams();
	let path = e.target.id; 
	
	urlSearchParams.append("path",path) 
	
	let queryString = urlSearchParams.toString();
	log(queryString)
	fetch(`${url}?${queryString}`,{
		method : method,
		headers : headers
	}).then(resp=>resp.json())
	.then(jsonObj=>{
		log(jsonObj);
		log(e.target.dataset.name)
		e.target.innerHTML = e.target.dataset.name + ", " + jsonObj.size;
	}).catch(err=>console.error(err));
	
})
	
	




