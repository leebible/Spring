package kr.or.ddit.servlet01;

import java.io.IOException;  
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/now.html")
public class DynamicServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date(); //1.data
		String info = now.toString(); //2.information(필요한 data를 가공한것)
		String content = "<html><body>"+info+"</body></html>"; //3.html(클라이언트에 맞는 언어-환경(웹, 모바일 등)에따라 다름) content
		resp.getWriter().print(content);
		//content (information을 컨텐츠화 시킨것-information을 사용자가 이해할 수 있는 메세지로 바꾸는것)
		//data(일반적으로 DB에 저장되어있음, 보통 DAO를 통해 가져옴) -> information(service라는 중간자를 통해 가져온 정보) -> content
		
		//위 전체 방식은 model 1 방식
	}
}
