package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOTest {
	ProdDAO dao= new ProdDAOImpl();

	@Test
	void testInsertProd() {
		ProdVO prod = new ProdVO();
		prod.setProdId(null);
		prod.setProdName("test2");
		prod.setProdLgu("P101");
		prod.setProdBuyer("P20102");
		prod.setProdCost(123L);
		prod.setProdPrice(123L);
		prod.setProdSale(123L);
		prod.setProdOutline("test2");
		prod.setProdDetail("123");
		prod.setProdImg("test2");
		prod.setProdTotalstock(123L);
		prod.setProdInsdate(LocalDate.now());
		prod.setProdProperstock(123L);
		prod.setProdSize("test2");
		prod.setProdColor("test2");
		prod.setProdDelivery("test2");
		prod.setProdUnit("test2");
		prod.setProdQtyin(123L);
		prod.setProdQtysale(123L);
		prod.setProdMileage(123L);
		int rowcnt = dao.insertProd(prod);
		assertEquals(1, rowcnt);
		log.info("prodId : {}", prod.getProdId());
	}

	private void setProdImg(String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void testSelectProdList() {
		List<ProdVO> prodList = dao.selectProdList();
		log.info("list : {}", prodList);
	}

	@Test
	void testSelectProd() {
		String prodId="P101000006";
		ProdVO prod = dao.selectProd(prodId);
		log.info("prod : {}", prod);
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

}
