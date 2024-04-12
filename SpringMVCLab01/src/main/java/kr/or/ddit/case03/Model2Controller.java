package kr.or.ddit.case03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/case03")
public class Model2Controller {
	@RequestMapping("view-3")
	public ModelAndView handler3() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("case03/view3");
		return mav;
	}
	
	@RequestMapping("view2") // logical view name : case03/view2 //COC원리에 따라서 작동.명확하지 않은 단점은 있지만 코딩양을 줄있수있다는 장점이 있음
	public void handler2() { 
	}
	
	@GetMapping("view1")
	public String handler1() {
		return "case03/view1";
	}
}
