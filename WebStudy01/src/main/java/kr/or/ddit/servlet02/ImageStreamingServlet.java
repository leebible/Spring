package kr.or.ddit.servlet02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image.do")
public class ImageStreamingServlet extends HttpServlet{
	private ServletContext application; //유일한 singleTon
	private String imageFolderPath; //ImageFormServlet_case4 여기선 imageFolder인데 여기선 변수명 겹쳐서!
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //제거 하면 안됨. 초기화 때문에!
		application = getServletContext();
		imageFolderPath = application.getInitParameter("imageFolder");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		File imageFolder = new File(imageFolderPath);
		String imageName = req.getParameter("name");
		if(imageName==null || imageName.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "이미지 파일명이 없음");
			return;
		}
		
		File imageFile = new File(imageFolder, imageName);
		if(!imageFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("%s 파일은 없음.", imageName));
			return;
		}
		String mime = application.getMimeType(imageFile.getName());
		if(mime==null || !mime.startsWith("image")) {
			resp.sendError(400, "정상적인 이미지 파일이 아님.");
			return;
		}
		
		Cookie imageCookie = new Cookie("imageCookie", URLEncoder.encode(imageName,"UTF-8"));
		imageCookie.setPath(req.getContextPath());
		imageCookie.setMaxAge(60*60*24*3);
		resp.addCookie(imageCookie);
		
		
		resp.setContentType(mime);
		resp.setContentLengthLong(imageFile.length());
		
		try(
				InputStream is = new FileInputStream(imageFile);
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = resp.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(os);
				//여기까지를 resource라고 한다.
		){
			int readByte = -1;
			while((readByte = bis.read())!=-1) {
				bos.write(readByte);
			}
		 }
		
		//리팩토링 과정
		
		//전송데이터 크기 1byte단위, 중간에 buffer를 사용(bufferedinputstream)
		//1바이트. 버퍼. 출력 bufferedoutputstream
		
		
	}
}
