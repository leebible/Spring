package kr.or.ddit.case5.person.dao;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PersonDAOImpl implements PersonDAO {
	@javax.annotation.Resource(name="props")
	private final Properties props;
	
	@Value("file:D:/00.medias/another_day.txt")
	private Resource fsRes;

	// 연습용
	public void setFsRes(Resource fsRes) {
		this.fsRes = fsRes;
	}
	
	@PostConstruct
	public void init() {
// 모든 주입(dependency Injection)이 다끝난 이후에 동작
// init 메소드 만들기
//		try(
//			InputStream is = cpRes.getInputStream();
//				//주입조건 1. 프로퍼티 존재, 2. 주입..?
//		){
//			props.load(is);
//			log.info("주입된 리소스: {}", cpRes);
			log.info("주입된 리소스: {}", fsRes);
//		}catch (IOException e) {
//			throw new UncheckedIOException(e); //CheckedIO를 UncheckedIO로 바꿔주는 메소드
//		}
	}

	private PersonVO rawToObject(String id, String rawData) {
		String[] tokens = rawData.toString().split("\\|");
		return new PersonVO(id.toString(), tokens[0], tokens[1], tokens[2], tokens[3]);
	}

	@Override
	public List<PersonVO> selectPersonList() {
		List<PersonVO> people = new ArrayList<PersonVO>();
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
	public PersonVO selectPerson(String id) {
		String property = props.getProperty(id);
//	      if(property!=null) {
//	         return rawToObject(id, property);
//	      }else {
//	         return null;
//	      }
		return Optional.ofNullable(property).map((p) -> rawToObject(id, p)).orElse(null);
	}

}