<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Detail</title>
   
</head>
<body>
    <!-- 모달 내용 -->
    <div class="modal-content">
        <span class="close">&times;</span>
	       <table>
			    <tr>
			        <th>NAME</th>
			        <td>${name}</td>
			    </tr>
			    <tr>
			        <th>GENDER</th>
			        <td>${gender}</td>
			    </tr>
			    <tr>
			        <th>AGE</th>
			        <td>${age}</td>
			    </tr>
			    <tr>
			        <th>ADDRESS</th>
			        <td>${address}</td>
			    </tr>
		</table>
    </div>

    <!-- JavaScript 파일 연결 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/04/memModal.js"></script>
</body>
</html>
