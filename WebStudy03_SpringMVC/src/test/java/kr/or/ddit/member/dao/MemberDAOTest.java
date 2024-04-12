package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberDAOTest extends AbstractRootContextTest{

	@Autowired
	MemberDAO dao;
	
	@Test
	void testInsertMember() {
		MemberVO member = new MemberVO();
		assertThrows(PersistenceException.class, ()->dao.insertMember(member));
		member.setMemId("a005");
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
		log.info("list : {}", memberList);
	}

	@Test
	void testSelectMember() {
		String memId = "c001";
		MemberVO member = dao.selectMember(memId);
		assertNotNull(member);
		
		log.info("cartList : {}", member.getCartList().size());
//		System.out.println(member);
//		memId = "asdasdfsadf' OR '1'='1";
//		assertNull( dao.selectMember(memId) );
	}

	@Test
	void testUpdateMember() {
		assertThrows(PersistenceException.class, ()->dao.updateMember(null));
		MemberVO member = new MemberVO();
		member.setMemId("342sdf");
		assertEquals(0, dao.updateMember(member));
		member.setMemId("a003");
		member.setMemPass("java");
		member.setMemName("테스터");
		member.setMemZip("00000");
		member.setMemAdd1("대전 오류");
		member.setMemAdd2("대덕인재개발원");
		member.setMemMail("aa@naver.com");
		member.setMemBir("2024-01-01");
		int rowcnt = dao.updateMember(member);
		assertEquals(1, rowcnt);
	}
	
	@Test
	void testDeleteMember() {
		assertEquals(1, dao.deleteMember("a003"));
		assertNotEquals(1, dao.deleteMember("aasdf"));
	}
}





















