package mr.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

public class MemberAjaxListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.memberList();
		
		// GSON API :ArrayList를 JSON으로 변환
		Gson gson = new Gson();
		String json = gson.toJson(memberList);
		System.out.println(json);
		
		// $.ajax() 응답(json으로)
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
		
		
		return null;
	}
}
