package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/mypage")
public class MypageControllerServlet extends HttpServlet {
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.isNew()) { //최초의 요청이 아니기때문에 잘못된 요청
			resp.sendError(400);
			return;
		}
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		String viewName = null;
		if(authMember==null) { //redirect로 보내는 이유 : 잘못된 요청을 가지고 다시 돌아갈수 없으니까
			viewName = "redirect:/login/loginForm.jsp";
		}else {
			MemberVO member = service.retrieveMember(authMember.getMemId());
			req.setAttribute("member", member);
			viewName = "/WEB-INF/views/member/mypage.jsp";
		}

		if (viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(location);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
