package kr.or.ddit.crypto;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PasswordEncoderTEst {
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //passwordencoder : 인코딩, 인크립팅 모두 가능

	@Test
	void test() {
		String plain = "java";
		String encoded = encoder.encode(plain); //byte배열 쪼개서 input, encrypted, base64해서 encoded해서 만들어주는 작업
		
		log.info("encoded :{}", encoded);
		
	}
	
	@Test
	void testMatches() {
		String savedPass = "{bcrypt}$2a$10$Er/hNvCRtvax0F0r9EpdFu0L9LD3tiEwD.IIC1x.RT/gdkTXKPUu."; //무작위 대입법에 안전
		String inputPass = "java2";
		log.info("인증 성공 여부 : {}", encoder.matches(inputPass, savedPass));
	}
}
