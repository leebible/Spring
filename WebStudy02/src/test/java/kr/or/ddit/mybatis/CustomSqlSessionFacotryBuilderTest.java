package kr.or.ddit.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

class CustomSqlSessionFacotryBuilderTest {

	@Test
	void testGetSqlSessionFactory() {
		SqlSessionFactory factory =  CustomSqlSessionFacotryBuilder.getSqlSessionFactory();
		System.out.println(factory);
		try(
				SqlSession session = factory.openSession(); //한 메소드 안에서만 지역코드로 사용한다.
		){
			System.out.println(session);
		}
	}

}
