package kr.or.ddit.member.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.ConnectionFactory_HikariCP;
import kr.or.ddit.mybatis.CustomSqlSessionFacotryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionFactory factory = CustomSqlSessionFacotryBuilder.getSqlSessionFactory();
	private MemberDAO generateProxy(SqlSession sqlSession) {
		return (MemberDAO) Proxy.newProxyInstance(MemberDAO.class.getClassLoader(), new Class[] {MemberDAO.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				return sqlsession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
				String namespace = method.getDeclaringClass().getName(); // qualified name('kr.or.ddit.member.dao.MemberDAO')
				String id = method.getName();
				String statement = namespace + "." + id;
				Object argument = null;
				
				if(args!=null && args.length>0) {
					argument = args[0];
				}
				if(method.getReturnType().equals(List.class)) {
					return sqlSession.selectList(statement, argument);
				}else {
					return sqlSession.selectOne(statement, argument );
				}
			}
		});
	}
	
	
	@Override
	public int insertMember(MemberVO member) {
		try (
				SqlSession sqlSession = factory.openSession();
			){
//				int cnt = sqlsession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember",member);
				int cnt = sqlSession.getMapper(MemberDAO.class).insertMember(member);
				if(cnt>0) sqlSession.commit();
				return cnt;
			}
		}

	@Override
	public List<MemberVO> selectMemberList() {
		try (
			SqlSession sqlSession = factory.openSession();
		){
//			return sqlsession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
//			return generateProxy(sqlsession).selectMemberList();
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList();
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
//			return generateProxy(sqlSession).selectMember(memId);
			return sqlSession.getMapper(MemberDAO.class).selectMember(memId);
		}
	}
		

	@Override
	public int updateMember(MemberVO member) {
		try (
				SqlSession SqlSession = factory.openSession();
			){
//				int cnt = sqlsession.update("kr.or.ddit.member.dao.MemberDAO.update",member);
				int rowcnt = SqlSession.getMapper(MemberDAO.class).updateMember(member);
				if(rowcnt>0) SqlSession.commit();
				return rowcnt;
			}
		}

	@Override
	public int deleteMember(String memId) {
		try (
				SqlSession sqlSession = factory.openSession();
			){
//				int cnt = sqlsession.update("kr.or.ddit.member.dao.MemberDAO.delete",memId);
				int cnt = sqlSession.getMapper(MemberDAO.class).deleteMember(memId);
				if(cnt>0) sqlSession.commit();
				return cnt;
			}
		}


	@Override
	public MemberVO selectMemberForAuth(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.getMapper(MemberDAO.class).selectMemberForAuth(memId);
		}
	}

}


















