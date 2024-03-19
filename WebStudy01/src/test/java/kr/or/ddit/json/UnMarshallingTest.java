package kr.or.ddit.json;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.or.ddit.json.MarshallingTest.TestVO;

class UnMarshallingTest {
	
	ObjectMapper mapper = new ObjectMapper();	
	
	@Test
	void test1() throws JsonMappingException, JsonProcessingException {
		String json = "[1,2,3]";
		int[] array = mapper.readValue(json, int[].class); //타입을 넘겨야함. json을 int[].class타입으로 만들어줘.
		System.out.println(array.length);
	}
	
	@Test
	void test2() throws JsonMappingException, JsonProcessingException {
		String json = "{\"key1\":34,\"key2\":false,\"key5\":{\"innerKey\":\"INNERVALUE\"},\"key3\":\"stringvalue\",\"key4\":[1,2,3]}";
		Map<String, Object> target = mapper.readValue(json, Map.class); //Map.class는 인터페이스. HashMap.class를 타입으로 놔야함(구현체)
		System.out.println(target);
	}
	
	@Test
	void test3() throws JsonMappingException, JsonProcessingException {
		String json = "{\"prop1\":\"한글값\",\"prop2\":23.4}";
		TestVO target = mapper.readValue(json, TestVO.class);
		System.out.println(target);
	}
	
	@Test
	void test4() throws JsonMappingException, JsonProcessingException {
		String xml = "<TestVO><prop1>한글값</prop1><prop2>23.4</prop2></TestVO>";
		ObjectMapper mapper = new XmlMapper();
		TestVO target = mapper.readValue(xml, TestVO.class);
		System.out.println(target);
	}
}
