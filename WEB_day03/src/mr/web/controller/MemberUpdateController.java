package mr.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		MemberDTO dto = new MemberDTO();
		dto.setNum(num);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setTel(tel);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(dto);
		
//		System.out.println("cnt : "+cnt);
		
		if(cnt>0) {
			// redirect
			response.sendRedirect("/WEB_day03/memberList.do");
		}else {
			throw new ServletException("update failed!!!");
		}
	}

}
