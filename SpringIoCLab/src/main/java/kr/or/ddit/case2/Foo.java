package kr.or.ddit.case2;

import org.springframework.stereotype.Component;

import kr.or.ddit.case1.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component("foo1")
@RequiredArgsConstructor
@ToString
public class Foo {
	private final Bar bar; //required
	private Baz baz; //optional
	private final SampleService service;
	
	
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
}
