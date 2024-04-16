package kr.or.ddit.prod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController {
	public static final String MODELNAME = "prod";
	private final ProdService service;
	
	@GetMapping
	public String formHandler(Model model, @RequestParam String what){
		ProdVO prod = service.retrieveProd(what);
		model.addAttribute(MODELNAME, prod);
		
		return "prod/prodEdit";
	}

	@PostMapping
	public String updateProcess(Model model
			, @Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
			, BindingResult errors, RedirectAttributes redirectAttributes) {
		
		boolean valid = !errors.hasErrors();
		String viewName = null;
		if(valid) {
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 수정하세요.");
				viewName = "prod/prodEdit";
				break;

			default:
				viewName = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
				break;
			}
		}else {
			viewName = "prod/prodEdit";
		}
		redirectAttributes.addFlashAttribute("prod", prod);
		return viewName;
	}

	
}
