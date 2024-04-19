package kr.or.ddit.case09;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import kr.or.ddit.case07.vo.BankInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/case09", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class RESTJsonUnmarshallingController {
	
	@PostMapping("jsonPayload3")
	public Map<String, Object> handler3(@RequestBody BankInfoVO bank) {
		log.info("{} 등록 실패", bank);
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("success", false);
		result.put("message", "실패 원인에 해당하는 메시지");
		result.put("target", bank);
		return result;
	}
	
	@PostMapping("jsonPayload2")
	public boolean handler2(@RequestBody BankInfoVO bank) {
		log.info("{} 등록 성공", bank);
		return true;
	}
	
	@PostMapping("jsonPayload1")
	public BankInfoVO handler1(@RequestBody BankInfoVO bank) { //model attribute가 생략된거.
		bank.setBankDate(LocalDate.now());
		return bank;
	}

}
