package kr.or.ddit.member.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.paging.SimpleCondition;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberListController{
	private final MemberService service;
	
	@GetMapping("/member/memberList.do")
	public String memberHandler(Model model
			, @ModelAttribute("paging") PaginationInfo paging
//			, SimpleCondition simpleCondition
	) {
//		paging.setCurrentPage(currentPage);
//		paging.setSimpleCondition(simpleCondition);
		List<MemberVO> memberList = service.retrieveMemberList(paging);
		model.addAttribute("memberList", memberList);
		PaginationRenderer render = new DefaultPaginationRenderer();
		model.addAttribute("pagingFunction","paging");
		String pagingHTML = render.renderPagination(paging, "paging");
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "member/memberList";
	} 
}

















