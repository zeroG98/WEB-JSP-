<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mr.web.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	MemberDTO dto = new MemberDTO();
	
	dto.setNum(1);
	dto.setName("김말똥");
	dto.setEmail("test@gmail.com");
	dto.setTel("12121212");
	
	List<MemberDTO> list = new ArrayList<MemberDTO>();
	list.add(dto);
	list.add(dto);
	list.add(dto);
	list.add(dto);
	list.add(dto);
	
	request.setAttribute("list", list);
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
	</tr>
	<c:forEach var="dto" items="${list}">
	<tr>
		<td>${dto.num}</td> <!-- dto.getNum() -->
		<td>${dto.name}</td>
		<td>${dto.email}</td>
		<td>${dto.tel}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>