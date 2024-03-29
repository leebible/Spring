package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	case1 : model1 + servlet spec
 *	case2 : template 구조 활용
 *	case3 : jsp 스펙 활용
 *	case4 : servlet + jsp --> model2
 *	case5 : 비동기 처리
 *
 */
//@WebServlet("/case2/imageForm.do")
@WebServlet("/case4/imageForm.do")
public class ImageFormServlet_case4 extends HttpServlet{
	private ServletContext application;
	private String imageFolder;


	//라이프사이클 콜백
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		imageFolder = application.getInitParameter("imageFolder");
	}

	
	//request콜백
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Cookie[] cookies = req.getCookies();
			String findedName = null;
			if(cookies!=null) {
				for(Cookie single: cookies) {
					if("imageCookie".equals(single.getName())) {
						findedName = URLDecoder.decode(single.getValue(),"UTF-8");
						break;
					}
				}
			}
			req.setAttribute("imageCookieValue", findedName);
			resp.setContentType("text/html;charset=UTF-8");
			
			File folder = new File(imageFolder);
			String[] fileList = folder.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) { //익명객체
					String mime = application.getMimeType(name);
					return mime!=null && mime.startsWith("image/");
				}
			});
			StringBuffer options = new StringBuffer("");
			String optPtrn = "\n<option>%s</option> ";
			for(String name :fileList) {
				options.append(String.format(optPtrn,name));
			}
			
			
			req.setAttribute("options", options);
			req.setAttribute("cPath", req.getContextPath());
			String viewName = "/WEB-INF/views/04/imageForm.jsp";
			req.getRequestDispatcher(viewName).forward(req, resp);
	}
}
