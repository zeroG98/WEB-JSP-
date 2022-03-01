package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.web.model.Scoring;

@WebServlet("/score.do")
public class ScoreController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parameter 데이터 얻어오기
		int kor = Integer.parseInt(request.getParameter("kor"));
		int math = Integer.parseInt(request.getParameter("math"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		
		// 처리 로직 ==> Model로 분리
//		int total = kor + eng + math;
//		double avg = total/3.0;
//		String strAvg = String.format("%.2f", avg);
		
		Scoring score = new Scoring(kor, math, eng);
		int total = score.getTotal();
		String strAvg = score.avg();
		
		
		// 응답 로직(프리젠테이션 로직)==> JSP로 변환
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("국영수 결과");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>총점 </td>");
		out.println("<td>");
		out.println(total);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>평균 </td>");
		out.println("<td>");
		out.println(strAvg);
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
