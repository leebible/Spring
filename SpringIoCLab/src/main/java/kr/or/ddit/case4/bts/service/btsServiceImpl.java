package kr.or.ddit.case4.bts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.case4.bts.dao.BtsDAO;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.BtsVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class btsServiceImpl implements BtsService {
	private final BtsDAO dao;
	
	
	@Override
	public BtsVO readBts(String code) throws PkNotFoundException {
		 BtsVO bts = dao.selectBts(code);
		 if(bts==null) {
			 throw new PkNotFoundException(404);
		 }
		 dao.incrementHit(code);
		 return bts;
	}

	@Override
	public List<BtsVO> readBtsList() {
		return dao.selectBtsList();
		
	}

}
