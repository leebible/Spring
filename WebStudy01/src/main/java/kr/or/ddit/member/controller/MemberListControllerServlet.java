package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


/**
 * C : /member/memberInsert.do(GET, POST)
 * R (GET)
 * 단건 : /member/memberDetail.do?who=a001
 * 다건 : /member/memberList.do
 * U : /member/memberUpdate.do (GET, POST)
 * D : /member/memberDelete.do (POST)
 * 
 */
@WebServlet("/member/memberList.do")
public class MemberListControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		List<MemberVO> mlist = service.retrieveMemberList();
		//scope
		req.setAttribute("mlist",mlist);
		//view
		String accept = req.getHeader("accept");
		String viewName="";
		if(accept.contains("json")) { //list객체를 json으로 마샬링 하는 작업
			viewName = "/jsonView.do";
		}else {
			viewName = "/WEB-INF/views/member/memberList.jsp";
		}
		//flow control
		req.getRequestDispatcher(viewName).forward(req, resp);
	}

}
