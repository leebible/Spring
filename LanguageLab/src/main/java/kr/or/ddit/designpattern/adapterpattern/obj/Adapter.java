package kr.or.ddit.designpattern.adapterpattern.obj;

public class Adapter implements Target {
	private Adaptee adaptee; //has관계
	
	
	public Adapter(Adaptee adaptee) { //기본생성자가 사라짐
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.specificRequest();
	}
}
