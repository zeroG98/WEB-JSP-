<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mr.web.model.*" %>

<%
	request.setCharacterEncoding("utf-8");

	// 파라미터 값 얻어오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	dto.setPw(pw);
	dto.setName(name);
	dto.setAge(age);
	dto.setEmail(email);
	dto.setTel(tel);
	
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberInsert(dto);
	
	if(cnt > 0) {
		// 회원 리스트 페이지로 이동 redirect해준다.
		response.sendRedirect("memberList.jsp");
	} else {
		throw new ServletException("insert failed!!!!!!");
	}
%>  
