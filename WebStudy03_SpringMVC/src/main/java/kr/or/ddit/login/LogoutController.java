package kr.or.ddit.login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;



@WebServlet("/login/logout.do")
@Controller
public class LogoutController{
   @RequestMapping("/login/logout.do")
   public String logout(HttpServletRequest req) throws UnsupportedEncodingException {
      // 현재 사용자의 세션 즉시 만료.
      HttpSession session = req.getSession();
      if(session.isNew()) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "현재 요청이 최초의 요청일 수 없음");
      }
      
      session.invalidate();
      String message = "로그아웃 성공.";
//      session.setAttribute("message", message);
      // 웰컴 페이지로 이동.
      message = URLEncoder.encode(message, "UTF-8");
      return "redirect:/?message="+message;
      
   }
}


















