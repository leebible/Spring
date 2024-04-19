package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD)
 *
 */
@Mapper
public interface ProdDAO {
	public int insertProd(ProdVO prod);
	/**
	 * 상품코드, 거래처코드, 분류코드, 상품명, 구매가, 판매가, 마일리지, 입고일자
	 * @param paging TODO
	 * @return
	 */
	public List<ProdVO> selectProdList(PaginationInfo paging);
	public int selectTotalRecord(PaginationInfo paging);
	public ProdVO selectProd(String prodId);
	public int updateProd(ProdVO prod);
}
