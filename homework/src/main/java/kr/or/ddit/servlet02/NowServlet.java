package kr.or.ddit.servlet02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/now")
public class NowServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date();
		
		long millis = now.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일, HH:mm:ss");
		String dateText = format.format(now);
		resp.setContentType("text/plain;charset=UTF-8");
		resp.getWriter().print(dateText);
	}
}

//상속, 콜백, 재정의
//어노테이션안쓰면 web.xml
