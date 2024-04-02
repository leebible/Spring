package kr.or.ddit.person.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.person.service.PersonServiceImpl;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/people.do")
public class PersonDetailServlet extends HttpServlet{
	private PersonService service = new PersonServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("who");
		if(id==null||id.isEmpty()) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		PersonVO person = service.retrievePerson(id);
		req.setAttribute("person", person);
		req.getRequestDispatcher("/WEB-INF/views/person/detail.jsp").forward(req,resp);
	}
}
