package kr.or.ddit.case9;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case9.conf.Case9Context;
import kr.or.ddit.case9.obj.Hunter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case9Playground {
	public static void main(String[] args) {
		//컨테이너 생성
		ConfigurableApplicationContext context
			= new AnnotationConfigApplicationContext(Case9Context.class);
		Hunter hunter = context.getBean(Hunter.class); //hunter로 주입받기
		log.info("hunter : {}", hunter);
		
//		Hunter hunter1 = context.getBean("hunter1",Hunter.class); //hunter로 주입받기
//		log.info("hunter1 : {}", hunter1);
		
//		Hunter hunter2 = context.getBean("hunter2",Hunter.class); //hunter로 주입받기
//		log.info("hunter2 : {}", hunter2);
		
	}
}
