package kr.or.ddit.servlet05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/06/case1Req.do")
public class Case1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//name : p2, value : 23
		String ptrn = "name: %s, value :%s\n";
		//sugar syntax : 최대한 코드를 줄이고 가독성을 높이는 문법 (ex.람다함수)
		req.getParameterMap().forEach((k,v)->System.out.printf(ptrn, k, Arrays.toString(v)));
		 //javascript 배열 꺼낼때 쓰는 foreach
		String accept = req.getHeader("accept");
		String contentType=null;
		String content = null;
		if(accept.contains("json")) {
			contentType = "application/json;charset=UTF-8";
			content = "{\"result\":\"처리 성공\"}";
		}else {
			contentType= "text/html;charset=UTF-8";
			content = "<html><body><h4>처리성공</h4></body></html>";
		}
		resp.setContentType(contentType); 
		
		
		/* resp.getOutputStream(contentType); */
		try (
			PrintWriter out = resp.getWriter();
		){ 
			out.print(content);
		}
		
	}
}
