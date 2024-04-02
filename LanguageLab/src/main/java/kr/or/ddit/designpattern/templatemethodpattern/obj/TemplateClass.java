package kr.or.ddit.designpattern.templatemethodpattern.obj;

public abstract class TemplateClass {
	
	// 반복되는 작업의 순서를 일정하게 제어하는 메소드 : template method
	public final void template() {//final : 재정의 할수 없다!
		stepOne();
		stepTwo();
		stepThree();
	}
	
	//실제 작업 단계를 담당하고 template method 의 제어를 "받는" 메소드 : hook method
	private void stepOne() {
		System.out.println("1단계 실행");
	}
	
	protected abstract void stepTwo(); //추상이라 바디 안갖고있음. private으로 설정 못함.(구체화를해야하니까)
	
	private void stepThree() {
		System.out.println("3단계 실행");
	}
	
	
	
}
