package kr.or.ddit.case9.conf;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case9.obj.Bibitan;
import kr.or.ddit.case9.obj.Gun;
import kr.or.ddit.case9.obj.Hunter;
import kr.or.ddit.case9.obj.HuntingDog;
import kr.or.ddit.case9.obj.RifleGun;

//컨테이너가 밑에 코드 전부 실행함
@Lazy
@Configuration
@ComponentScan("kr.or.ddit.case9.obj")
public class Case9Context { //Beans의 역할
//	@Bean("dog") //value는 SingleValueAnotation 등록 가능
//	public HuntingDog dog() { //리턴타입이 Bean의 클래스가 됨 -> Bean의 ID등록 
//		return new HuntingDog(); //그동안 xml의 bean등록과정이 class에서 해결
//	}
//
//	@Bean //SingleValueAnotation을 생략하면 메소드 이름이 아이디가 됨!
//	@Scope("prototype")
//	public Gun rifleGun() {
//		return new RifleGun();
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Gun bibitan() {
//		return new Bibitan();
//	}
//	
//	@Bean
//	public Hunter hunter1(@Autowired Gun rifleGun, HuntingDog dog) { //Gun을 주입받아서 사용하기. HuntingDog는 Spring Container한테 받기..
//		Hunter hunter = new Hunter(rifleGun); //등록되어있는 gun을 injection
//		hunter.setDog(dog);
//		return hunter;
//	}
//	
//	@Bean
//	public Hunter hunter2(@Autowired Gun rifleGun, HuntingDog dog) { //Gun을 주입받아서 사용하기. HuntingDog는 Spring Container한테 받기..
//		Hunter hunter = new Hunter(rifleGun); //등록되어있는 gun을 injection
//		hunter.setDog(dog);
//		return hunter;
//	}
}
