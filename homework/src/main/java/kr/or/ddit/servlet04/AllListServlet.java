package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/allList.do")
public class AllListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClassLoader classLoader = test.class.getClassLoader();
	    File data = new File(classLoader.getResource("kr/or/ddit/MemberData.properties").getFile());
		//파일 읽기
		try(
			FileReader fr = new FileReader(data);
			BufferedReader br = new BufferedReader(fr);
		){
			String memData;
			String id = "";
			String info[];
			String name = null;
			HashMap<String, String> memMap = new HashMap<String, String>();
			while(!((memData=br.readLine())==null)) {
				System.out.println(memData);
				id = memData.substring(0, 5);
				info = memData.split("\\|");
				System.out.println("info: "+info[0]);
				name = info[0].substring(6);
				memMap.put(id, name);
				
			}
			req.setAttribute("memName", memMap.values());
			
			req.getRequestDispatcher("/WEB-INF/views/04/memberForm2.jsp").forward(req, resp);
		}
		
	}
}
