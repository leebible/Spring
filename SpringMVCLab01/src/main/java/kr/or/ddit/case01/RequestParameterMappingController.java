package kr.or.ddit.case01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case01/mapping4") //핸들러가 있을수도 있다 는 뜻
public class RequestParameterMappingController {
	
	@RequestMapping(params = "who") //Get이든 Put이든 받겠다
	public void handler1() {
		log.info("who 파라미터가 있는 요청의 handler");
	}
	@RequestMapping //파라미터의 유무에 따라서 식별성을 받겠다
	public void handler2() {
		log.info("who 파라미터가 없는 요청의 handler");
	}
}
