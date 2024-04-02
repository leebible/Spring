package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFacotryBuilder;
import kr.or.ddit.vo.BuyerVO;

public class BuyerDAOImpl implements BuyerDAO {
	private SqlSessionFactory factory = CustomSqlSessionFacotryBuilder.getSqlSessionFactory();

	@Override
	public List<BuyerVO> selectBuyerList() {
		try (
				SqlSession sqlSession = factory.openSession();
			){
				return sqlSession.getMapper(BuyerDAO.class).selectBuyerList();
			}
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try (
				SqlSession sqlSession = factory.openSession();
			){
				return sqlSession.getMapper(BuyerDAO.class).selectBuyer(buyerId);
			}
	}
	

}
