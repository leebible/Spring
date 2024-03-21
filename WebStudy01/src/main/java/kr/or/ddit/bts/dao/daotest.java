package kr.or.ddit.bts.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BtsVO;

class daotest {

	
	
	Map<String, String[]> btsMap = new LinkedHashMap<>();
	{
		btsMap.put("B001", new String[] {"뷔","bts/bui"});
		btsMap.put("B002", new String[] {"제이홉","bts/jhop"});
		btsMap.put("B003", new String[] {"지민","bts/jimin"});
		btsMap.put("B004", new String[] {"진","bts/jin"});
		btsMap.put("B005", new String[] {"정국","bts/jungkuk"});
		btsMap.put("B006", new String[] {"RM","bts/rm"});
		btsMap.put("B007", new String[] {"슈가","bts/suga"});
	}//코드블록 : 생성자와 역할이 똑같음
	
	
	@Test
	void selectBts() {
		BtsVO bvo = new BtsVO();
		String code = "B001";
		for(Entry<String, String[]> entry : btsMap.entrySet()) {
			if(entry.getKey().equals(code)) {
				bvo.setName(entry.getValue()[0]);
				bvo.setPath(entry.getValue()[1]);
				bvo.setCode(code);
				break;
			}else {
				bvo = null;
			}
		}
		System.out.println("selectBts:" + bvo);
	}
	
	@Test
	void selectBtsList() {
		List<BtsVO> btsList = new ArrayList<BtsVO>();
		
		String names[] = null;
			for(Entry<String,String[]> entry : btsMap.entrySet()) {
				BtsVO bvo = new BtsVO();
				bvo.setName(entry.getValue()[0]);
				bvo.setCode(entry.getKey());
				btsList.add(bvo);
			}
		
		System.out.println(btsList);
	}
	
	

}
