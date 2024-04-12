package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonDAOTest extends AbstractRootContextTest{
	@Autowired
	PersonDAO dao;

	@Test
	void testSelectPersonList() {
		dao.selectPersonList().forEach(p->log.info("person : {}", p));
	}

	@Test
	void testSelectPerson() {
	}

}
