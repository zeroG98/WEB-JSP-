<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! // 선언문
	public int subtract(int x, int y){
		return x - y;
	}
%>    
    
<%
	// 스크립트릿
	int sum=0;
	for(int i=0; i<=100; i++){
		sum +=1;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<li>1~100까지의 합계 : <%=sum %></li>
	<li>메소드 호출 : <%=subtract(100, 10)%></li>
</body>
</html>

<%-- 
[JSP 구성 : 프로그래밍 태그(스크립트릿<% %>) + HTML Tag]

	ㅁ 스크립트릿(프로그래밍 태그)
		- 지시자
			<%@ page  %>	: page 지시자
			<%@ include %>	: include 지시자
			<%@ taglib %>	: taglib 지시자
		- 스크립트릿
			<% %>
		- 선언문
			<%! %>
		- 출력식 
			<%= %>
		- 주석
--%>