/**
 * 
 */
window['ua-btn'].addEventListener("click", (e)=>{
	let agent = window.navigator.userAgent;
	const BrowserInfo = {
		 EDG:"엣지",
	    CHROME:"크롬",
	    WHALE:"웨일",
	    OTHERS:"기타",
		findBrowserName:function(agent){
			agent = agent.toUpperCase();
			let browerName = this.OTHERS;
			for(let prop in this){
				if(agent.indexOf(prop) >= 0){
					browerName = this[prop];
					break;
				}
			}
			return browerName;
		}
	}
	BrowserInfo['SAFARI'] = "사파리";
	
	let brName = BrowserInfo.findBrowserName(agent);
	msgArea.innerHTML = brName;
});

// document.querySelectorAll("a.asyncA")
document.addEventListener("click", (e)=>{
	if(! e.target.classList.contains("asyncA")) return false;
	e.preventDefault();
	let aTag = e.target;
	let url = aTag.href;
	let method = aTag.dataset.method ?? "get";
	let headers = {
		"accept" : "text/html" 
	}
	let options = {
		method:method,
		headers:headers
	}
	fetch(url, options)
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`처리 실패 상태코드 : ${resp.status}`);
			}
		}).then(html=>{
			msgArea.innerHTML = html;
		})
		.catch()
});











