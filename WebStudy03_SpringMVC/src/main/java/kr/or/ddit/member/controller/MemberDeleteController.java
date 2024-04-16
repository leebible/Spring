package kr.or.ddit.member.controller;


import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberDeleteController{
	private final MemberService service;
	
	@PostMapping("/member/memberDelete.do")
	public String memberDelete(ServletRequest request, Model model
			, @Validated @ModelAttribute(name="member") MemberVO inputData
			, @RequestParam String memId
			, @RequestParam String memPass,
			RedirectAttributes redirectAttributes) {
		String viewName = null;
		
//		3. 로직 사용
		ServiceResult result = service.removeMember(inputData);
//		4. 로직으로부터 확보한 모델을 공유
		switch (result) {
		case INVALIDPASSWORD:
			redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
			viewName = "redirect:/mypage";
			break;
		case FAIL:
			redirectAttributes.addFlashAttribute("message", "서버 오류");
			viewName = "redirect:/mypage";
			break;

		default:
			viewName = "forward:/login/logout.do";
			break;
		}
		
		return viewName;
	}
}
















