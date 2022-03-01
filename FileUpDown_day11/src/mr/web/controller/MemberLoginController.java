package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		// 파라미터값 가져오기
		String userId = request.getParameter("user_id");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(userId);
		dto.setPw(pw);
		
		MemberDAO dao = new MemberDAO();
		String userName = dao.memberLogin(dto);
		
		// userName에 값이 있으면 인증 성공, 값이 없으면 인증 실패
		if(userName != null && !"".equals(userName)) {
			// 인증 성공
			
//			request.setAttribute("userId", name);
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);
		}else {
			// 인증 실패
			request.getSession().setAttribute("userId", "");
			request.getSession().setAttribute("userName", "");
			request.getSession().setAttribute("msg", "존재하지 않는 회원입니다!!");
		}
		
		return "redirect:"+ctx+"/memberList.do";
	}
}
