package kr.or.ddit.case5;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case5.person.controller.PersonController;

public class Case5Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
					new GenericXmlApplicationContext("");
		PersonController controller;
		controller.personListToResponse();
	}
}
