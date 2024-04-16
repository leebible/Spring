package kr.or.ddit.member.controller;

import javax.servlet.annotation.WebServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController{
	public static final String MODELNAME = "member";
	private final MemberService service; 
	
	@GetMapping
	public String memberInsert() {
		return "member/memberForm";
	}
	
	@PostMapping
	public String insertProcess(Model model
			, @Validated(InsertGroup.class) @ModelAttribute(MODELNAME) MemberVO member
			, BindingResult errors) {
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createMember(member);
			switch (result) {
			case PKDUPLICATED:
				model.addAttribute("message", "아이디 중복, 바꾸셈.");
				viewName = "member/memberForm";
				break;
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "member/memberForm";
				break;
			default:
				viewName = "redirect:/";
				break;
			}
		}else {
			viewName = "member/memberForm";
		}
		
		return viewName;
	}

	
}


























