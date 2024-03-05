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

@WebServlet("/peopleList.do")
public class PeopleListServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("memberData", memberData);
        System.out.println(memberData);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/04/memberForm.jsp");
        dispatcher.forward(req, resp);
        
    }
}