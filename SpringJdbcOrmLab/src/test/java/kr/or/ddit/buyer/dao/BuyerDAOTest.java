package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractModelContextTest;

class BuyerDAOTest extends AbstractModelContextTest{
	@Resource(name="buyerDAO") //autowired쓸수있지만 이번에 resource로! COC 패러다임. 프록시가 등록되어있다면 주입받을수 있음
	BuyerDAO buyerDAO;
	
	@Test
	void testSelectBuyerList() {
		buyerDAO.selectBuyerList();
	}

}
