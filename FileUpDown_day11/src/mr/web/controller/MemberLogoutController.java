package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		
		// 세션제거
		//1. 강제로 세션 종료
		request.getSession().invalidate();		
		//2. 브라우저 종료시 세션종료
		//3. 세션타임아웃 설정시간동안 아무것도 하지 않을 경우에 자동 종료
		
		return "redirect:"+ctx+"/home.do";
	}
}
