package member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.Test;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
class MemberDAOTest {
	MemberDAO dao = new MemberDAOImpl();
	
	
	@Test
	void testInsertMember() {
		MemberVO member = new MemberVO();
		assertThrows(PersistenceException.class, ()->dao.insertMember(member)); //익명함수로 구현체를 만든것
		member.setMemId("a242");
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
		String memId="a001";
		MemberVO member = dao.selectMember(memId);
		assertNotNull(member);
		System.out.println(member);
		memId="asdfasdf' OR '1'='1";
		assertNull(dao.selectMember(memId));
	}
	
	@Test
	void testUpdateMember() {
		MemberVO member = new MemberVO();
		member.setMemPass("수정22");
		member.setMemName("수정수정");
		member.setMemRegno1("123455");
		member.setMemRegno2("12345");
		member.setMemBir("1995-02-28");
		member.setMemZip("135");
		member.setMemAdd1("135");
		member.setMemAdd2("135");
		member.setMemHometel("135");
		member.setMemComtel("135");
		member.setMemHp("135");
		member.setMemMail("135");
		member.setMemJob("ㅇㅇㅇ");
		member.setMemLike("ㅇㅇㅇ");
		member.setMemMemorial("ㅇㅇㅇ");
		member.setMemMemorialday("2024-01-01");
		member.setMemId("a242");
		
		int rowcnt = dao.updateMember(member);
		System.out.println(member);
		assertEquals(1, rowcnt);
	}
	
	
	
	
	@Test
	void testDeleteMember() {
		String memId = "a2324";
		int rowcnt = dao.deleteMember(memId);
		assertEquals(1, rowcnt);
	}
	
	

}
