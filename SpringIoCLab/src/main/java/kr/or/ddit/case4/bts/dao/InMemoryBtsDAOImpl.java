package kr.or.ddit.case4.bts.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kr.or.ddit.vo.BtsVO;

public class InMemoryBtsDAOImpl implements BtsDAO {
	
	Map<String, Object[]> btsMap = new LinkedHashMap<>();
	{
		btsMap.put("B001", new Object[] {"뷔","bts/bui",100});
		btsMap.put("B002", new Object[] {"제이홉","bts/jhop",200});
		btsMap.put("B003", new Object[] {"지민","bts/jimin",300});
		btsMap.put("B004", new Object[] {"진","bts/jin",0});
		btsMap.put("B005", new Object[] {"정국","bts/jungkuk",120});
		btsMap.put("B006", new Object[] {"RM","bts/rm",30});
		btsMap.put("B007", new Object[] {"슈가","bts/suga",40});
	}//코드블록 : 생성자와 역할이 똑같음
	
	//1. 한사람의 멤버가 조회가 될때마다 조회수 증가시키기
	//2. 증가가 됐으면 조회수대로 정렬할수 있는 구조, 정렬된 결과를 옵션에 적용
	// 전체 구조는 바뀌면 안되고 한군데만 건드리면 됨. (business layer만-service)
	
	
	@Override
	public void incrementHit(String code) {
		BtsVO bts = selectBts(code);
		if(bts!=null) {
			int count = bts.getCount() + 1;
//			bts.setCount(count); //의미 없음
			btsMap.get(code)[2] = count;
		}
	}
	
	@Override
	public BtsVO selectBts(String code) {
		Object[] values = btsMap.get(code);
		BtsVO bvo = null;
			if(values!=null) {
				bvo = new BtsVO(code, (String) values[0], (String) values[1]);
				bvo.setCount((Integer)values[2]);
			}
		return bvo;
	}

	@Override
	public List<BtsVO> selectBtsList() {
		List<BtsVO> btsList = new ArrayList<BtsVO>();
		for(Entry<String, Object[]> entry : btsMap.entrySet()) {
			Object[] values = (Object[]) entry.getValue();
			BtsVO tmp = new BtsVO(entry.getKey(), values[0], values[1]);
			tmp.setCount((int)values[2]);
			btsList.add(tmp);
		}
		Collections.sort(btsList);// return타입이 void. 원래 객체를 정렬하겠다는 뜻
		return btsList;
	}
	
	
}
