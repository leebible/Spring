package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractModelContextTest;

class PersonDAOTest extends AbstractModelContextTest{
	@Autowired
	PersonDAO personDAO;
	@Test
	void testSelectPersonList() {
		personDAO.selectPersonList();
	}

	@Test
	void testSelectPerson() {
		personDAO.selectPerson("M0014");
	}

}
