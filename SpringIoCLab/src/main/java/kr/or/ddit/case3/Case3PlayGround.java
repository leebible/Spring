package kr.or.ddit.case3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case1.service.SampleService;
import kr.or.ddit.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;

/**
 * Spring container(Bean container, DI container) 사용단계
 *	1. Spring IoC container  모듈 의존성 추가 : Spring-context(core,beans,el)
 *	2. Spring bean configuration file 작성 : bean metadata 파일(객체의 부가적인 정보)
 *		1) 사용할 객체를 bean으로 등록 : bean(class-등록된 객체 타입, id-등록된 객체 식별자) // Bean Container
 *		2) 등록된 bean 간의 의존관계를 형성(의존성 주입 구조)
 *			- constructor injection(required) : constructor-arg, c prefix (name space) 
 *			- setter injection(optional) : property, p prefix (name space)
 *			주입될 대상에 따라 : value(일반 값), ref(객체 참조형) 분리하여 주입.
 *	3. entrypoint에서 컨테이너 객체 생성
 *		ApplicationContext -> ConfigurableApplicationContext -> 컨테이너의 특성에 따라 구현체 결정. //컨테이너들의 실체객체 
 *	4. 컨테이너로부터 필요한 객체 주입 : getBean (bean 검색조건-class, id 을 줘야함)
 *	
 * 스프링 컨테이너의 빈관리 정책
 * 1. singleton : 등록된 빈을 대상으로 싱글턴 인스턴스를 운영함., scope 속성으로 변경 가능
 * 		- singleton : 기본값(한개의 빈으로 하나의 인스턴스 운영)
 * 		- prototype : 주입시마다 새로운 인스턴스를 생성하고 운영 
 * 		- request / session : 웹 어플리케이션에서 한정적으로 사용하는 값으로 인스턴스를 request나 session 단위로 생성하고 운영.
 * 2. 컨테이너가 초기화될때 등록된 모든 빈의 인스턴스를 일시에 생성함. lazy-init
 * 		- true : 주입시점까지 객체의 생성이 미뤄짐
 * 		- false : 컨테이너가 초기화될때 미리 생성함.
 * 		- default : 상위 컨테이너나 beans 의 기본 설정을 따라감.
 * 3. 주입을 하지 않고, 생성 순서만 제어할때 : depends-on
 * 4. 컨테이너는 내부의 생명주기를 관리하는 객체의 생명주기 이벤트에 따라 callback을 호출하는 구조를 가짐.
 * 		init-method, destroy-method  속성으로 callback 지정.
 * 		**** init-method로 지정된 초기화(init) 메소드는 객체가 생성되고, 모든 주입이 완료된 후 마지막에 호출됨.
 */

@Slf4j
public class Case3PlayGround {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context =
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case3/conf/Case3-Context.xml");
		context.registerShutdownHook(); // 종료되어야할때 자신이 스스로 종료. (활성 스레드가 더이상 남아있지 않을때)
//		SampleService service1 = context.getBean("service1", SampleService.class);
//		SampleVO t003 = service1.readSample("T003");
		SampleService service2 = context.getBean("service2",SampleService.class);
//		SampleService service3 = context.getBean("service2",SampleService.class);
//		log.info("t003: {}", t003);
//		log.info("service1 과 service2 동일객체? : {}", service1 == service2 );
//		log.info("service2 과 service3 동일객체? : {}", service2 == service3 );
//		
//		Date now1 = context.getBean(Date.class);
//		log.info("now1 : {}", now1);
//		LocalDateTime ldt1 = (LocalDateTime) context.getBean("ldtNow");
//		log.info("ldt1 : {}", ldt1);
//		
//		
//		Thread.sleep(3000);
//		Date now2 = context.getBean(Date.class);
//		log.info("now2 : {}", now2);
//		LocalDateTime ldt2 = (LocalDateTime) context.getBean("ldtNow");
//		log.info("ldt2 : {}", ldt2);
//		
//		LocalDateTime.now();
		context.close(); //눈으로 destroy 확인가능
	}
}
