package kr.or.ddit.case09;

@FunctionalInterface //함수형 인터페이스 : 인터페이스와 인터페이스안에있는 메소드와 1:1관계일때. 추상메소드가 1개만 있어야함
//장점 : 람다식 사용 가능
 public interface BiOperandOperator {
	public long operate(long left, long right);
}
