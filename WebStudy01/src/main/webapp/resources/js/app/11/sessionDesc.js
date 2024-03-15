/**
 * 
 */


const SPEED = 100;
const contextPath = document.body.dataset.contextPath;
class SessionTimer2 {
	constructor(timeout, element) {
		this.timeout = timeout; //이 생성자의 객체 reference에 접근할수 있음. 프로퍼티 추가
		this.element = element; //이제 총 두개의 property
		this.element.sessionTimer = this;
		this.init();
	}

	createMessageArea() {
		let source = ` 
				<div style='display:none;'>
				<h4>세션을 연장하시겠습니까?</h4>
				<button class="control" data-ts-state="true">예</button>
				<button class="control">아니요</button>
				</div>
			`;
		this.msgArea = new DOMParser().parseFromString(source, 'text/html').body.children[0]; //새로운 DOM객체가 만들어짐
		this.msgArea.addEventListener("click", function(e) {
			if (e.target.dataset.tsState) {
				this.reset();
			}
			this.msgArea.style.display = "none";
		}.bind(this));
		this.element.after(this.msgArea); //jquery의 this와 다름. 함수의 주인객체를 변경해보자!
	}//웬만하면 라이브러리에서는 id를 쓰지 않는다.


	//타이머를 초기화 하는 모듈
	init() {
		fetch("", { method: "head" });
		this.timer = this.timeout;
		this.element.innerHTML = this.timeout;
		this.createMessageArea();
		let obj = this;
		this.timeoutId = setTimeout(function() {
			obj.msgArea.style.display = "block";
		}, (this.timeout - 60) * SPEED);
		this.intervalId = setInterval(() => { //이 함수의 소유자는 window. interval id라는게 반환되고 있음. setinterval반복적인작업을하는 스케줄링 함수
			if (obj.timer > 0) {
				obj.timer--;
			} else {
				obj.destroy();
			}
			obj.element.innerHTML = obj.timer;
		}, SPEED);
	}

	destroy() {
		clearInterval(this.intervalId);
		clearTimeout(this.timeoutId);
		//document.body.removeChild(this.msgArea);
		this.msgArea.remove();
	}

	reset() {
		this.destroy();
		this.init();
	}



}



const SessionTimer = function(timeout, element) {
	this.timeout = timeout; //이 생성자의 객체 reference에 접근할수 있음. 프로퍼티 추가
	this.element = element; //이제 총 두개의 property
	this.element.sessionTimer = this;

	this.createMessageArea = function() {
		let source = ` 
			<div style='display:none;'>
			<h4>세션을 연장하시겠습니까?</h4>
			<button class="control" data-ts-state="true">예</button>
			<button class="control">아니요</button>
			</div>
		`;
		this.msgArea = new DOMParser().parseFromString(source, 'text/html').body.children[0]; //새로운 DOM객체가 만들어짐
		this.msgArea.addEventListener("click", function(e) {
			if (e.target.dataset.tsState) {
				this.reset();
			}
			this.msgArea.style.display = "none";
		}.bind(this));
		this.element.after(this.msgArea); //jquery의 this와 다름. 함수의 주인객체를 변경해보자!
	}//웬만하면 라이브러리에서는 id를 쓰지 않는다.


	//타이머를 초기화 하는 모듈
	this.init = function() {
		fetch("", { method :  "head" });
		this.timer = this.timeout;
		this.element.innerHTML = this.timeout;
		this.createMessageArea();
		let obj = this;
		this.timeoutId = setTimeout(function() {
			obj.msgArea.style.display = "block";
		}, (this.timeout - 60) * SPEED);
		this.intervalId = setInterval(() => { //이 함수의 소유자는 window. interval id라는게 반환되고 있음. setinterval반복적인작업을하는 스케줄링 함수
			if (obj.timer > 0) {
				obj.timer--;
			} else {
				obj.destroy();
			}
			obj.element.innerHTML = obj.timer;
		}, SPEED);
	}

	this.destroy = function() {
		clearInterval(this.intervalId);
		clearTimeout(this.timeoutId);
		//document.body.removeChild(this.msgArea);
		this.msgArea.remove();
	}

	this.reset = function() {
		this.destroy();
		this.init();
	}


	this.init();
}

//[] : 해당 Attribute을 가져오겠다!
document.querySelectorAll("[data-ts-timeout]").forEach(element => {
	let timeout = element.dataset['tsTimeout'];
	console.log(timeout);
	new SessionTimer2(timeout, element);
});


//클릭은 버블링 구조. 버튼을 감싸고 있는 div를 선택한것.
stopBtn.addEventListener("click", () => {
	document.querySelectorAll("[data-ts-timeout]").forEach(element => {
		element.sessionTimer.destroy();
	});

})

