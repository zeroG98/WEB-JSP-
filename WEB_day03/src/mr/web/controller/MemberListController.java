package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		
		// 응답 로직
		System.out.println(memberList);
		
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
		
		out.println("<table class='table'>");
		out.println("<thead>");
		out.println("  <tr> ");
		out.println("    <th>번호</th>    ");
		out.println("    <th>아이디</th>  ");
		out.println("    <th>비밀번호</th>");
		out.println("    <th>이름</th>    ");
		out.println("    <th>나이</th>    ");
		out.println("    <th>이메일</th>  ");
		out.println("    <th>전화번호</th>");
		out.println("    <th>삭제</th>");
		out.println("  </tr>              ");
		out.println("</thead>             ");
		out.println("<tbody>              ");
		
		for(MemberDTO dto : memberList) {
			out.println("  <tr>               ");
			out.println("    <td>"+dto.getNum()+"</td>        ");
			out.println("    <td><a href='/WEB_day03/memberInfo.do?num="+dto.getNum()+"'>"+dto.getId()+"</a></td>");
			out.println("    <td>"+dto.getPw()+"</td>        ");
			out.println("    <td>"+dto.getName()+"</td>        ");
			out.println("    <td>"+dto.getAge()+"</td>        ");
			out.println("    <td>"+dto.getEmail()+"</td>        ");
			out.println("    <td>"+dto.getTel()+"</td>        ");
			out.println("    <td><a class='btn btn-danger' href='/WEB_day03/memberDelete.do?num="+dto.getNum()+"'>삭제</a></td>        ");
			out.println("  </tr>              ");
		}
		out.println("  <tr>              ");
		out.println("  <td colspan='8' class='text-center'>              ");
		out.println("  <a href='member/join.html' class='btn btn-primary'>회원가입</a>");
		out.println("  </td>              ");
		out.println("  </tr>              ");
		
		out.println("</tbody>             ");
		out.println("</table>             ");
		out.println("</body>");
		out.println("</html>");
		
	}

}
