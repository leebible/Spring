<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>

<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="kr.or.ddit.servlet07.MbtiControllerServlet"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12/resourceType.jsp</title>
</head>
<body>
<h4>자원의 분류</h4>
<pre>
	해당 자원에 접근하는 방법에 따른 분류
	1. web resource : URL로 접근할 수 있는 웹을 통해 서비스되는 리소스. (논리주소)
		ex) http://localhost:80/WebStudy01/resources/images/cat3.png
		<%
			String url = "/resources/images/cat3.png";
			String realPath = application.getRealPath(url);//실제주소
			out.println(new File(realPath));
		%>
		
		
		<%
		//중간미션 - 내 코드
		//파일주소
		String imgurl="/resources/images/cat5.png";
		String imgrealPath = application.getRealPath(imgurl);
		
		String foldurl="/12";
		String foldrealPath = application.getRealPath(foldurl);
		
		//읽기
		String newimg="/12/cat5.png";
		String newimgPath = application.getRealPath(newimg);
		
		//같은 파일이름 만들기
		File readFile = new File(imgrealPath);
		File writeFile = new File(newimgPath);
		
		out.println("이미지패스:"+imgrealPath);
		out.println(newimgPath);
		
		try(
				InputStream fis = new FileInputStream(readFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				OutputStream fos = new FileOutputStream(writeFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos); 
				//여기까지를 resource라고 한다.
		){
			int readByte = -1;
			while((readByte = bis.read())!=-1) {
				bos.write(readByte);
			}
		 }catch (IOException e) {
		 }
		
		
		%>
	2. file system resource : 파일시스템상의 절대 경로로 접근. (물리주소)
		ex) D:\00.medias\images\cute5.JPG
		<%=new File("D:\\00.medias\\images\\1cute5.JPG") %>
	3. classpath resource : classpath 이후의 경로(qualified name)로 접근.(논리주소)
		ex) /kr/or/ddit/MemberData.properties
		<%
			String logicalPath = "/kr/or/ddit/MemberData.properties";
			String physicalPath = MbtiControllerServlet.class.getResource(logicalPath).getFile();
			out.println(new File(physicalPath));
		%>
		
		<%
			//중간미션--선생님코드
			//소스폴더 경로 + 파일네임.
			String srcFURL = "/resources/images";
			File srcFolder = new File(application.getRealPath(srcFURL));
			
			String srcName = "cat5.png";
			File srcFile = new File(srcFolder, srcName);
			
			String desFURL = "/12";
			File destFolder = new File(application.getRealPath(desFURL));
			File destFile = new File(destFolder, srcFile.getName());
			
			try(
				InputStream is = new FileInputStream(srcFile);
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = new FileOutputStream(destFile);
				BufferedOutputStream bos = new BufferedOutputStream(os);
			){
				int cnt = -1;
				while((cnt=bis.read())!=-1){
					bos.write(cnt);
				}
				bos.flush();
				
			}
		
		%>
		
</pre>
<img src="<%=request.getContextPath() %>/resources/images/cat5.png" />
</body>
</html>