package kr.or.ddit.lprod.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.or.ddit.lprod.service.OthersService;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

/**
 * POJO(Plain Old Java Object)
 */
/**
 * kr.or.ddit.prod 패키지 아래의 모든 컨트롤러 대상으로 사전 weaving되는 advice
 */
@ControllerAdvice(basePackages = "kr.or.ddit.prod")
@RequiredArgsConstructor
public class OthersControllerAdvice {
	@Autowired
	private OthersService service;
	
	@ModelAttribute("lprodList")
	public List<LprodVO> addLprodList(Model model) {
		return service.retrieveLprodList();
	}
	
	@ModelAttribute("buyerList")
	public List<BuyerVO> addBuyerList(Model model) {
		return service.retrieveBuyerList();
	}
}
