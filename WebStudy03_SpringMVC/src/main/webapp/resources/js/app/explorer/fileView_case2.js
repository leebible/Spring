/**
 * 
 */
const cPath = document.body.dataset.contextPath;
const log = console.log;
document.querySelectorAll("li.folder>a").forEach(a=>{
	a.addEventListener("click", e=>{
		e.preventDefault();
		let type = a.dataset.click;
		let url = `${a.href}&type=${type}`;
		let method = "get";
		let headers = {
			"accept":"application/json"
		};
		fetch(url, {
			method:method,
			headers:headers
		}).then(resp=>resp.json())
		.then(outter=>{
			let jsonObj = outter.wrapperList;
			log(jsonObj);	
			//['1','2'].map(ele=>ele+"번째").join("\n")
			let ulTag =`<ul class="col-6">
				${jsonObj.map(wrapper=>`<li data-name="${wrapper.name}" id="${wrapper.path }" class="${wrapper.file?'file':'folder' }"></li>`).join("\n")}
			</ul>`;
			
			let ulTag2 = '<ul class="col-6">';
			for(let wrapper of jsonObj){
				ulTag2 += `
					<li data-name="${wrapper.name}" id="${wrapper.path }" class="${wrapper.file?'file':'folder' }">${wrapper.name}</li>
				`;
			}
			ulTag2 += "</ul>";
			log(ulTag2);
			window['right-area'].innerHTML = ulTag2;
		}).catch(e=>console.error(e));
	});
	a.addEventListener("dblclick", e=>{
		e.preventDefault();
		let type = a.dataset.dblclick;
		let url = `${a.href}&type=${type}`;
		window.location.href = url;
	});
});

document.querySelector("#right-area").addEventListener("click", (e)=>{
	if(!e.target.classList.contains("file")) return false;
	
	let url = `${cPath}/case2/fileInfo`;
	let method = "get";
	let headers = {
		"accept":"application/json"
	};
	let urlSearchParams = new URLSearchParams();
	let path = e.target.id;
	urlSearchParams.append("path", path);
	let queryString = urlSearchParams.toString(); 
	fetch(`${url}?${queryString}`, {
		method:method,
		headers:headers
	}).then(resp=>resp.json())
	.then(jsonObj=>{
		log(jsonObj.size);
		e.target.innerHTML = e.target.dataset.name + ", " + jsonObj.size;
	}).catch(err=>console.error(err));
});






























