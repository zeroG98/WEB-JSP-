<%@page import="mr.web.model.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// controller에서 작업했다고 가정
	String[] strArr = {"사자", "호랑이", "고양이", "개", "독수리"};
	request.setAttribute("strArr", strArr);
	
	int intVar = 20;
	
	// ArrayList
	List<String> list = new ArrayList<String>();
	
	list.add("Java");
	list.add("Python");
	list.add("C++");
	list.add("JavaScript");
	list.add("Node.js");
	
	request.setAttribute("list", list);
	
	MemberDTO dto = new MemberDTO();
	
	dto.setNum(1);
	dto.setName("김말똥");
	dto.setEmail("test@gmail.com");
	dto.setTel("12121212");
	
	request.setAttribute("dto", dto);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${strArr} == request.getAttribute("strArr")
	 : Object 바인딩한 값을 꺼내온 것과 같다. 
--%>

<%-- 변수값 : ${intVar} 스크립트릿의 변수는 인식안됨 --%>

<c:forEach var="ani" items="${strArr}">
	${ani}<br>
</c:forEach>

<c:forEach var="lang" items="${list}">
	${lang}<br>
</c:forEach>

<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
	</tr>
	<tr>
		<td>${dto.num}</td> <!-- dto.getNum() -->
		<td>${dto.name}</td>
		<td>${dto.email}</td>
		<td>${dto.tel}</td>
	</tr>
</table>











</body>
</html>