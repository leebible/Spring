package kr.or.ddit.case10.conf;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan( basePackages = "kr.or.ddit.case5", 
	excludeFilters = {@Filter( classes = Controller.class )})
public class RootContext {
	@Bean
	public Properties propsBak(@Value("classpath:kr/or/ddit/MemberData.properties") Resource cpRes) throws IOException { //value..파라미터에 쓸수 있음
		Properties props = new Properties();
		props.load(cpRes.getInputStream()); //예외를 던지면 Spring Container로 던져짐. 내부에서 예외로 전환하거나 복구하는 형식으로 작동함.
		return props;
	}
	
	@Bean
	public PropertiesFactoryBean props(@Value("classpath:kr/or/ddit/MemberData.properties") Resource cpRes) { 
		PropertiesFactoryBean props = new PropertiesFactoryBean();
		props.setLocation(cpRes);
		return props;
	}
}
