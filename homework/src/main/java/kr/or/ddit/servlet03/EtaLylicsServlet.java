package kr.or.ddit.servlet03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자로부터 /eta 요청을 받고, - 매핑주소있어야함
 * 컨텐츠 폴더에 있는 eta_utf8.txt 파일에 있는 가사를 컨텐츠로 서비스. -해당 서블릿이 중간자역할 해줘야함. 
 * 읽고 내보내는 작업. 컨텐츠의 mimetype변경
 * @author PC-21
 *
 */

@WebServlet("/eta")
public class EtaLylicsServlet extends HttpServlet {
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File readFile = new File("D:/00.medias/ETA_UTF8.txt");
		
		String mime = getServletContext().getMimeType(readFile.getName());
		resp.setContentType(String.format("%s;charset=UTF-8",mime));
		
		try(
				FileInputStream fis = new FileInputStream(readFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				OutputStream os = resp.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(os);
		){
			int readByte = -1;
			while((readByte = bis.read())!=-1) { //-1을 EOS혹은 EOF문자라고 한다!
				bos.write(readByte);
			}
			bos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
