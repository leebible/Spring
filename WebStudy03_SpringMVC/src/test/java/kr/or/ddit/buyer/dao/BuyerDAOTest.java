package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerDAOTest extends AbstractRootContextTest{

	@Autowired
	BuyerDAO dao;
	
	@Test
	void testSelectBuyerList() {
		dao.selectBuyerList().forEach(b->log.info("buyer : {}", b));
	}

	@Test
	void testSelectBuyer() {
		BuyerVO buyer = dao.selectBuyer("P10101");
		log.info("buyer : {}", buyer);
	}

}
