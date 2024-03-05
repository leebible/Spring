package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/people.do")
public class PeopleServlet extends HttpServlet {
    
    private Properties memberData;
    
    @Override
    public void init() throws ServletException {
        super.init();
        loadMemberData();
    }
    
    private void loadMemberData() {
        memberData = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("kr/or/ddit/MemberData.properties")) {
            if (inputStream != null) {
                memberData.load(inputStream);
            } else {
                throw new IOException("MemberData.properties 파일을 찾을 수 없습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("memberId");
        
        if (memberId != null && memberData != null && memberData.containsKey(memberId)) {
            String memberInfo = memberData.getProperty(memberId);
            String[] memberDataParts = memberInfo.split("\\|");
            String name = memberDataParts[0];
            String gender = memberDataParts[1];
            int age = Integer.parseInt(memberDataParts[2]);
            String address = memberDataParts[3];
            
            // JSP로 멤버 정보 전달
            request.setAttribute("name", name);
            request.setAttribute("gender", gender);
            request.setAttribute("age", age);
            request.setAttribute("address", address);
            
            System.out.println(name);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/04/memberDetail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Person not found");
        }
    }
}
