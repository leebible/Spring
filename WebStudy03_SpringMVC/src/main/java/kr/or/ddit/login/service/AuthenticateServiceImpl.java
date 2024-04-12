package kr.or.ddit.login.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.login.BadCredentialException;
import kr.or.ddit.login.UserNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {
	private final MemberDAO dao;

	@Override
	public MemberVO authenticate(MemberVO inputData) throws AuthenticateException {
		MemberVO saved = dao.selectMemberForAuth(inputData.getMemId());
		if(saved==null)
			throw new UserNotFoundException(String.format("%s 사용자 없음.", inputData.getMemId()));
		if(saved.isMemDelete())
			throw new AuthenticateException("이미 탈퇴한 회원");
		String savedPass = saved.getMemPass();
		String inputPass = inputData.getMemPass();
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		if(encoder.matches(inputPass, savedPass)) {
			return saved;
		}else {
			throw new BadCredentialException("비밀번호 오류");
		}
	}

}
