package kr.or.ddit.prod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProdDetailController{
	private final ProdService service;
	
	@RequestMapping("/prod/prodDetail.do")
	public String prodDetail(Model model, @RequestParam(name="what") String prodId) {
		ProdVO prod = service.retrieveProd(prodId);
		model.addAttribute("prod", prod);
		return "prod/prodDetail";
	}
}





















