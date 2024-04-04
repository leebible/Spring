package kr.or.ddit.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.AbstractConverter;

import kr.or.ddit.vo.ProdVO;

//메소드 시그니처가 T라는 것을 알려 주어야 한다.
public class PopulateUtils {
	public static <T> void populate(T bean, Map<String, ? extends Object> parameterMap) {
		//localDateTime 변환하기 위한 converter 내부 정의
		AbstractConverter localDateConverter = new AbstractConverter() { //추상화 클래스 객체를 생성하는 방법 : 1.상속받는 클래스 생성 2.익명객체
			@Override
			protected Class<?> getDefaultType() {
				return Temporal.class;
			} 
			
			@Override
			protected <T> T convertToType(Class<T> type, Object value) throws Throwable {
				//변환할 값이 없을때
				if(value==null || value.toString().isEmpty())
					return null;
				else {
					//req에 있는 데이터 변환
					String paramValue = value.toString();
//					return (T) LocalDate.parse(paramValue);
//					return (T) LocalDateTime.parse(paramValue); //static 메소드 (객체가 없어도 호출 가능)

					//static 메소드는 객체가 없어도 접근이 가능하기 때문에 null을 넣고 클래스에 접근한다.
					return (T) type.getDeclaredMethod("parse", CharSequence.class).invoke(null, paramValue);
				}
			}
		};
		
		//컨버터를 빈유틸즈에 등록
		ConvertUtils.register(localDateConverter, LocalDate.class);
		ConvertUtils.register(localDateConverter, LocalDateTime.class);
		
		//사용되는 프로퍼티들을 bean에 넣어주는 작업 -> key와 vo의 프로퍼티 이름이 같으면 bean으로 넣어준다.
		try {
			BeanUtils.populate(bean, parameterMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
//			String insdate = req.getParameter("prodInsdate");
//			LocalDate prodInsdate = LocalDate.parse(insdate);
//			prod.setProdInsdate(prodInsdate);
		} 
	}
}
