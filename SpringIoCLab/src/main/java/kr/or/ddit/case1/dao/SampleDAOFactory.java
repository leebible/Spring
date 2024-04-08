package kr.or.ddit.case1.dao;

public class SampleDAOFactory {
	public static SampleDAO getSampleDAO() { //팩토리객체생성하지 않아도 쓸수있께 static으로!(무슨뜻?)
		return new SampleDAOImpl_Oracle();
	}
}
