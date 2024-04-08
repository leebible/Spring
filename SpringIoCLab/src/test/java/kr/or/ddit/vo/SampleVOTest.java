package kr.or.ddit.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SampleVOTest {

	@Test
	void test() {
		SampleVO vo1 = SampleVO.builder().build(); //기본생성자 호출한것과 같음. vo1에는 프로퍼티가 없고 다 null인상태.
		log.info("vo1 : {}", vo1);
		
		SampleVO vo2 = SampleVO.builder()
							.id("a001") //setter 호출한것임
							.build();
		log.info("vo2 : {}", vo2);
		SampleVO vo3 = SampleVO.builder()
				.id("a001")
				.name("김은대")
				.build();
		log.info("vo3 : {}", vo3);
		
		SampleVO vo4 = SampleVO.builder()
				.id("a001")
				.name("김은대")
				.role("ROLE_USER")
				.build();
		log.info("vo4 : {}", vo4);
		//객체 생성-> 객체에 프로퍼티를 넣어주는게 한문장으로 끝남
	}

}
