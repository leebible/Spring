package kr.or.ddit.member.controller;

import javax.servlet.http.HttpServletRequest;

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
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController {
	public static final String MODELNAME = "member";
	private final MemberService service;

	@GetMapping
	public String formHandler(HttpServletRequest request, Model model) {
		String memId = request.getUserPrincipal().getName();
		MemberVO member = service.retrieveMember(memId);
		model.addAttribute(MODELNAME, member);

		return "member/memberForm";
	}

	@PostMapping
	public String updateProcess(Model model, @Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) MemberVO member,
			BindingResult errors) {
		String viewName = null;
		if (!errors.hasErrors()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				model.addAttribute("message", "비밀번호 오류");
				viewName = "member/memberForm";
				break;
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "member/memberForm";
				break;
			default:
				viewName = "redirect:/mypage";
				break;
			}

		} else {
			viewName = "member/memberForm";
		}
		return viewName;
	}

}
