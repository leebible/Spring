package kr.or.ddit.case6;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case6Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new GenericXmlApplicationContext(
				"classpath:kr/or/ddit/case6/conf/Case6-Context.xml");
		context.registerShutdownHook();
		
		CollectionDIOuter outer1 = context.getBean("outer1",CollectionDIOuter.class);
		log.info("outer1:{}", outer1);
		CollectionDIOuter outer2 = context.getBean("outer2",CollectionDIOuter.class);
		log.info("outer2:{}", outer1);
	}
}
