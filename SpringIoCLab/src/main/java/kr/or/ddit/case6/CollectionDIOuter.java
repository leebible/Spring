package kr.or.ddit.case6;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import lombok.Data;


@Data
public class CollectionDIOuter {
	private Object[] array; //배열은 타입과 사이즈가 미리 고정되어있어야함, 배열은 생성자가 없다
	
	private List<String> list;
	
	private Set<Object> set;
	
	private Map<String, Object> map;
	
	private Properties props;
	
}
