package kr.or.ddit.mission;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/case01")
public class MymindMappingContorller {
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void handler1Get() {
		log.info("응답 컨텐츠로 json 을 요청한 경우의 handler");
	}
	
	@PostMapping
	public void handler1Post() {
		log.info("응답 컨텐츠로 json이외의 요청을 한 경우의 handler");
	}
}
