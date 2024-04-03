package kr.or.ddit.login.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import kr.or.ddit.login.BadCredentialException;
import kr.or.ddit.login.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;

class AuthenticateSerivceTest {
	AuthenticateSerivce service = new AuthenticateSerivceImpl();

	@Test
	void testAuthenticate() {
		final MemberVO inputData = new MemberVO(); //final 상수.저장공간. methodarea의 constant pool공간으로 감. 안사라짐 
		inputData.setMemId("sdfasdfasdf");
		assertThrows(UserNotFoundException.class, new Executable() {//행동을 표현하기 위한 익명함수 사용. java에는 익명함수X, 메소드만 존재할뿐. 이 익명함수를 이용해 익명객체를 생성할뿐!
			@Override
			public void execute() throws Throwable {
				service.authenticate(inputData);
			}
		});
	}
	
	@Test
	void testAuthenticateBaadCredential() {
		final MemberVO inputData = new MemberVO(); 
		inputData.setMemId("b001");
		inputData.setMemPass("asdffd");
		assertThrows(BadCredentialException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				service.authenticate(inputData);
			}
		});
	}
	
	
//	@Test
//	void testAuthenticate() {
//		final MemberVO member = new MemberVO();
//		member.setMemId("b001");
//		member.setMemId("1004");
//		assertNotNull(inputData);
//		
//	}
	
	
}
