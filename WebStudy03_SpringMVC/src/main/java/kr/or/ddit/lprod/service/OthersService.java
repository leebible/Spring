package kr.or.ddit.lprod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

@Service
public interface OthersService {
	public List<LprodVO> retrieveLprodList();
	public List<BuyerVO> retrieveBuyerList();
}
