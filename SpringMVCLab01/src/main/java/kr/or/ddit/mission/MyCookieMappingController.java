package kr.or.ddit.mission;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/case02")
public class MyCookieMappingController {
	
	@RequestMapping //get으로만 받고 싶으면 GetMapping으로 바꾸면 됨
	public void handler1(
		@RequestHeader(name = "user-agent") String agent
		, @CookieValue(required = false, defaultValue = "1000") int myCookie
		) {
	}
}
