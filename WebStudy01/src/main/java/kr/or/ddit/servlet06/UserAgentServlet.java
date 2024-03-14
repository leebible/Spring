package kr.or.ddit.servlet06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.BrowserInfo;
//단일책임의원칙에 결합도는 낮추고 응집도는 높이는 3가지 방법을 알아봄
@WebServlet("/07/userAgent.do")
public class UserAgentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String userAgent = req.getHeader("user-agent").toUpperCase();
		
		String browserName = "기타";
		//두번째 방법(데이터와 로직을 분리)
//		Map<String, String> browserInfo = new LinkedHashMap<String, String>();//순서유지
//		browserInfo.put("EDG", "엣지"); //바뀌지않는데이터 : 상수
//		browserInfo.put("WHALE", "웨일");
//		browserInfo.put("CHROME", "크롬");
//		browserInfo.put("SAFARI", "사파리");
//		browserInfo.put("OTHER", "기타");//상수가 모이면 열거형 상수

		//		Map으로 꺼내는 방법 (두번째 방법)
//		for(Entry<String, String> entry : browserInfo.entrySet()) {
//			if(userAgent.contains(entry.getKey())) {
//				browserName = entry.getValue();
//				break;
//			}
//		}
//		
		
//		enum안으로 넣기 (3-1방법)
//		for(BrowserInfo single : infos) {
//			if(userAgent.contains(single.name())){
//				browserName = single.getBrowserName();
//				break;
//			}
//		} 
//		BrowserInfo[] infos =  BrowserInfo.values();
//		BrowserInfo finded = BrowserInfo.findBrowser(userAgent);
//		browserName = finded.getBrowserName();
		
		//enum 안에서 해결하고 이 한줄로 표기하기(3-2방법)
		browserName = BrowserInfo.findBrowserName(userAgent);

		
		
//		조건문에 순서가 정해져있어야함 (첫번째방법)
//		if(userAgent.contains("EDG")) browserName = "엣지";
//		else if(userAgent.contains("WHALE")) browserName ="웨일";
//		else if(userAgent.contains("CHROME")) browserName ="크롬";
//		else if(userAgent.contains("SAFARI")) browserName = "사파리";
//		else browserName = "기타";
		String content = String.format("<html><body><h4>당신의 브라우저는 %s 입니다.</h4></body></html>",browserName);
		
		String contentType= "text/html;charset=UTF-8";
		resp.setContentType(contentType); 
		try (
			PrintWriter out = resp.getWriter();
		){ 
			out.print(content);
		}
		
		
		
	}
}
