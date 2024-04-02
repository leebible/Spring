package kr.or.ddit.buyer.dao;


import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerDAOTest {
	BuyerDAO dao = new BuyerDAOImpl();

	@Test
	void testSelectBuyerList() {
//		List<BuyerVO> buyerList = dao.selectBuyerList();
//		log.info("list : {}", buyerList);
		
		//가독성을 위해 반복문 돌려보기
		dao.selectBuyerList().forEach(b->log.info("buyer : {}",b));
	}

	@Test
	void testSelectBuyer() {
		String prodId = "P10102";
		BuyerVO buyer = dao.selectBuyer(prodId);
		log.info("buyer : {}",buyer);
	}

}
