package kr.or.ddit.servlet02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MIME text란?
 * 
 * peer와 peer 사이에 전송되는 content 다양한 형태가 존재하고,
 * content 전송시에는 반드시 해당 컨텐츠의 형태나 종류(형식)을 표현할 수 있는 메타데이터(header)를 전송함.
 * ex) Content-type : 컨텐츠 종류 표현 방식
 * 			MIME text 방식으로 표현.
 * 			main_type/sub_type;charset=UTF-8
 * 			ex) 전송 content : html -> text/html
 * 			ex) 전송 content : text -> text/plain
 * 			ex) 전송 content : json -> application/json;charset=UTF-8
 * 			ex) 전송 content : xml -> application/xml;charset=UTF-8
 * 			ex) 전송 content : image -> image/jpeg[gif];
 * 			ex) 전송 content : mp3 -> audio/mpeg
 */

@WebServlet(name = "mimeTextDesc", urlPatterns = "/mime", loadOnStartup=1
	, initParams = {@WebInitParam(name="p1", value="VALUE")}
) //web.xml에서도 가능한 작업
public class MimeTextDescServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException { //init 라이프사이클..콜백..
		super.init(config);
		System.out.printf("%s \n", config.getServletName());
		System.out.printf("p1: %s\n",config.getInitParameter(getInitParameter("p1")));
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.printf("service 메소드 실행, request method : %s\n", req.getMethod());
		super.service(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 실행");
//		String mime = "text/html;charset=UTF-8"; //현재 기본 set이 UTF-8이기 때문에!
		String mime = "text/plain;charset=UTF-8"; //현재 기본 set이 UTF-8이기 때문에!
		resp.setContentType(mime); //content meta data
		resp.setContentLength(6);
		String data = "데이터";
		StringBuffer content = new StringBuffer(); //객체는 heap메모리에 할당
		content.append("<html>");
		content.append("<body>");
		content.append(String.format("<h4>%s</h4>", data));
		content.append("</body>");
		content.append("</html>");
		PrintWriter out = resp.getWriter();
//		resp.getOutputStream();
		out.print(content);
		out.close();
		
//		String content = "<html>"; //Constant Pool에 저장
//		content += "</html>";
	}

}
