package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;;

@Slf4j
class ProdDAOTest extends AbstractRootContextTest{

	@Autowired
	ProdDAO dao;
	
	@Test
	void testInsertProd() {
//		PROD_NAME        NOT NULL VARCHAR2(40)  
//		PROD_LGU         NOT NULL CHAR(4)       
//		PROD_BUYER       NOT NULL CHAR(6)       
//		PROD_COST        NOT NULL NUMBER(10)    
//		PROD_PRICE       NOT NULL NUMBER(10)    
//		PROD_SALE        NOT NULL NUMBER(10)    
//		PROD_OUTLINE     NOT NULL VARCHAR2(100) 
//		PROD_IMG         NOT NULL VARCHAR2(40)  
//		PROD_TOTALSTOCK  NOT NULL NUMBER(10)    
//		PROD_PROPERSTOCK NOT NULL NUMBER(10)    
		ProdVO prod = dao.selectProd("P101000001");
		prod.setProdId(null);
		int rowcnt = dao.insertProd(prod);
		assertEquals(1, rowcnt);
		log.info("prodId : {}", prod.getProdId());
	}

	@Test
	void testSelectProdList() {
		List<ProdVO> prodList = dao.selectProdList();
		log.info("list : {}", prodList);
	}

	@Test
	void testSelectProd() {
		ProdVO prod = dao.selectProd("P101000001");
		log.info("prod : {}", prod);
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

}












