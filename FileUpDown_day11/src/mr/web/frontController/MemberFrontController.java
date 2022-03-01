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
		
		// HandlerMapping
		HandlerMapping handlerMapping = new HandlerMapping();
		controller = handlerMapping.getController(command);
		nextPage = controller.requestHandler(request, response);

		// forward와 redirect 구분
		if(nextPage !=null) {
			if(nextPage.indexOf("redirect:") !=-1) {
				response.sendRedirect(nextPage.split(":")[1]);
			}else {
//				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/member/"+nextPage+".jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher(ViewResolver.getPath(nextPage));
				dispatcher.forward(request, response);
			}
		}
	}
}
