package kr.or.ddit.mission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/case05")
public class Case05MissionController { //1. bean등록 -> 2.handlerMapping(tracing)
	
	
	//실제로 호출해주는건 
	@RequestMapping("step1")
	public String handler1(Model model) {
		log.info("step1번 요청 접수");
		model.addAttribute("step1Info","step1 에서 만든 모델");
		return "forward:/mission/case05/step2";
	}
	
	@RequestMapping("step2")
	public String handler2(@RequestAttribute(required=false) String step1Info,RedirectAttributes redirectAttributes) {
		log.info("step2번 요청 접수");
		redirectAttributes.addFlashAttribute("step1Info",step1Info);
		redirectAttributes.addFlashAttribute("step2Info","step2 에서 만든 모델");
		return "redirect:/mission/case05/step3";
	}
	
	@RequestMapping("step3")
	public String handler3(Model model) {
		model.addAttribute("step3Info","step3 에서 만든 모델");
		return "case05/mission";
		
	}
}
