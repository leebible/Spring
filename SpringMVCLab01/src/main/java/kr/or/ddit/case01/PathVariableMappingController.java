package kr.or.ddit.case01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case01/mapping5")
public class PathVariableMappingController {
	@GetMapping("{no}/{name}") //name까지 들어오면 내가 받겠어
	public void handler1() {
		log.info("/case01/mapping5/no/name handler 동작");
	}
	@GetMapping("{no}") //no까지만 넘어오면 내가 받겠어
	public void handler2() {
		log.info("/case01/mapping5/no handler 동작");
	}
	@GetMapping
	public void handler3() {
		log.info("/case01/mapping5 handler 동작");
	}
}
