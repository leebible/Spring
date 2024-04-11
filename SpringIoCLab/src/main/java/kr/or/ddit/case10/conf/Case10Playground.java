package kr.or.ddit.case10.conf;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case5.person.controller.PersonController;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case10Playground {
public static void main(String[] args) {
	ConfigurableApplicationContext parent
		= new AnnotationConfigApplicationContext(RootContext.class);
	ConfigurableApplicationContext child =
			new ClassPathXmlApplicationContext(
					new String[]{"kr/or/ddit/case10/conf/child-context.xml"}, parent);
	
	PersonController controller = child.getBean(PersonController.class);
	List<PersonVO> personList = controller.personListToResponse();
	log.info("controller list : {}", personList);
}
}
