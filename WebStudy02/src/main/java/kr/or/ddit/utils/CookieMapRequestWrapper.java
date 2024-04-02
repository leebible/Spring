package kr.or.ddit.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *  List<Object> dummyList = new ArrayList<>();
 *  int number = 34; //그냥 값으로 되있던 34지만
 *  dummyList.add(new Integer(number)); //number의 성질이 객체로 바뀌게됌. Wrapper클래스라고 함.
 */
public class CookieMapRequestWrapper {
	private HttpServletRequest adaptee;
	private Map<String, Cookie> cookieMap;
	
	public CookieMapRequestWrapper( HttpServletRequest adaptee) {
		super();
		this.adaptee = adaptee;
		cookieMap = new LinkedHashMap<>();
		Cookie[] cookies = adaptee.getCookies();
		if(cookies!=null) {
			for(Cookie single : cookies) {
				cookieMap.put(single.getName(), single);
			}
		}
	}
	
	public boolean hasCookie(String cookieName) {
		return cookieMap.containsKey(cookieName); //쿠키가 있다면 true
	}
	
	public Cookie getCookie(String cookieName) {
		return cookieMap.get(cookieName);
	}
	
	public String getCookieValue(String cookieName) {
		if(hasCookie(cookieName)) {
			Cookie finded = getCookie(cookieName);
			
			try {
				return URLDecoder.decode(finded.getValue(),"UTF-8");
			} catch (IOException e) {
				//$(".selector") //$는 사실 생성자. 원본객체의 형태를 넣어준것. 어떤 객체가 새로운 객체를 wrapping한다는것을 wrapping패턴..? 
				throw new UncheckedIOException(e);
			}
		}else {
			return null;
		}
		
	}
}
