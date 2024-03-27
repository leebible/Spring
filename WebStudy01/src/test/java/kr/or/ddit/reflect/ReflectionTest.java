package kr.or.ddit.reflect;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class ReflectionTest {

	@Test
	void test() {
//		member.setMemId("a001");
//		member[paramName] = paramValue; // javascript에선 가능.
		Class instanceType = member.getClass(); //모든정보를 class가 가지고 있음
		Field[] fields = instanceType.getDeclaredFields(); //전역변수 = 프로퍼티 = 필드
		for(Field fld : fields) {
			if(paramName.equals(fld.getName())) {
					try {
						PropertyDescriptor pd = new PropertyDescriptor(paramValue, instanceType); //pd가 정보를 캡슐화에서 가지고 있음. 
						pd.getWriteMethod().invoke(member, paramValue);
						Object propValue = pd.getReadMethod().invoke(member); //reflect는 명확한게 없어서 구체적인 타입을 사용하지 않고 object 이용
						System.out.printf("%s : %s\n", pd.getName(), propValue);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					//propertyDescriptor은 예외를 가지고 있음
				break;
			}
		}
	}

}
