package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * Factory Object[method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도 운영하는 구조
 */
public class ConnectionFactory_JDBC_Ver1 {
	private static String url;
	private static String user;
	private static String password;
	static{ //객체가 생성되기전이라 this를 사용할 수 없음 
		try (
		InputStream is =  ConnectionFactory_JDBC_Ver1.class.getResourceAsStream("./Dbinfo.properties"); //폴더가 같기때문에 상대경로로 접근 가능
		){
			Properties props = new Properties();
			props.load(is);
			Class.forName(props.getProperty("driverClassName")); 
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}  //constant pool에 로딩됨
	}//{}코드블럭 = 생성자와 역할이 똑같음 static이 붙으면 딱 한번 실행되는 영역.
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password); //거의 interface인데 몇 안되는 클래스중 하나임! , 아주 옛날 방식!!!!
		return conn;
	}

}
