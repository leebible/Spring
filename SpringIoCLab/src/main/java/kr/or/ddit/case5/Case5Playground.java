package kr.or.ddit.case5;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case5.person.controller.PersonController;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case5Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new GenericXmlApplicationContext(
				"classpath:kr/or/ddit/case8/conf/Person-Context.xml");// 내부에서 resource loader 동작
		context.registerShutdownHook(); // 종료시점에 컨테이너가 사용하고 있는 자원을 정리해줌(CPU, 메모리공간 등 사용자원)

		PersonController controller = context.getBean("personController",PersonController.class);
		log.info("controller : {}", controller);
		
		List<PersonVO> list = controller.personListToResponse();
		log.info("list:{}", list);
	}
}
