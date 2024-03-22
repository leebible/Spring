package kr.or.ddit.servlet09;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/case2/serverFile")
public class ServerFileExplorer_case2 extends HttpServlet{
	private ServletContext application;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accept = req.getHeader("accept");
		String base = Optional.ofNullable(req.getParameter("base"))
				.filter((bp)->!bp.isEmpty())
				.orElse("/");
		String type = Optional.ofNullable(req.getParameter("type"))
				.filter((tp)->!tp.isEmpty())
				.orElse("folder");
		
		boolean folderFlag = "folder".equals(type);//타입이 폴더면 true
		boolean fileFlag = "file".equals(type);//타입이 폴더면 true
		boolean allFlag = "all".equals(type);
		
		List<FileWrapper> wrapperList = new ArrayList<>();
		req.setAttribute("wrapperList", wrapperList);
		for(String path : application.getResourcePaths(base)) {
			String realPath = application.getRealPath(path);
			File tmp = new File(realPath); //ex) 전자제품
			if(allFlag || (folderFlag&&tmp.isDirectory()) || (fileFlag&&tmp.isFile())) {
				FileWrapper wrapper = new FileWrapper(tmp, path);
				wrapperList.add(wrapper);
			}
		}
		Collections.sort(wrapperList);
		
		String viewName = null;
		if(accept.contains("json")) { //list객체를 json으로 마샬링 하는 작업
			viewName = "/jsonView.do";
		    req.getRequestDispatcher(viewName).forward(req,resp);
		}else {
			viewName = "/WEB-INF/views/explorer/fileView_case2.jsp";
		}
		req.getRequestDispatcher(viewName).forward(req, resp);
		
		}
	}

