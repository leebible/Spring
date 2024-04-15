package kr.or.ddit.mission;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mission/case06")
public class Case06MissionController {
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void process2(Model model, @RequestParam(required=true) double leftOp, @RequestParam(required=true) double rightOp) {
		double result = leftOp + rightOp;
		model.addAttribute("result",result);
		model.addAttribute("leftOp",leftOp);
		model.addAttribute("rightOp",rightOp);
	}
	
	@PostMapping
	public String process(RedirectAttributes redirectAttributes,Model model, @RequestParam(required=true) double leftOp, @RequestParam(required=true) double rightOp) {
		double result = leftOp + rightOp;
		redirectAttributes.addFlashAttribute("result",result);
		redirectAttributes.addFlashAttribute("leftOp",leftOp);
		redirectAttributes.addFlashAttribute("rightOp",rightOp);
//		model.addAttribute("result", result);
		return "case06/mission"; //응답데이터 : html
	}
	
	@GetMapping
	public String formHandler() {
		return "case06/missionForm";
	}
}
