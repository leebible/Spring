package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.vo.BuyerVO;

public interface BuyerDAO {
	/**
	 * 거래처아이디, 거래처명, 분류코드(분류명), 소재지, 담당자명, 전화번호
	 * @return
	 */
	public List<BuyerVO> selectBuyerList();
	/**
	 * buyer 단건 조회
	 * @param buyerId
	 * @return
	 */
	public BuyerVO selectBuyer(String buyerId);
//	insert
//	update

}
