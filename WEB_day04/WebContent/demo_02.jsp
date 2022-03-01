<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mr.web.model.*" %>    

<%
	MyDemo myDemo = new MyDemo();
	int sum = myDemo.sum();
	int sub = myDemo.subtract(1, 100);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<li>1~100까지의 합계 : <%=sum %></li>
	<li>메소드 호출 : <%=sub %></li>
</body>
</html>