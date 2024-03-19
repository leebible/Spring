package kr.or.ddit.json;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 *	서로 다른 이기종 시스템간에 메시지를 교환할때 공통 메시지 표현 방식(xml/json)이 필요함.
 *	1. native data
 *	2. native data -> xml/json : marshalling + serialize(직렬화)
 *	3. deserialize(역직렬화) + unmarshalling -> xml/json -> native data
 *
 */
class MarshallingTest {
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void test() throws JsonProcessingException {
		int[] array = new int[] {1,2,3};
		String json = mapper.writeValueAsString(array); //checked exception. 회피할건지 전환할건지 선택해야함. 하지만 웬만한건 회피함.
		System.out.println(json);
	}
	
	@Test
	void test2() throws JsonProcessingException {
		Map<String,Object> target = new HashMap<String, Object>();
		target.put("key1", 34);
		target.put("key2", false);
		target.put("key3", "stringvalue");
		target.put("key4", new int[] {1,2,3});
		target.put("key5", Collections.singletonMap("innerKey", "INNERVALUE"));
		String json = mapper.writeValueAsString(target); //checked exception. 회피할건지 전환할건지 선택해야함. 하지만 웬만한건 회피함.
		System.out.println(json);
	}
	
	public static class TestVO implements Serializable{
		public TestVO() {
		}
		public TestVO(String prop1, double prop2) {
			super();
			this.prop1 = prop1;
			this.prop2 = prop2;
		}

		private String prop1;
		private double prop2;
		public String getProp1() {
			return prop1;
		}
		public void setProp1(String prop1) {
			this.prop1 = prop1;
		}
		public double getProp2() {
			return prop2;
		}
		public void setProp2(double prop2) {
			this.prop2 = prop2;
		}
		
		@Override
		public String toString() {
			return "TestVO [prop1=" + prop1 + ", prop2=" + prop2 + "]";
		}
	}
	
	@Test
	void test3() throws JsonProcessingException {
		TestVO target = new TestVO("한글값", 23.4d);
		String json = mapper.writeValueAsString(target); //checked exception. 회피할건지 전환할건지 선택해야함. 하지만 웬만한건 회피함.
		System.out.println(json);
	}
	
	@Test
	void test4() throws JsonProcessingException {
		TestVO target = new TestVO("한글값", 23.4d);
		ObjectMapper mapper = new XmlMapper();
		
		String xml = mapper.writeValueAsString(target);
		System.out.println(xml);
	}

}
