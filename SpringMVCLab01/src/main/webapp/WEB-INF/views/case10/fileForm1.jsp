<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
	<input type="text" name="uploader" placeholder = "UPLOADER"/>
	<input type="number" name="count" placeholder = "COUNT"/>
	<input type="file" name="uploadFile" placeholder = "COUNT"/>
	<button type="submit">전송</button>
</form>

<h4>${fileVO }</h4>
</body>
</html>