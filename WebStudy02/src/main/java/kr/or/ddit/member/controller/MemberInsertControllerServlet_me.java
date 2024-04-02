package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

//@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet_me extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//scope
		
		//view
		String accept = req.getHeader("accept");
		String viewName="";
		if(accept.contains("json")) { //list객체를 json으로 마샬링 하는 작업
			viewName = "/jsonView.do";
		}else {
			viewName = "/WEB-INF/views/member/memberForm.jsp";
		}
		//flow control
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		
		String memId = (String)req.getParameter("memId");
		String memPass = (String)req.getParameter("memPass");
		String memName = (String)req.getParameter("memName");
		String memRegno1 = (String)req.getParameter("memRegno1");
		String memRegno2 = (String)req.getParameter("memRegno2");
		String memBir = (String)req.getParameter("memBir");
		String memZip = (String)req.getParameter("memZip");
		String memAdd1 = (String)req.getParameter("memAdd1");
		String memAdd2 = (String)req.getParameter("memAdd2");
		String memHometel = (String)req.getParameter("memHometel");
		String memComtel = (String)req.getParameter("memComtel");
		String memHp = (String)req.getParameter("memHp");
		String memMail = (String)req.getParameter("memMail");
		String memJob = (String)req.getParameter("memJob");
		String memLike = (String)req.getParameter("memLike");
		String memMemorial = (String)req.getParameter("memMemorial");
		String memMemorialday = (String)req.getParameter("memMemorialday");
	    Long memMileage = Long.valueOf(req.getParameter("memMileage"));
		String memDelete = (String)req.getParameter("memDelete");
		
		MemberVO member = new MemberVO();
		member.setMemId(memId);
		member.setMemPass(memPass);
		member.setMemName(memName);
		member.setMemRegno1(memRegno1);
		member.setMemRegno2(memRegno2);
		member.setMemBir(memBir);
		member.setMemZip(memZip);
		member.setMemAdd1(memAdd1);
		member.setMemAdd2(memAdd2);
		member.setMemHometel(memHometel);
		member.setMemComtel(memComtel);
		member.setMemHp(memHp);
		member.setMemMail(memMail);
		member.setMemJob(memJob);
		member.setMemLike(memLike);
		member.setMemMemorial(memMemorial);
		member.setMemMemorialday(memMemorialday);
		member.setMemMileage(memMileage);
		
		MemberService service = new MemberServiceImpl();
		ServiceResult sr = service.createMember(member);
		System.out.println(sr);
		if (sr == ServiceResult.OK) {
			session.setAttribute("newMember", member); // 방금 가입한 회원의 상세 정보를 세션에 저장
			resp.sendRedirect(req.getContextPath() +  "/member/memberList.do?newMemberId="+ member.getMemId()); // 회원 리스트 페이지로 리디렉션
			
		}
		
		
		
		
		
	}

}
