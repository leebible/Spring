package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodDetail.do")
public class ProdDetailControllerServlet extends HttpServlet{
	ProdService service = new ProdServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodId = (String) req.getParameter("what");
		if(StringUtils.isBlank(prodId)) {
			resp.sendError(400);
			return;
		}
		ProdVO prod = service.retrieveProd(prodId);
		req.setAttribute("prod", prod);
		
		String viewName = "/WEB-INF/views/prod/prodDetail.jsp";
		if (viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath()); // prefix 이 규칙은 나중에 Spring에서 그대로
																					// 사용됨!!!!
			resp.sendRedirect(location);
		}else if(viewName.startsWith("forward:")) {
			String path = viewName.substring("forward:".length());
			req.getRequestDispatcher(path).forward(req, resp);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
		
		
	}
}
