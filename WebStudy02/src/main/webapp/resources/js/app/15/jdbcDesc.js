/**
 * 
 */
document.addEventListener("DOMContentLoaded",()=>{
	
const cPath = document.body.dataset.contextPath

let url=`${cPath}/15/jdbcDesc.do`; //현재 브라우저 사용. 컨트롤러에서 컨텐츠 협상구조가 이뤄져야함
let method="GET";
let headers = {
	accept : "application/json"
}
fetch(url,{ // json data 를 수신하고, CSR방식으로 html 소스 생성 //페이지가 랜더링 되자마자 비동기로 넘어간다는 뜻
	method : method,
	headers : headers
}).then(resp=>resp.json())
	.then(({headers,propsName,resultList})=>{ //중괄호 자체가 outter가 된다.
		console.log(headers, propsName, resultList);
		let trTags=`<tr>${headers.map(cn=>`<th>${cn }</th>`).join("")}</tr>` //sugar syntax
//		밑 4줄의 코드를 위 한줄로 바꿈
//		let trTag= `<tr>`;
//		for(let colNames of headers){
//			trTag =+ `<th>${colName }</th>`;
//		}
//		trTag +="</tr>";
	
		window['head-area'].innerHTML = trTags;
		for(let propsMap of resultList){
			trTags += `<tr>${propsName.map(pn=>`<td>${propsMap[pn] }</td>`).join("")}</tr>`;
//		밑 5줄의 코드를 위 한줄로 바꿈
//			trTags += `<tr></tr>`;
//			trTags += "<tr>";
//			for(let propName of propsName){
//				trTags += `<td>${propsMap[propName] }</td>`;	
//			}
//			trTags += "</tr>";
		}
		window['data-area'].innerHTML = trTags;
	}).catch(err=>console.error(err));

	
});

