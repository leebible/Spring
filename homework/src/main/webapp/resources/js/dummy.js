/**
 * 
 */
alert("DUMMY");

let divTag = document.getElementById("mainArea"); //1단계
let handler = function(event){ //3단계
	let target = event.target;
	console.log(target === divTag)
	target.style.backgroundColor = "red";
};
divTag.addEventListener("click", handler) //2단계
