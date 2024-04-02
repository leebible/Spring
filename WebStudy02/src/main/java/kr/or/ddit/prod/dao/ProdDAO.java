package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD)
 * 
 *
 */
public interface ProdDAO {
	/**
	 * 상품 입력
	 * @param prod
	 * @return 성공>1, 실패0
	 */
	public int insertProd(ProdVO prod);
	
	/**
	 * 상품코드, 거래처코드(거래처명), 분류코드(분류명), 상품명, 구매가, 판매가, 마일리지, 입고일
	 * 상품전체 조회, null체크X empty체크
	 * @return
	 */
	public List<ProdVO> selectProdList();
	
	/**
	 * prod/lprod/buyer join
	 * 상품 단건 조회. null데이터 반환되는데, null값이 반환될수 있다는걸 표시해야함 
	 * @param prod_id
	 * @return
	 */
	public ProdVO selectProd(String prodId);
	
	/**
	 * 상품 업데이트
	 * @param prod
	 * @return 성공>1, 실패0
	 */
	public int updateProd(ProdVO prod);
	
//	/** 상태컬럼이 없기때문에 표현할수 없음. 상품에서 상품을 삭제하면 매출이나 자식테이블관계에서 문제가 되기때문에..!
//	 * 상품 삭제
//	 * @param prodId
//	 * @return
//	 */
//	public int deleteProd(String prodId);
	
}
