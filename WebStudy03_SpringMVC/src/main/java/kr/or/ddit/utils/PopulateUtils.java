package kr.or.ddit.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.AbstractConverter;

import kr.or.ddit.vo.ProdVO;

public class PopulateUtils {
	public static <T> void populate(T bean, Map<String, ? extends Object> parameterMap) {
		AbstractConverter localDateConverter = new AbstractConverter() {
			
			@Override
			protected Class<?> getDefaultType() {
				return Temporal.class;
			}
			
			@Override
			protected <T> T convertToType(Class<T> type, Object value) throws Throwable {
				if(value==null || value.toString().isEmpty())
					return null;
				else {
					String paramValue = value.toString();
//					return (T) LocalDate.parse(paramValue);
//					return (T) LocalDateTime.parse(paramValue);
					return (T) type.getDeclaredMethod("parse", CharSequence.class)
										.invoke(null, paramValue);
				}
			}
		};
		
		ConvertUtils.register(localDateConverter, LocalDate.class);
		ConvertUtils.register(localDateConverter, LocalDateTime.class);

		try {
			BeanUtils.populate(bean, parameterMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}















