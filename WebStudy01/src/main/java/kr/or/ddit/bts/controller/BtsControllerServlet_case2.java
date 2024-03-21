package kr.or.ddit.bts.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.bts.service.BtsService;
import kr.or.ddit.bts.service.btsServiceImpl;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.exception.ResponseStatusException;
import kr.or.ddit.vo.BtsVO;


@WebServlet("/case2/bts")
public class BtsControllerServlet_case2 extends HttpServlet{
	private BtsService service = new btsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BtsVO> btsList = service.readBtsList();
		req.setAttribute("btsList", btsList);
		String viewName="/WEB-INF/views/bts/btsForm_case2.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.decoding(언어설정)
		req.setCharacterEncoding("UTF-8");
		
		String member = req.getParameter("member");
		int status=200;
		if(StringUtils.isBlank(member)) {
			status=400;
		}
		
		try {
			BtsVO bts = service.readBts(member);
			String path = bts.getPath();
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			
			req.setAttribute("content", prefix + path + suffix);
			req.setAttribute("bts",bts);
		}catch (PkNotFoundException e) {
			status = e.getStatus();
		}
		
		if(status==200) {
			req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
		}else { 
			resp.sendError(status);
		}
		
	}
}
