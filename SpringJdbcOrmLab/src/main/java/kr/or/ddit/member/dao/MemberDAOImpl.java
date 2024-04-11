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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired //주입받기
	private SqlSessionFactory factory;
	
	@Autowired
	private SqlSession sqlSession; //이미 안에서 오픈된상태로 들어온다.
	
	@Override
	public int insertMember(MemberVO member) {
//				int cnt = sqlsession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember",member);
				int rowcnt = sqlSession.getMapper(MemberDAO.class).insertMember(member);
				if(rowcnt>0) sqlSession.commit();
				return rowcnt;
		}

	@Override
	public List<MemberVO> selectMemberList() {
//			return sqlsession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
//			return generateProxy(sqlsession).selectMemberList();
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList();
	}

	@Override
	public MemberVO selectMember(String memId) {
//			return generateProxy(sqlSession).selectMember(memId);
			return sqlSession.getMapper(MemberDAO.class).selectMember(memId);
	}
		

	@Override
	public int updateMember(MemberVO member) {
//				int cnt = sqlsession.update("kr.or.ddit.member.dao.MemberDAO.update",member);
				int rowcnt = sqlSession.getMapper(MemberDAO.class).updateMember(member);
				if(rowcnt>0) sqlSession.commit();
				return rowcnt;
		}

	@Override
	public int deleteMember(String memId) {
//				int cnt = sqlsession.update("kr.or.ddit.member.dao.MemberDAO.delete",memId);
				int cnt = sqlSession.getMapper(MemberDAO.class).deleteMember(memId);
				if(cnt>0) sqlSession.commit();
				return cnt;
		}


	@Override
	public MemberVO selectMemberForAuth(String memId) {
			return sqlSession.getMapper(MemberDAO.class).selectMemberForAuth(memId);
	}

}


















