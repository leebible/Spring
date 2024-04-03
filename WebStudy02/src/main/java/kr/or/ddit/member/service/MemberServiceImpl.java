package kr.or.ddit.member.service;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.login.BadCredentialException;
import kr.or.ddit.login.service.AuthenticateSerivce;
import kr.or.ddit.login.service.AuthenticateSerivceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = new MemberDAOImpl();
	private AuthenticateSerivce authService = new AuthenticateSerivceImpl();
	
	private void encryptMember(MemberVO member) { //call by reference 방식
		String plain = member.getMemPass();
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encoded = encoder.encode(plain);
		member.setMemPass(encoded);
	}
	/*
	 * public MemberSerivceImpl() { } private static MemberSerivceImpl service;
	 * public static MemberSerivceImpl getInstance() { if (service == null) {
	 * service = new MemberSerivceImpl(); // 오직 1개의 객체만 생성 } return service; }
	 */
	
	
	
	
	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if (dao.selectMember(member.getMemId())== null) {
			encryptMember(member);
			int rowcnt = dao.insertMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
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
		try {
			authService.authenticate(member);
			return dao.updateMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (BadCredentialException e) {
			return ServiceResult.INVALIDPASSWORD;
		}
		
//		아래코드와 위코드의 차이점 : 응집력의 차이
//		MemberVO saved = retrieveMember(member.getMemId());
//		ServiceResult result = null;
//		if(saved.getMemPass().equals(member.getMemPass())) {
//			return dao.updateMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
//		}else {
//			result = ServiceResult.INVALIDPASSWORD;
//		}
//		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) throws PkNotFoundException {
		try {
			authService.authenticate(inputData);
			return dao.deleteMember(inputData.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (BadCredentialException e) {
			return ServiceResult.INVALIDPASSWORD;
		}

//		아래코드와 위코드의 차이점 : 응집력의 차이
//		MemberVO saved = retrieveMember(inputData.getMemId());
//		ServiceResult result = null;
//		if(saved.getMemPass().equals(inputData.getMemPass())) {
//			return dao.deleteMember(inputData.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
//		}else {
//			result = ServiceResult.INVALIDPASSWORD;
//		}
//		return result;
	}

}
