package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 있는 회원정보 가져오기(Model 연동)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = dao.memberList();
		
		// Object/request 바인딩
		request.setAttribute("memberList", memberList);
		
		// forward
		RequestDispatcher dispatcher=request.getRequestDispatcher("member/memberList.jsp");
		dispatcher.forward(request, response);		
	}

}
