package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;

public class MemberIdCheckController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// $.ajax(); 함수에서 넘어온 데이터 
		String id =request.getParameter("id"); // {"id" : id}
		MemberDAO dao = new MemberDAO();
		String resultChk = dao.memberIdChk(id); // "Y" or "N"
		
		response.getWriter().print(resultChk);
		
		return null; // 비동기처리를 위해서는 페이지가 바뀌지 않도록 null 처리해야한다.
	}
}
