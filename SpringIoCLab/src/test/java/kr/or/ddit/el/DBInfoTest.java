package kr.or.ddit.el;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case6.CollectionDIOuter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "classpath:kr/or/ddit/el/conf/El-Context.xml")
class DBInfoTest {
	

	@Autowired
	DBInfo dbinfo;
	
	@Test
	void test() {
		log.info("dbinfo : {}", dbinfo);
	}

}
