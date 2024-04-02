package kr.or.ddit.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomSqlSessionFacotryBuilder {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		String resource = "kr/or/ddit/mybatis/Configuration.xml";
		try(
			Reader reader = Resources.getResourceAsReader(resource);
		){
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		}catch(IOException e) {
			throw new UncheckedIOException(e);
			
		}
	}//생성자역할 static코드블럭. method Area의 static area에 저장. 맨처음에 클래스가 메모리에 로딩될때 딱 한번 실행
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
