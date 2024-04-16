package kr.or.ddit.member.controller;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MypageController {
	private final MemberService service;
	
	@GetMapping("/mypage")
	public String myPage(HttpServletRequest req, Model model) {
		MemberVOWrapper principal = (MemberVOWrapper) req.getUserPrincipal();
		MemberVO member = service.retrieveMember(principal.getName());
		model.addAttribute("member", member);
		return "member/mypage";
		
	}
}
















