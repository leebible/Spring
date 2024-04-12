package kr.or.ddit.case01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * 스프링으로 컨트롤러를 구현하는 방법
 * 1. POJO로 컨트롤러 구현. //메소드이름, 리턴타입, 파라미터에 전혀 제한이 없다는 뜻. 개발자는 자유도가 올라가지만 프레임워크에서 다 커버해야함(정교한 리플렉션 코드가 들어가야함)
 * 2. @Controller 로 컨테이너에 빈 등록.
 * 3. 각 커맨드 핸들러를 메소드로 구현
 * 4. @RequestMapping 계열의 어노테이션으로 요청 매핑 조건 설정.
 * 		- url, method, accept, content-type, parameter, path variable
 * 
 */
@Slf4j
@Controller
@RequestMapping("/case01/mapping1")
public class ControllerDesc {
	
	@RequestMapping("request1")
	public void handler1() {
		log.info("handler1 번 동작");
	}
	
	@RequestMapping("request2")
	public void handler2() {
		log.info("handler2 번 동작");
	}
	
	@RequestMapping("request3")
	public void handler3() {
		log.info("handler3 번 동작");
	}
	
}
