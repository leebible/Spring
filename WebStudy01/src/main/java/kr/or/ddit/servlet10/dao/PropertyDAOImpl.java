package kr.or.ddit.servlet10.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.utils.NamingUtils;

public class PropertyDAOImpl implements PropertyDAO {

	@Override
	public List<Map<String,Object>> selectProperties(Map<String, Object> paramMap){
		try(
				Connection conn = ConnectionFactory.getConnection();
				Statement stmt =  conn.createStatement();
			){
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION "); //Snake표기는 DB에서만 사용. JAVA에서는 Camel형식으로.
			sql.append("FROM DATABASE_PROPERTIES                          ");
			ResultSet rs = stmt.executeQuery(sql.toString()); //Set : 중복허용X, index X, iterator 필요. set과 똑같은 구조가지고 있음
			//객체화 하기 위해 VO 혹은 MAP으로 만들기
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			String[] headers = new String[count];
			String[] propsName = new String[count];
			
			paramMap.put("headers", headers);
			paramMap.put("propsName", propsName);
			for(int idx=1; idx<=count; idx++){ //oracle은 index가 1부터 시작
				headers[idx-1] = metaData.getColumnName(idx);
				propsName[idx-1] = NamingUtils.snakeToCamel(headers[idx-1]);
			}
			List<Map<String,Object>> resultList = new ArrayList<>();
			
			paramMap.put("resultList", resultList);
			while(rs.next()){
				//컬럼에 대한 정보를 동적으로 들고 올수 있어야함
				Map<String,Object> propsMap = new HashMap<>();
				resultList.add(propsMap);
				for(String columnName : headers){
					propsMap.put(NamingUtils.snakeToCamel(columnName),rs.getString(columnName));
				}
			}
			rs.close(); //try resource 안에 없는 구문이기때문에 이친구는 지울수 없음
			return resultList;
			}catch (SQLException e) { 
				throw new PersistenceException(e); //발생한 예외가 checked라서 unchecked로 바꾸기!
				//Mybatis 내부에는 PersistenceException 이 예외와 똑같은 예외를 이미 갖고 있음
			}
	}

}
