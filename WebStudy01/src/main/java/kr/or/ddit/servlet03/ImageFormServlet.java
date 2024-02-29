package kr.or.ddit.servlet03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet {
    private ServletContext application;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        application = getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = resp.getWriter();
    	String contextPath = req.getContextPath();
    	String folderPath = "D:/00.medias/images"; 

    	out.println("<html>");
    	out.println("    <body>");
    	out.println("        <form action='" + contextPath + "/image.do' method='GET'>");
    	out.println("            <select name='name'>");

    	File folder = new File(folderPath);
    	if (folder.isDirectory()) {
    	    File[] files = folder.listFiles();
    	    for (File file : files) {
    	        if (file.isFile()) {
    	            out.println("                <option>" + file.getName() + "</option>");
    	        }
    	    }
    	}
    	out.println("            </select>");
    	out.println("            <button type='submit'>이미지 랜더링</button>");
    	out.println("        </form>");
    	out.println("    </body>");
    	out.println("</html>");

    	out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	File imageFolder = new File("D:/00.medias/images");
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
		
		resp.setContentType(mime);
		resp.setContentLengthLong(imageFile.length());
		
		try(
				InputStream is = new FileInputStream(imageFile);
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = resp.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(os);
		){
			int readByte = -1;
			while((readByte = bis.read())!=-1) {
				bos.write(readByte);
			}
		 }
    }
}