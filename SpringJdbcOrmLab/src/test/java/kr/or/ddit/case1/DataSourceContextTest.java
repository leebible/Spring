package kr.or.ddit.case1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "classpath:kr/or/ddit/case1/conf/*-context.xml")
class DataSourceContextTest {
	@Autowired //주입받는방법(autowired or resource)
	Properties dbInfo;
	
	@Autowired
	DataSource dataSource;
	
	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate; //전역변수는 자동주입이 불가능
	
	@Test
	void test() {
		log.info("dbInfo :{}", dbInfo);
	}
	
	@Test
	void test2() {
		log.info("dataSource :{}", dataSource);
	}
	
	@Test
	void test3() throws SQLException {
		log.info("connection :{}", dataSource.getConnection());
	}
	@Test
	void test4() {
		log.info("connection :{}", jdbcTemplate);
	}
	
	

}
