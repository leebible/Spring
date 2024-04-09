package kr.or.ddit.case1.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("daoOracle")
public class SampleDAOImpl_Oracle implements SampleDAO {
	private Map<String, SampleVO> oracleDB;
	{
		oracleDB = new LinkedHashMap<>(); //2조 프로젝트 관리
		oracleDB.put("T001",SampleVO.builder()
								.id("T001") //메소드 체이닝 구조
								.name("정성윤_Oracle") //메소드 체이닝 구조
								.role("PL")//메소드 체이닝 구조
								.build()); 
		oracleDB.put("T002",SampleVO.builder()
								.id("T002") 
								.name("장민우_Oracle") 
								.role("TA")
								.build());
		oracleDB.put("T003",SampleVO.builder()
								.id("T003") 
								.name("신의정_Oracle") 
								.role("UA")
								.build());
		oracleDB.put("T004",SampleVO.builder()
								.id("T004") 
								.name("박승준_Oracle") 
								.role("AA")
								.build());
		
	}//코드블럭이니 생성자 역할
	public SampleDAOImpl_Oracle() {
		super();
		log.info("{} 객체 생성", this.getClass().getSimpleName());
	}
	@Override
	public List<SampleVO> selectSampleList() {
		return new ArrayList<SampleVO>(oracleDB.values()); //data mapper
	}

	@Override
	public SampleVO selectSample(String id) {
		return oracleDB.get(id);
	}

}
