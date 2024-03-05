package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PersonVO;

class PersonDAOImplTest {
	PersonDAO dao = new PersonDAOImpl();
	@Test
	void testSelectPersonList() {
		List<PersonVO> people = dao.selectPersonList();
		System.out.println(people.size());
	}

	@Test
	void testSelectPerson() {
		// assertion 구조를 통해 테스트 결과를 추정함.
		assertNotNull(dao.selectPerson("A0011")); //예상하는 메소드..?
	}
	
	
	@Test
	void testSelectPersonNotExist() {
		// assertion 구조를 통해 테스트 결과를 추정함.
		assertNull(dao.selectPerson("asdf")); //예상하는 메소드..?
	}
	

}
