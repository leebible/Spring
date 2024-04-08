package kr.or.ddit.case4;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case4.bts.service.BtsService;
import kr.or.ddit.vo.BtsVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class Case4Playground { //controller의 역할 가정
	private BtsService service;
	//주입을 받으려면 주입방식이 있어야함
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case4/conf/Case4-Context.xml");//generic : xml위치가 언제든지 바뀔수있음
		
		Case4Playground controller = context.getBean("case4Playground", Case4Playground.class);
		List<BtsVO> btsList = controller.service.readBtsList();
		log.info("btsList : {}", btsList);
				
	}
	
}
