package kr.or.ddit.case04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * MVC 패턴
 * Model : information
 * View : UI
 * Controller : information + UI
 *
 */
@Controller
@RequestMapping("/case04")
public class MVCPatternController {
	
	@RequestMapping("model3")
	public ModelAndView handler3() { //String데이터가 Logical View Name이 되어야함,  컨트롤러로 등록하려면 1.bean등록(어노테이션) 2.handler..
		String info = "가공된 인포메이션";
		ModelAndView mav = new ModelAndView();
		mav.addObject("info", info);
		mav.setViewName("case04/view1");
		return mav;
	} //controller에선 1.model과 2.viewname에 대한 정보가 정해져야함
	
	
	@RequestMapping("model2")
	public String handler2(Model model) { //String데이터가 Logical View Name이 되어야함,  컨트롤러로 등록하려면 1.bean등록(어노테이션) 2.handler..
		String info = "가공된 인포메이션";
		model.addAttribute("info", info);
		return "case04/view2"; 
	}
	
	@RequestMapping("model1")
	public String handler1(HttpServletRequest req) { //String데이터가 Logical View Name이 되어야함,  컨트롤러로 등록하려면 1.bean등록(어노테이션) 2.handler..
		String info = "가공된 인포메이션";
		req.setAttribute("info", info);
		return "case04/view1"; 
	}

}
