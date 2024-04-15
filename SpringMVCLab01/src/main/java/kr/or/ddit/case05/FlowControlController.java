package kr.or.ddit.case05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 *	일반적으로 controller 에서 사용하는 이동방식
 *	forward : controller --> view로 이동하는 경우.(logical view name 으로 이동)
 *			  controller --> controller로 이동하는 경우.
 *	redirect
 *
 */

@Slf4j
@Controller
@RequestMapping("/case05")
public class FlowControlController {
	@RequestMapping("start3")
	public String handler5(RedirectAttributes redirectAttributes) { //flashattribute를 설정할때는 session scope를 사용하지 않음. 
		// 대신 flashmapmanager를 사용함.
		//그 flashmapmanager에서 만들어진 attribute를 이동을 하면 handler4가 가지고 있는 model객체에다가 옮겨담아줌
		//Controller의 model은 1:1 관계. 서로의 model끼리는 다른 객체임!
		log.info("start3번 요청 접수");
		redirectAttributes.addFlashAttribute("info", "start3에서 만든 모델"); //info는 한번꺼내고 나면 삭제되는 모델임
		redirectAttributes.addFlashAttribute("info1", "start3에서 만든 모델"); //info는 한번꺼내고 나면 삭제되는 모델임
		redirectAttributes.addFlashAttribute("info2", "start3에서 만든 모델"); //info는 한번꺼내고 나면 삭제되는 모델임
		return "redirect:/case05/dest3";
	}
	
	@RequestMapping("dest3")
	public void handler6(Model model) { //model데이터의 모든걸 꺼내보자
		log.info("dest 3번 요청 접수");
		model.asMap().forEach((k,v)->log.info("{} : {}", k, v));//model은 key-value쌍의 형태를 가지고 있음
		
	}
	
	@RequestMapping("start2")
	public String handler3(RedirectAttributes redirectAttributes) { //flashattribute를 설정할때는 session scope를 사용하지 않음. 
		// 대신 flashmapmanager를 사용함.
		//그 flashmapmanager에서 만들어진 attribute를 이동을 하면 handler4가 가지고 있는 model객체에다가 옮겨담아줌
		//Controller의 model은 1:1 관계. 서로의 model끼리는 다른 객체임!
		log.info("start2번 요청 접수");
		redirectAttributes.addFlashAttribute("info", "start2에서 만든 모델"); //info는 한번꺼내고 나면 삭제되는 모델임 (=flash data) magager가 model에 copy해줌
		return "redirect:/case05/dest2";
	}
	
	@RequestMapping("dest2")
	public void handler4(Model model) {
		log.info("dest 2번 요청 접수, model : {}", model.getAttribute("info"));
	}
	
	@RequestMapping("start1")
	public String handler1(Model model) {
		log.info("start1번 요청 접수");
		model.addAttribute("info","start1에서 만든 모델");
		return "forward:/case05/dest1";
	}
	
	@RequestMapping("dest1")
	public void handler2(@RequestAttribute(required=false) String info) { //spring에서 받기 handler adapter , argument
														//required=true : start1을 꼭 거쳐야한다. false : direct로 와도 된다.
											//name = "info"이건 왜 생략가능?
		log.info("dest 1번 요청 접수, model : {}", info);
	}
}
