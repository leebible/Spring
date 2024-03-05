package kr.or.ddit.properties;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.jupiter.api.Test;

import kr.or.ddit.servlet01.DescriptionServlet;
import kr.or.ddit.vo.PersonVO;

class PropertiesTest {
	
	@Test
	void testProptiesHandling() throws IOException {
		Properties props = new Properties();
		try(
			InputStream is = DescriptionServlet.class.getResourceAsStream("/kr/or/ddit/MemberData.properties");
		){
			props.load(is);
			Set<Object> keySet = props.keySet();
//			list : index를 가진 순차집합
//			set : 중복을 허용하지 않는 집합
//			map : key/value 형태의 엔트리를 가진 집합
//			for(Object key : keySet) {
//				Object value = props.get(key);
//				System.out.printf("%s = %s\n", key, value);
//			}
			
//			for(Entry<Object, Object> entry  : props.entrySet()) {
//				System.out.printf("%s = %s\n", entry.getKey(), entry.getValue());
//			}
			
			//collection view : 실제 집합 객체에 대한 접근 방법을 정의하고 있는 객체.
			
			//raw데이터를 객체로 매핑하는작업
			Enumeration<Object> keys = props.keys();
			while (keys.hasMoreElements()) {
				Object key = (Object) keys.nextElement();
				Object value = props.get(key);
				String[] tokens = value.toString().split("\\|");
				PersonVO person = new PersonVO(key.toString(), tokens[0], tokens[1], tokens[2], tokens[3]);
				System.out.println(person);
//				System.out.printf("name : %s\ngender : %s\nage : %s\naddress : %s\nid : %s\n",
//					tokens[0], tokens[1], tokens[2], tokens[3], key
//				);
				
			}
		}
		
		
	}
	
	@Test
	void testProperties() throws IOException { //1.(예외)회피정책. 회피를 떠안는 대상 (junit)
		Properties props = new Properties();
		System.out.printf("properties size : %d\n", props.size());
		String realPath = DescriptionServlet.class.getResource("/kr/or/ddit/MemberData.properties").getFile();
		File writeFile = new File(realPath);
		try(
				InputStream is = DescriptionServlet.class.getResourceAsStream("/kr/or/ddit/MemberData.properties");
//				FileOutputStream fos = new FileOutputStream(writeFile);
//		DescriptionServlet.class.getResourceAsStream("../MemberData.properties");//위와 같은 의
		){
			props.load(is);
//			props.clear();
//			props.save(fos, "clear");
			System.out.printf("properties size : %d\n", props.size());
		}
		
	}
	//예외  : 회피, ?, 복구

	@Test
	void test1() {
		System.out.println("출력");
	}
	
	@Test
	void test2() {
		System.out.println("출력");
	}

}
