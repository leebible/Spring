package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope를 이용해 model 공유
 * 5. view 결정
 * 6. view로 이동(flow control)
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet extends HttpServlet{
	
	private MemberService service = new MemberServiceImpl();//의존관계
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName="/WEB-INF/views/member/memberForm.jsp";
		req.getRequestDispatcher(viewName).forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	 * 1. 요청 접수, 분석
		resp.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO(); // command Object (이 표현 잘기억해두기)
		req.setAttribute("member", member);
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		} 
//		for(Entry<String, String[]> entry : parameterMap.entrySet()) {
//			String paramName = entry.getKey();
//			String paramValue = entry.getValue()[0];
////			System.out.printf("%s : %s\n", paramName, paramValue);
//		}
		System.out.println(member);
//	 * 2. 검증
		Map<String, String> errors = new LinkedHashMap<>();//현재는 errors가 비어있지만
		req.setAttribute("errors", errors);
		boolean valid = validate(member, errors); //여기서는 errors에 담기게된다!@~!! return타입이 표현못하는걸 errors가 표현해줌 => call by reference 타입
		String viewName = null;
		if(errors.isEmpty()) {
//	 * 3. 로직 사용(model 확보)
			ServiceResult result = service.createMember(member);//커멘드 오브젝트?
			switch (result) {
			case PKDUPLICATED:
				req.setAttribute("message", "아이디 중복! 새로운 아이디를 입력하세요");
				viewName="/WEB-INF/views/member/memberForm.jsp";
				break;
			case FAIL:
				req.setAttribute("message", "서버 오류! 잠시 뒤 다시 가입하세요");
				viewName="/WEB-INF/views/member/memberForm.jsp";
				break;
			default: //성공했으면 커멘드 오브젝트는 필요가 없어짐. request를 없애고 가기. PRG패턴이 필요함
//				req.getSession().setAttribute("lastCreated",member);
//				viewName= "redirect:/member/memberList.do"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
				viewName= "redirect:/"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
				break;
			}
//	 * 4. scope를 이용해 model 공유
			
		}else {
			viewName="/WEB-INF/views/member/memberForm.jsp";
		}
//	 * 5. view 결정
//	 * 6. view로 이동(flow control)
		if(viewName.startsWith("redirect:")) { 
			String location = viewName.replace("redirect:", req.getContextPath()); //prefix 이 규칙은 나중에 Spring에서 그대로 사용됨!!!!
			resp.sendRedirect(location);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}

	private boolean validate(MemberVO member, Map<String, String> errors) {
		boolean valid = true;
		if (StringUtils.isBlank(member.getMemId())) {
			valid = false;
			errors.put("memId", "회원번호 누락");
		}
		if (StringUtils.isBlank(member.getMemPass())) {
			valid = false;
			errors.put("memPass", "암호 누락");
		}
		if (StringUtils.isBlank(member.getMemName())) {
			valid = false;
			errors.put("memName", "회원명 누락");
		}
		if (StringUtils.isBlank(member.getMemZip())) {
			valid = false;
			errors.put("memZip", "우편번호 누락");
		}
		if (StringUtils.isBlank(member.getMemAdd1())) {
			valid = false;
			errors.put("memAdd1", "기본주소 누락");
		}
		if (StringUtils.isBlank(member.getMemAdd2())) {
			valid = false;
			errors.put("memAdd2", "상세주소 누락");
		}
		if (StringUtils.isBlank(member.getMemMail())) {
			valid = false;
			errors.put("memMail", "메일주소 누락");
		}
		return valid;
	}
}
