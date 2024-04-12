/**
 * 
 */
setInterval(()=>{
    clientArea.innerHTML = Date.now();
	fetch("../now")
	 .then(resp=>resp.text())
	 .then(n=>serverArea.innerHTML=n)
}, 1000);

