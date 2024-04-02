package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;


/**
 * Factory Object[method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도 운영하는 구조
 */
public class ConnectionFactory_JDBC_Ver3 {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	private static PooledConnection pc;
	
	static{ //객체가 생성되기전이라 this를 사용할 수 없음 
		try (
		InputStream is =  ConnectionFactory_JDBC_Ver3.class.getResourceAsStream("./Dbinfo.properties"); //폴더가 같기때문에 상대경로로 접근 가능
		){
			Properties props = new Properties();
			props.load(is);
			OracleConnectionPoolDataSource ocpds = new OracleConnectionPoolDataSource();
			dataSource = ocpds;
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			ocpds.setURL(url);
			ocpds.setUser(user);
			ocpds.setPassword(password);
			
			pc = ocpds.getPooledConnection(); //일정개수의 커넥션이 안에 미리 만들어져있는것
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}  //constant pool에 로딩됨
	}//{}코드블럭 = 생성자와 역할이 똑같음 static이 붙으면 딱 한번 실행되는 영역.
	public static Connection getConnection() throws SQLException {
		Connection conn = pc.getConnection();
		return conn;
	}

}
