<%@page import="mr.web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 파라미터 값 얻어오기
	int num = Integer.parseInt(request.getParameter("num"));
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	
	MemberDTO dto = new MemberDTO();
	dto.setNum(num);
	dto.setAge(age);
	dto.setEmail(email);
	dto.setTel(tel);
	
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberUpdate(dto);
	
	if(cnt>0) {
		// redirect
		response.sendRedirect("memberList.jsp");
	}else {
		throw new ServletException("update failed!!!");
	}
%>