package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.ProdVO;

public interface ProdService {
	/**
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult createProd(ProdVO prod);
	
	public List<ProdVO> retrieveProdList();
	
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException; //프라이머리키로 조회했을때 조회하지 않으면 500 상태코드 결정

	/**
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult modifyProd(ProdVO prod);
	
}
