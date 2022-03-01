package mr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ht.do")
public class HelloTest extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.println("<html>");
		out.println("<body>");
		out.println("하이~ Servlet!!");		
		out.println("Hello, Servlet!!");		
		out.println("</body>");		
		out.println("</html>");
	}
}
