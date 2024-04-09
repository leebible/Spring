package kr.or.ddit.case1.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class SampleDAOImpl_MariaDB implements SampleDAO {
	private Map<String, SampleVO> mariaDB;
	{
		mariaDB = new LinkedHashMap<>(); //2조 프로젝트 관리
		mariaDB.put("T001",SampleVO.builder()
								.id("T001") //메소드 체이닝 구조
								.name("정성윤_MariaDB") //메소드 체이닝 구조
								.role("PL")//메소드 체이닝 구조
								.build()); 
		mariaDB.put("T002",SampleVO.builder()
								.id("T002") 
								.name("장민우_MariaDB") 
								.role("TA")
								.build());
		mariaDB.put("T003",SampleVO.builder()
								.id("T003") 
								.name("신의정_MariaDB") 
								.role("UA")
								.build());
		mariaDB.put("T004",SampleVO.builder()
								.id("T004") 
								.name("박승준_MariaDB") 
								.role("AA")
								.build());
		
	}//코드블럭이니 생성자 역할
	
	
	public void inita() {
		log.info("lifecycle callback init 호출");
		
	}
	
	private void dstroya() {
		log.info("lifecycle callback destroy 호출");
		
	}
	

	public SampleDAOImpl_MariaDB() {
		super();
		log.info("{} 객체 생성", this.getClass().getSimpleName());
	}

	@Override
	public List<SampleVO> selectSampleList() {
		return new ArrayList<SampleVO>(mariaDB.values()); //data mapper
	}

	@Override
	public SampleVO selectSample(String id) {
		return mariaDB.get(id);
	}

}
