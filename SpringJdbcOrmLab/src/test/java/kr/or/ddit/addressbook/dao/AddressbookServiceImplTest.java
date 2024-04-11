package kr.or.ddit.addressbook.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.addressbook.service.AddressbookService;
import kr.or.ddit.vo.AddressbookVO;
import lombok.extern.slf4j.Slf4j;

@Transactional //선언적 프로그래밍, AOP 방법에 따른 트랜잭션관리
class AddressbookServiceImplTest extends AbstractModelContextTest{
	@Autowired //필드에 나가면 inject도 쓰임. 같은의미
	AddressbookService service;
	
	@Test
	void testSelectAddressBookList() {
		service.selectAddressBookList();
	}

	@Test
	void testSelectAddress() {
		service.selectAddress(1L);
	}

	@Test
	void testInsertAddress() {
		AddressbookVO abook = new AddressbookVO();
		abook.setAdrsName("김은대");
		abook.setAdrsAdd("대전시 동구 용운동 222-2번지2");
		abook.setAdrsTel("010-6217-46152");
		abook.setMemId("b001");
		service.insertAddress(abook);
	}

}
