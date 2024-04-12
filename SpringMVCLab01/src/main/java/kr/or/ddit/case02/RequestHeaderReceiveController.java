package kr.or.ddit.case02;

import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case02")
public class RequestHeaderReceiveController { //헤더 정보를 받는방법
	@RequestMapping("header6")
	public void handler5(@RequestHeader Optional<String> optHeader) { //java8이후에 optional..
		log.info("optHeader : {}", optHeader.orElse("default value"));
	}

	@RequestMapping("header5") //숫자로받기
	public void handler5(@RequestHeader(name = "myHeader", required = false, defaultValue = "1000") long myHeader) { //숫자로 받고싶다? 필요한건 Spring에게 부탁하기
		log.info("myHeader : {}", myHeader);
	}
	
//	@RequestMapping("header5") //String으로 받기
//	public void handler5(@RequestHeader(name = "myHeader", required = false, defaultValue = "defaultheader") String myHeader) { //required = false, defaultValue = "defaultheader" : 없다면 기본값으로 defaultheader
//		log.info("myHeader : {}", myHeader.toString());
//	}
	
	@RequestMapping("header4")
	public void handler4(@RequestHeader(name = "accept", required = true) String accpet) { //required로 필수/optional헤더를 결정해줌. false면 null값을 넣어줌
		log.info("accept : {}", accpet);
	}
	
	@RequestMapping("header3")
	public void handler3(@RequestHeader MultiValueMap<String,String> headers) {
		headers.forEach((k,v)->log.info("{} : {}",k,v)); 
	}
	
	@RequestMapping("header2")
	public void handler2(@RequestHeader Map<String, Object> headers) { //request의 헤더가 필요함
		headers.forEach((k,v)->log.info("{} : {}",k,v)); //헤더의이름, 헤더의값
	}
	
	@RequestMapping("header1")
	public void handler1(HttpServletRequest req) { //request가 필요하면 핸들러 메소드의 argument로 받으면됨
		Enumeration<String> names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String headerName = (String) names.nextElement();
			String headerValue = req.getHeader(headerName);
			log.info("{} : {}", headerName, headerValue);
		}
	}
}
