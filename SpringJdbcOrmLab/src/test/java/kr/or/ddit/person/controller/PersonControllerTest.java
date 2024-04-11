package kr.or.ddit.person.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractModelContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonControllerTest extends AbstractModelContextTest {
	@Autowired
	PersonController controller;
	@Test
	void testPersonListToResponse() {
		controller.personListToResponse().forEach(p->log.info("person : {}", p));
	}

}
