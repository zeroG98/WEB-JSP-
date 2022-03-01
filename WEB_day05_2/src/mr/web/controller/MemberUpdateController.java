package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

public class MemberUpdateController implements Controller{	
	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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

		String nextPage = null;
		
		if(cnt>0) {
			// redirect
			nextPage ="/WEB_day05_2/memberList.do";
		}else {
			throw new ServletException("update failed!!!");
		}
		
		return nextPage;
	}
}
