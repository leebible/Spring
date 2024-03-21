package kr.or.ddit.servlet08;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.exception.ResponseStatusException;

@WebServlet("/bts")
public class BtsControllerServlet extends HttpServlet {
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {//라이프사이클 콜백을 통해 한번 실행되는 코드를 집어 넣겠다는 뜻!
		super.init(config);
		application = getServletContext();
		Map<String, String[]> btsMap = new LinkedHashMap<>();
		btsMap.put("B001", new String[] {"뷔","bts/bui"});
		btsMap.put("B002", new String[] {"제이홉","bts/jhop"});
		btsMap.put("B003", new String[] {"지민","bts/jimin"});
		btsMap.put("B004", new String[] {"진","bts/jin"});
		btsMap.put("B005", new String[] {"정국","bts/jungkuk"});
		btsMap.put("B006", new String[] {"RM","bts/rm"});
		btsMap.put("B007", new String[] {"슈가","bts/suga"});
		application.setAttribute("btsMap",btsMap);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/bts/btsForm_el.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> btsMap = (Map) application.getAttribute("btsMap");
	
		//1.decoding(언어설정)
		req.setCharacterEncoding("UTF-8");
		
		//선생님 답
//		String member = req.getParameter("member");
//		int status=200;
//		if(StringUtils.isBlank(member)) {
//			status=400;
//		}else if(!btsMap.containsKey(member)) {
//			status=404;
//		}
//		
//		if(status==200) {
//			String[] btsData = btsMap.get(member);
//			String path = btsData[1];
//		}
		
		
		//2.member라는 parameter를 통해 key가 넘어옴.bts멤버의 컨텐츠를 제공해야함.
		
		try {
			
			
			//3. 검증1 혹여나 안넘어온다면? 상태코드 400 넘기기 
			String member = Optional.ofNullable(req.getParameter("member"))
					.filter(mb->!mb.isEmpty())
					.orElseThrow(()->new ResponseStatusException(400, "필수 파라미터 누락"));
		
		//4. 검증2 B010 값이 넘어온다면? 상태코드 404 넘기기 ( 예전에 만든 custom exception 이용하기
			if(!btsMap.containsKey(member)) {
				throw new ResponseStatusException(400,String.format("%s 멤버는 없음",member));
			}
			 
			String mName=null;
			for(Entry<String, String[]> entry : btsMap.entrySet()) {
				if(entry.getKey().equals(member)) {
					mName = entry.getValue()[1];
				}
			}
			
		
			
			
			//5. 컨텐츠 확보하기. 그전에 데이터 필요함. 데이터는 map에 들어있음. map 안에 entry .. string..배열..context 파일의 위치가 들어ㅣㅇㅆ음 그걸 이용해 서비스가 되야함.
			String content = String.format("/WEB-INF/views/%s.jsp",mName);
			req.setAttribute("content", content);
			req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
			
			
		}catch(ResponseStatusException e) {
			resp.sendError(e.getStatus(), e.getMessage());
		}
	}
		
		//서비스가 되려면 공통레이아웃이 동작을해야함. base.jsp가 갖고 있음. 
		//마지막 이동위치느 base.jsp. base로 가기전에 content라는 속성으로? 어떤 ~를 쓰겠다는걸 전달해야함.
}
