/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	fetch("", {
		headers:{
			accept:"application/json"
		}
	}).then(resp=>resp.json())
	.then(({headers, propsName, resultList})=>{
		let trTag = `<tr>${headers.map(cn=>`<th>${cn }</th>`).join("")}</tr>`;
		window['head-area'].innerHTML = trTag;
		let trTags = "";
		for(let propsMap of resultList){
			trTags += `<tr>${propsName.map(pn=>`<td>${propsMap[pn] }</td>`).join("")}</tr>`;
		}
		window['data-area'].innerHTML = trTags;
	})
	.catch(err=>console.error(err));
});