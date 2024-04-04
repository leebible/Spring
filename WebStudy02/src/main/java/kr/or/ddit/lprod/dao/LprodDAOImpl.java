package kr.or.ddit.lprod.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFacotryBuilder;
import kr.or.ddit.vo.LprodVO;

public class LprodDAOImpl implements LprodDAO {
	private SqlSessionFactory factory = CustomSqlSessionFacotryBuilder.getSqlSessionFactory();

	@Override
	public List<LprodVO> selectLprodList() {
		try (
				SqlSession sqlSession = factory.openSession();
			){
				return sqlSession.getMapper(LprodDAO.class).selectLprodList();
			}
	}
}
