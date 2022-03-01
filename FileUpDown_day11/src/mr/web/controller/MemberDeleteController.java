package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;

public class MemberDeleteController implements Controller {	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		
		String ctx = request.getContextPath();
		
		String nextPage = null;
		
		if(cnt > 0) {
			// 삭제되면 로그아웃 처리
			request.getSession().invalidate();
			nextPage ="redirect:"+ctx+"/memberList.do";
		}else {
			throw new ServletException("delete failed!!");
		}
		
		return nextPage;
	}
	
}
