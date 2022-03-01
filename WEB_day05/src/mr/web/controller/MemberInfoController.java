package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

@WebServlet("/memberInfo.do")
public class MemberInfoController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 회원 한명의 대한 정보를 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberInfo(num);
		
		//바인딩
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("member/memberInfo.jsp");		
		dispatcher.forward(request, response);
		
	}

}
