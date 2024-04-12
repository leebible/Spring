package kr.or.ddit.login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.mvc.ViewResolverComposite;

@WebServlet("/login/logout.do")
public class LogoutControllerServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 현재 사용자의 세션 즉시 만료.
		HttpSession session = req.getSession();
		if(session.isNew()) {
			resp.sendError(400, "현재 요청이 최초의 요청일 수 없음.");
			return;
		}
		
		session.invalidate();
		String message = "로그아웃 성공.";
//		session.setAttribute("message", message);
		// 웰컴 페이지로 이동.
		message = URLEncoder.encode(message, "UTF-8");
		String viewName = "redirect:/?message="+message;
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
















