package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.ProdVO;

public interface ProdService {
	public List<ProdVO> retrieveProdList();
	
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException; //프라이머리키로 조회했을때 조회하지 않으면 500 상태코드 결정
	
	
}
