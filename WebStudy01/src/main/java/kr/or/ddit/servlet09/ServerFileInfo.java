package kr.or.ddit.servlet09;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/case2/fileInfo")
public class ServerFileInfo extends HttpServlet{
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException { 
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Optional은 존재여부가 불확실할때 쓰는거고 확실할땐 if문 쓰면 됨!
		
//      1. div태그 접근
//      2. 우측영역의 파일태그를 클릭했을때 비동기 요청을 여기로 보냄 (path 파라미터로)
//      3. li태그에 숨어있는 id값(논리주소)로 물리주소로 변경 후 파일 크기 확인
//      4. 파일 크기를 json 데이터로 전달

        String path = req.getParameter("path");
        if(StringUtils.isBlank(path)) {
        	resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        	return;
        }
        String realPath = application.getRealPath(path);
        File file = new File(realPath);
        if(!file.exists() || file.isDirectory()) {
        	resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        	return;
        }
        
        long size = file.length(); //객체로 만들어줘야함. 방법1)VO생성 방법2)MAP생성 - 우리는 이미 SCOPE라는 MAP을 갖고있음!
        req.setAttribute("size",size);
        
        //req를 살려서 가야함, 책임을 질 필요 없음 : forward
        String viewName = "/jsonView.do";
        req.getRequestDispatcher(viewName).forward(req,resp);
	}


}
