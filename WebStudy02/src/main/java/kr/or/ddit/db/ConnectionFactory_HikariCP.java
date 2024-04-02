package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



/**
 * Factory Object[method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도 운영하는 구조
 */
public class ConnectionFactory_HikariCP {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	private static String driverClassName;
	
	static{ //객체가 생성되기전이라 this를 사용할 수 없음 
		try (
		InputStream is =  ConnectionFactory_HikariCP.class.getResourceAsStream("./Dbinfo.properties"); //폴더가 같기때문에 상대경로로 접근 가능
		){
			Properties props = new Properties();
			props.load(is);
			HikariConfig config = new HikariConfig();
			driverClassName = props.getProperty("driverClassName");
			
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			
			config.setDriverClassName(driverClassName);
			config.setJdbcUrl(url);
			config.setUsername(user);
			config.setPassword(password);
			//여기까지가 필수 속성
			
			config.setAutoCommit(true); //기본값이라 쓰진않아도 되지만 mybatis때 보기 위해 일부러 놓은 코드
			config.setMaximumPoolSize(5); //최대 5개까지 pool을 이용하겠다
			config.setMinimumIdle(3); //최대한 3개는 놀고 있을수 있다. 최초에 만드는 커넥션 개수를 의미.
			config.setConnectionTimeout(2000); //커넥션이 없을때 최대 기다릴수 있는 시간. 2초가 지났는데 반납할 conn이 없다면 SQL Exception 발생
			config.setConnectionTestQuery("SELECT SYSDATE FROM DUAL");
			//속성 설정 완료. 이제 datasoruce 만들기
			
			dataSource = new HikariDataSource(config);
			
			//pooling정책을 정하는것
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}  //constant pool에 로딩됨
	}//{}코드블럭 = 생성자와 역할이 똑같음 static이 붙으면 딱 한번 실행되는 영역.
	public static Connection getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		return conn;
	}

}
