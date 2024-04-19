package kr.or.ddit.case08;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.case07.vo.BankInfoVO;



//@Controller
//@ResponseBody //이 컨트롤러에 등록되는 모든 메소드는 ViewResolver 안쓰고메세지 컨버트를 이용한다는 뜻
@RestController
@RequestMapping("/case08")
public class JsonRESTController {
	@RequestMapping("rest2")
	public String handler2(){
		return "JSONVIEW";
		
	}
	
	@RequestMapping("rest1")
	public BankInfoVO handler1() {
		return bank();
	}
	
	private BankInfoVO bank() {
		BankInfoVO target = new BankInfoVO();
		target.setBankName("하나은행");
		target.setBankNo("11-111-111");
		target.setBankDate(LocalDate.now());
		return target;
	}

}
