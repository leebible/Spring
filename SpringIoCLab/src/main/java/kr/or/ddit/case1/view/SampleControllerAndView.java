package kr.or.ddit.case1.view;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case1.dao.SampleDAO;
import kr.or.ddit.case1.dao.SampleDAOImpl_Oracle;
import kr.or.ddit.case1.service.SampleService;
import kr.or.ddit.case1.service.SampleServiceImpl;
import kr.or.ddit.case1.service.SampleServiceImpl2;
import kr.or.ddit.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleControllerAndView { //전략의 주입자
	public static void main(String[] args) {
//		SampleDAO dao = new SampleDAOImpl_Oracle();
//		SampleService service = new SampleServiceImpl(dao);
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("/kr/or/ddit/case8/conf/AutoDI-Context.xml"); //클래스 패스 이전의 경로는 필요 없으니 제거
		
		SampleService service = context.getBean(SampleService.class);
		List<SampleVO> list = service.readSampleList();
		log.info("list : {}", list);
		SampleVO sample = service.readSample("T001");
		log.info("sample : {}", sample);
	}
}
