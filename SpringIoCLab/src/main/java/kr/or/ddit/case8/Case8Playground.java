package kr.or.ddit.case8;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case5.person.controller.PersonController;
import kr.or.ddit.case5.person.dao.PersonDAO;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case8Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext parent =
				new ClassPathXmlApplicationContext("kr/or/ddit/case8/conf/hierarchy/root-context.xml");
		ConfigurableApplicationContext child =
				new ClassPathXmlApplicationContext(
						new String[]{"kr/or/ddit/case8/conf/hierarchy/child-context.xml"}, parent);
		
		PersonController controller = child.getBean(PersonController.class);
		
		List<PersonVO> personList = controller.personListToResponse();
		log.info("controller list : {}", personList);
	}
}
