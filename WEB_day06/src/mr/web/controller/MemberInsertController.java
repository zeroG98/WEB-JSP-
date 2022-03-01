package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

public class MemberInsertController implements Controller {	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setTel(tel);
		
//		System.out.println(dto);
		
		// Model과 연동(DAO와 연동)
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(dto);
		
		String ctx = request.getContextPath();
		
		String nextPage = null;
		
		if(cnt > 0) {
			// 회원 리스트 페이지로 이동 redirect해준다.
			nextPage = "redirect:"+ctx+"/memberList.do";
		} else {
			throw new ServletException("insert failed!!!!!!");
		}
		
		return nextPage;
	}
	
}
