package mr.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

public class MemberListController implements Controller {	
	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// POJO가 해야할 일
		// Model 연동
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.memberList();
		
		// Object Binding
		request.setAttribute("memberList", memberList);
		
		// View정보
//		return "/WEB-INF/member/memberList.jsp";
		return "memberList";
		
	}
	
}
