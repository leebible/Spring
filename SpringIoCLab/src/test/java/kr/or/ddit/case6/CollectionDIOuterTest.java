package kr.or.ddit.case6;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "classpath:/kr/or/ddit/case6/conf/Case6-Context.xml")
class CollectionDIOuterTest {//2.해당 클래스가 bean으로 등록되어야함
	
	@Autowired
	CollectionDIOuter outer1; //1. 생성자 혹은 setter 주입 필요.
	@Resource(name = "outer2")//id명시..Autowired보다 더 안전함!
	CollectionDIOuter outer2; 
	@Test
	void test() {
		log.info("outer : {}", outer1);
		log.info("outer : {}", outer2);
	}

}
