package kr.or.ddit.login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout.do")
public class LogoutControllerServlet extends HttpServlet {
	//1.request콜백을 doPost로 넣기 - JSP내에서 a태그X form을 만들어 hidden태그로 만들기
	//2.현재 사용자의 세션 즉시 만료. (로그아웃 상태로 바꿔 놓기)
	//3.웰컴 페이지로 이동 (flow control구조. 현재요청을 끊고 보내는 구조-redirect)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//현재 사용자의 세션 즉시 만료.
		//req.getSession(true); //true(생략되어있음) : 세션이 없으면 그즉시 세션을만들어라!. false가 들어있다면 세션이 없다면 null값을 반환해라.
		if(session.isNew()) {//true라면 세션이 이제 막 만들어졌다는 뜻.(최초요청).
			resp.sendError(400,"현재 요청이 최초의 요청일 수 없음.");
			return;
		}
		session.invalidate();
		String message = "로그아웃 성공";
		
		//session.setAttribute("message",message); //invalidate을 했기때문에 error
		//웰컴페이지로 이동
		message = URLEncoder.encode(message, "UTF-8"); //UTF-8 : 인코딩할때 사용할수 있는 문자 집합
//		resp.sendRedirect(req.getContextPath()+"/?message="+message); //PRG방식
		String viewName ="redirect:/?message="+message;
		
//		 * 6. view로 이동(flow control)
			if(viewName.startsWith("redirect:")) { 
				String location = viewName.replace("redirect:", req.getContextPath()); //prefix 이 규칙은 나중에 Spring에서 그대로 사용됨!!!!
				resp.sendRedirect(location);
			}else {
				req.getRequestDispatcher(viewName).forward(req, resp);
			}
			
		
	}
	
}
