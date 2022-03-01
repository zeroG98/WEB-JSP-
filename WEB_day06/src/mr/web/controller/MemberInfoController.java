package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

public class MemberInfoController implements Controller {	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberInfo(num);
		//바인딩
		request.setAttribute("dto", dto);
		
//		return "/WEB-INF/member/memberInfo.jsp";
		// prefix : /WEB-INF/member/
		// subfix : .jsp
		// prefix 와 subfix를 합쳐서 물리적인 경로를 만들어내는 클래스를 ViewResolver라고한다.
		
		return "memberInfo"; // View이름만 넘겨줌
	}
	
}
