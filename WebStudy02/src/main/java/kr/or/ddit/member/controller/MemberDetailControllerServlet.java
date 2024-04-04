package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDetail.do")
public class MemberDetailControllerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		String memId = req.getParameter("who");
		if(StringUtils.isBlank(memId)) {
			resp.sendError(400);
			return;
		}
		MemberVO member = service.retrieveMember(memId); //모델 받아옴
		//scope
		req.setAttribute("member", member);
		//view
		String viewName = "/jsonView.do";
		//flow control
		new ViewResolverComposite().resolveView(viewName, req, resp);
		
	}
}
