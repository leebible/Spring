package kr.or.ddit.login.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.login.BadCredentialException;
import kr.or.ddit.login.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AuthenticateServiceTest extends AbstractRootContextTest{
	
	@Autowired
	AuthenticateService service;

	@Test
	void testAuthenticateUserNotFound() {
		final MemberVO inputData = new MemberVO();
		inputData.setMemId("sdfasdfsadf");
		assertThrows(UserNotFoundException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				service.authenticate(inputData);
			}
		});
	}
	
	@Test
	void testAuthenticateBadCredential() {
		final MemberVO inputData = new MemberVO();
		inputData.setMemId("b001");
		inputData.setMemPass("asdfasd");
		assertThrows(BadCredentialException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				service.authenticate(inputData);
			}
		});
	}
	
	@Test
	void testAuthenticate() {
		final MemberVO inputData = new MemberVO();
		inputData.setMemId("b001");
		inputData.setMemPass("1004");
		assertNotNull(service.authenticate(inputData));
	}

}
















