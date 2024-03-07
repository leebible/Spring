package kr.or.ddit.person.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import kr.or.ddit.vo.PersonVO;

public class PersonDAOImpl implements PersonDAO {
	private Properties props;

	
	public PersonDAOImpl() {
		super();
		props = new Properties();
		
		try(
			InputStream is = this.getClass().getResourceAsStream("/kr/or/ddit/MemberData.properties");
		){
			props.load(is);
		}catch (IOException e) {
			throw new UncheckedIOException(e); //CheckedIO를 UncheckedIO로 바꿔주는 메소드
		}
	}

	
	private PersonVO rawToObject(String id, String rawData) { //데이터 맵핑 작업
		String[] tokens = rawData.split("\\|");
		return new PersonVO(id, tokens[0], tokens[1], tokens[2], tokens[3]);
		
	}
	
	@Override
	public List<PersonVO> selectPersonList(){
		List<PersonVO> people = new ArrayList<>();
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			Object key = (Object) keys.nextElement();
			Object value = props.get(key);
			PersonVO person = rawToObject(key.toString(), value.toString());
			people.add(person);
		}
		return people;
	}
	
	@Override
	public PersonVO selectPerson(String id){
		String property = props.getProperty(id);
//		if(property!=null) {
//			return rawToObject(id,property);
//		}else {
//			return null;
//		}
		
		//자바1.8에서 새로추가된 문법 써보기.if대신 쓸수있는 문법.
		return Optional.ofNullable(property).map((p)->rawToObject(id,p)).orElse(null); //한줄이면 {}이랑 return 생략 가능
		
	}
}
