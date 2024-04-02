package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodList.do")
public class ProdListControllerServlet extends HttpServlet{
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdService service = new ProdServiceImpl();
		List<ProdVO> prodList = service.retrieveProdList();
		//scope
		req.setAttribute("prodList", prodList);
		
		//view
		String accept = req.getHeader("accept");
		
		//flow Control
		req.getRequestDispatcher("/WEB-INF/views/prod/prodList.jsp").forward(req, resp);
	}
}
