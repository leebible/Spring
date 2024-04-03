package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService {
	private ProdDAO dao = new ProdDAOImpl();

	@Override
	public List<ProdVO> retrieveProdList() {
		return dao.selectProdList();
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException {
		ProdVO prod = dao.selectProd(prodId);
		if(prod==null) throw new PkNotFoundException(500);
		return prod;
	}

	@Override
	public ServiceResult createProd(ProdVO prod) {
		ServiceResult result = null;
		if(dao.insertProd(prod) > 1) result=ServiceResult.OK;
		else {
			result=ServiceResult.FAIL;
		}
		return result;
	}


	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return null;
	}
}
