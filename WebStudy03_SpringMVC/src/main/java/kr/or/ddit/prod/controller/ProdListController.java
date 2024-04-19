package kr.or.ddit.prod.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.paging.SimpleCondition;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProdListController {
	@Autowired
	private ProdService service;
	
	@PostConstruct
	public void init() {
		log.info("주입된 service : {}", service.getClass().getName());
	}
	@RequestMapping("/prod/prodList.do")
	public String prodlist(Model model
			, @RequestParam(required=false, defaultValue="1") int currentPage
			, @ModelAttribute("condition") SimpleCondition simpleCondition
	){
		PaginationInfo paging = new PaginationInfo(10, 5);
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<ProdVO> prodList = service.retrieveProdList(paging);
		// scope
		model.addAttribute("prodList", prodList);
		PaginationRenderer render = new DefaultPaginationRenderer();
		
		
		model.addAttribute("pagingHTML", render.renderPagination(paging, "paging"));
		// view
		return "prod/prodList";
	}

}