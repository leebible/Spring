package kr.or.ddit.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login/loginProcess.do")
public class LoginProcessController{
   private final AuthenticateService service;
   
   @PostMapping
   public String loginProcess(HttpServletRequest req,
         @RequestParam String memId,
         @RequestParam String memPass) {
      HttpSession session = req.getSession(true);
      if(session.isNew()) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "로그인을 하려면 로그인 폼이 먼저 최초의 요청으로 전송되었어야 함");
      }
         String viewName = null;
//         4. 인증 여부 판단
         try {
            MemberVO inputData = new MemberVO();
            inputData.setMemId(memId);
            inputData.setMemPass(memPass);
            MemberVO authMember = service.authenticate(inputData);
//            인증된 사용자임을 증명하는 상태정보 생성 및 유지
            session.setAttribute("authMember", authMember);
//            - 성공 : 웰컴 페이지로 이동 - redirect
            viewName = "redirect:/index.do";
         }catch (AuthenticateException e) {
//            - 실패 : 로그인 페이지로 이동 - forward
            session.setAttribute("message", e.getMessage()); // flash
//            req.getRequestDispatcher("/login/loginForm.jsp").forward(req, resp);
            viewName = "redirect:/login/loginForm.jsp";
         }
         return viewName;
   }
}














