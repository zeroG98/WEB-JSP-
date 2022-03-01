package mr.web.frontController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.controller.Controller;
import mr.web.controller.MemberDeleteController;
import mr.web.controller.MemberInfoController;
import mr.web.controller.MemberInsertController;
import mr.web.controller.MemberJoinController;
import mr.web.controller.MemberListController;
import mr.web.controller.MemberUpdateController;
import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 클라이언트가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI();
		System.out.println(url);
		
		// Context path 부분 : WEB_day05_2
		String ctx = request.getContextPath();
		System.out.println(ctx);
		
		// 실제 요청한 명령찾아내기
//		url.substring(ctx.length(beginIndex, endIndex)) : endIndex가 없으면 끝까지 잘라옴
		String command = url.substring(ctx.length());
		System.out.println(command);
		
		Controller controller = null;
		String nextPage = null;
		
		// 요청에 따른 분기(if ~ else if ~)
		if(command.equals("/memberList.do")) {
//			MemberDAO dao = new MemberDAO();
//			List<MemberDTO> memberList = dao.memberList();
//			request.setAttribute("memberList", memberList);
			
			controller = new MemberListController();
			nextPage = controller.requestHandler(request, response);
			
//			RequestDispatcher dispatcher=request.getRequestDispatcher("member/memberList.jsp");
			RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/memberInsert.do")) {			
			controller = new MemberInsertController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}else if(command.equals("/memberJoin.do")) { // 회원등록 화면
			controller = new MemberJoinController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/memberInfo.do")) {
			controller = new MemberInfoController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);		
			dispatcher.forward(request, response);
			
		}else if(command.equals("/memberUpdate.do")) {
			controller = new MemberUpdateController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}else if(command.equals("/memberDelete.do")) {
			controller = new MemberDeleteController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
		}
		
	}

}
