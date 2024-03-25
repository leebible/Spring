package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.vo.MemberVO;

class MemberDAOTest {
	MemberDAO dao = new MemberDAOImpl();
	
	
	@Test
	void testInsertMember() {
		MemberVO member = new MemberVO();
		assertThrows(PersistenceException.class, ()->dao.insertMember(member)); //익명함수로 구현체를 만든것
		member.setMemId("a002");
		member.setMemPass("java");
		member.setMemName("테스터");
		member.setMemZip("00000");
		member.setMemAdd1("대전 오류");
		member.setMemAdd2("대덕인재개발원");
		member.setMemMail("aa@naver.com");
		member.setMemBir("2024-01-01");
		int rowcnt = dao.insertMember(member);
		assertEquals(1, rowcnt);
		
		
	}

	@Test
	void testSelectMemberList() {
		List<MemberVO> memberList = dao.selectMemberList();
		assertNotNull(memberList);
		assertNotEquals(0, memberList.size());
		System.out.println(memberList);
		
	}
	
	
	@Test
	void testSelectMember() {
		String memId="a001";
		MemberVO member = dao.selectMember(memId);
		assertNotNull(member);
		System.out.println(member);
		memId="asdfasdf' OR '1'='1";
		assertNull(dao.selectMember(memId));
		
		
	}

}
