<%@page import="mr.web.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberDelete(num);
	
	if(cnt > 0) {
		response.sendRedirect("memberList.jsp");
	}else {
		throw new ServletException("delete failed!!");
	}
%>    
