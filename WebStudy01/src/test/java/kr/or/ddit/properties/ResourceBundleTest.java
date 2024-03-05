package kr.or.ddit.properties;

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.junit.jupiter.api.Test;


public class ResourceBundleTest {
	
	@Test
	void test() {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.Messages",Locale.ENGLISH);
		Set<String> keySet = bundle.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()){
			String code = (String) it.next();
			String message = bundle.getString(code);
			System.out.printf("%s : %s\n", code, message);
		}
	}
}
