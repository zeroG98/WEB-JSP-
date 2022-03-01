package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.MemberDAO;
import mr.web.model.MemberDTO;

@WebServlet("/memberInfo.do")
public class MemberInfoController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 한명의 대한 정보를 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberInfo(num);
		
//		System.out.println(dto);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>                                  ");
		out.println("  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		out.println("  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>            ");
		out.println("  <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>   ");
		out.println("  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>         ");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>"+dto.getName()+"의 회원정보</h3>");
		// 회원정보가 없으면 null값이 넘어오고
		// 회원정보가 있으면 dto 번지가 넘어온다.
		out.println("<form action='/WEB_day03/memberUpdate.do' method='post'>");
		out.println("<input type='hidden' name='num' value='"+dto.getNum()+"'>");
		if(dto !=null) {
			out.println("<table class='table'>");
			out.println("<tr>");
			out.println("<td>번호</td>");
			out.println("<td>"+dto.getNum()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>아이디</td>");
			out.println("<td>"+dto.getId()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>비밀번호</td>");
			out.println("<td>"+dto.getPw()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이름</td>");
			out.println("<td>"+dto.getName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>나이</td>");
			out.println("<td><input type='text' name='age' value='"+dto.getAge()+"'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>이메일</td>");
			out.println("<td><input type='text' name='email' value='"+dto.getEmail()+"'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>전화번호</td>");
			out.println("<td><input type='text' name='tel' value='"+dto.getTel()+"'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan='2' class='text-center'>");
			out.println("<input type='submit' value='수정하기' class='btn btn-primary'/>");
			out.println("<input type='reset' value='취소' class='btn btn-info' />");
			out.println("<a href='/WEB_day03/memberList.do' class='btn btn-warning'>리스트</a>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
			
			out.println("</body>");
			out.println("</html>");
			
		}
		
	}

}
