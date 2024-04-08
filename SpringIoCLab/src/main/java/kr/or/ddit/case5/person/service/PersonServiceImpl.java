package kr.or.ddit.case5.person.service;

import java.util.List;

import kr.or.ddit.case5.person.dao.PersonDAO;
import kr.or.ddit.case5.person.dao.PersonDAOImpl;
import kr.or.ddit.case5.person.exception.PersonNotFoundException;
import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
	private final PersonDAO dao;

	@Override
	public List<PersonVO> retrievePersonList() {
		List<PersonVO> people = dao.selectPersonList();
		for(PersonVO once :people) {
			System.out.printf("%s 조회함.\n", once.getName());
		}
		return people;
	}

	@Override
	public PersonVO retrievePerson(String id) {
		PersonVO person = dao.selectPerson(id);
		if(person==null)
			throw new PersonNotFoundException(id); //custom exception. 보통  business logic에서 많이 쓰임
		return person;
	}

}
