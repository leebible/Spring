package kr.or.ddit.servlet10;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet10.service.PropertyService;
import kr.or.ddit.servlet10.service.PropertyServiceImpl;

@WebServlet("/15/jdbcDesc.do")
public class JdbcDescServlet extends HttpServlet {
	private PropertyService service = new PropertyServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> paramMap = new HashMap<>();
		service.readProperties(paramMap);
		
		for(Entry<String, Object> entry : paramMap.entrySet()) {
			req.setAttribute(entry.getKey(), entry.getValue());
		}
		
		String accept = req.getHeader("accept");
		String viewName = null;
		if(accept.contains("json")) { //list객체를 json으로 마샬링 하는 작업
			viewName = "/jsonView.do";
		}else {
			viewName = "/WEB-INF/views/15/jdbcDesc.jsp";
		}
		req.getRequestDispatcher(viewName).forward(req, resp);
		
		}
	}
