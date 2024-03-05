<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Information</title>
    <style>
        /* 모달 스타일 */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.4);
        }
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }
        /* 닫기 버튼 스타일 */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
    <!-- 서버 측 정보를 저장하는 JavaScript 변수 -->
    <script>
        var contextPath = '<%= request.getContextPath() %>';
    </script>
</head>
<body>
    <!-- 모달 -->
    <div id="myModal" class="modal">
        <!-- 모달 내용 -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <div id="memberDetailTable">
                <!-- 멤버 세부 정보가 여기에 표시됨 -->
            </div>
        </div>
    </div>

    <!-- peopleList.do 서블릿으로부터 받은 전체 멤버 목록을 출력합니다. -->
    <ul>
    <% 
      //HashMap<String, String> memMap = (HashMap<String, String>) request.getAttribute("memName");
      String[] memMap = (String[]) request.getAttribute("memName");
      
      for(int i=0; i<memMap.length; i++){ 
      	String memName = memMap[i]; %>
      	<li> <%=memName %></li>
     <% 
      }
      %>
    </ul>

    <!-- JavaScript 파일 연결 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/04/memModal.js"></script>
</body>
</html>
    </ul>

    <!-- JavaScript 파일 연결 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/04/memModal.js"></script>
</body>
</html>
