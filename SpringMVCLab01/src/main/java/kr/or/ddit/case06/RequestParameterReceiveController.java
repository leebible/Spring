package kr.or.ddit.case06;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case06")
public class RequestParameterReceiveController {
	
	@RequestMapping("param4")
	public String handler4(Optional<Integer> numParam) { //java8버전 이후에만 가능한 구조
		int number = numParam.orElse(1);
		log.info("numParam : {}", number);
		return "jsonView";
	}
	
	@RequestMapping("param3")
	public String handler3(@RequestParam(defaultValue="1") int numParam) { //requestparam을 붙이지 않아도 기본적으로 붙여줌(?) @RequestParam(required = false)가 기본으로!
		log.info("numParam : {}", numParam);
		return "jsonView";
	}
	
	@RequestMapping("param2")
	//requestparam : 파라미터 하나를 받을때 사용. required 옵션에 따라 필수/옵션 설정 가능. default로 null처리 가능
	public void handler2(Model model, @RequestParam(required = false, defaultValue = "DEFAULT") String what){ //request가 optional로 처리
		log.info("what : {}", what);
		model.addAttribute("what", what);
	}
	
	@GetMapping("param1")
	public String handler1(@RequestParam(required = true) String who, Model model) { //request 필수파라미터 - 검증구조 필요(required=true), name은 who로받았으니 생략
		log.info("who : {}", who); 
		model.addAttribute("who",who);
		return "jsonView";
		
	}

}
