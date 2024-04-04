package kr.or.ddit.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ValidatorTest { //public을 빼는 이유가 머라구?
	static Validator validator;
	
	@BeforeAll
	static void setUpBeforeClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	
	@Test
	void testMemberVO() { //테스트케이스에선 파라미터를 받지 않는다.
		MemberVO target = new MemberVO();
//		target.setMemId("a001");
//		target.setMemPass("12");
//		target.setMemName("이름");
//		target.setMemZip("12345");
//		target.setMemAdd1("12345");
//		target.setMemAdd2("12345");
//		target.setMemMail("sdf@naver.com");
//		target.setMemRegno1("123456");
//		target.setMemRegno2("1234567");
		Set<ConstraintViolation<MemberVO>> violations = validator.validate(target, InsertGroup.class, UpdateGroup.class, DeleteGroup.class); //T:무엇이든 올수 있음 / ...:가변파라미터 (안넘겨도됨!). default group이넘겨지고 있었음
		for(ConstraintViolation<MemberVO> single : violations) {
			String propName = single.getPropertyPath().toString();
			String message = single.getMessage();
			log.info("{}; {}",propName, message);
		}
		boolean valid = violations.isEmpty();
		log.info("검증통과여부 : {}",valid);		
		log.info("검증에 통과하지 못한 프로퍼티 개수 : {}", violations.size());
	}
}
