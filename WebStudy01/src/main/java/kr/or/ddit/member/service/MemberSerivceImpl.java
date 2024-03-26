package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.servlet10.dao.PropertyDAO;
import kr.or.ddit.servlet10.dao.PropertyDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberSerivceImpl implements MemberService {
	private MemberDAO dao = new MemberDAOImpl();
	/*
	 * public MemberSerivceImpl() { } private static MemberSerivceImpl service;
	 * public static MemberSerivceImpl getInstance() { if (service == null) {
	 * service = new MemberSerivceImpl(); // 오직 1개의 객체만 생성 } return service; }
	 */

	@Override
	public ServiceResult createMember(MemberVO member) {
		return null;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public MemberVO retrieveMember(String memId) throws PkNotFoundException {
		MemberVO member = dao.selectMember(memId);
		if(member==null)
			throw new PkNotFoundException(500);
		return member;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
