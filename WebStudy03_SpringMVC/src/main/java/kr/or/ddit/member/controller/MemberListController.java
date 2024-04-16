package kr.or.ddit.member.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberListController{
	private final MemberService service;
	
	@GetMapping("/member/memberList.do")
	public String memberHandler(Model model) {
		List<MemberVO> memberList = service.retrieveMemberList();
		model.addAttribute("memberList", memberList);
		return "member/memberList";
	} 
}

















