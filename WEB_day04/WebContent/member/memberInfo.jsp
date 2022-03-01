<%@page import="mr.web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//회원 한명의 대한 정보를 가져오기
	int num = Integer.parseInt(request.getParameter("num"));
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.memberInfo(num);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>                                  
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>            
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>   
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>
</head>
<body>
<div class="container">
<form class="form-inline" action="memberUpdate.jsp" method="post">
<input type="hidden" name="num" value="<%=dto.getNum()%>" />
<table class="table">
	<tr>
		<td colspan="2" class="text-center"><%=dto.getName()%>회원의 정보</td>
	</tr>
<% if(dto !=null) { %>
	<tr>
		<td>번호</td>
		<td><%=dto.getNum()%></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=dto.getId()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=dto.getPw()%></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=dto.getName()%></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input class="form-control" type="text" name="age" value="<%=dto.getAge()%>"/></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input class="form-control" type="text" name="email" value="<%=dto.getEmail()%>"/></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input class="form-control" type="text" name="tel" value="<%=dto.getTel()%>"/></td>
	</tr>
<% } %>	
	<tr>
		<td colspan="2" class="text-center">
			<input type="submit" value="수정하기" class="btn btn-primary mr-2" />
			<input type="reset" value="취소" class="btn btn-info mr-2" />
			<input type="button" value="리스트" class="btn btn-secondary" onclick="location.href='memberList.jsp'"/>
		</td>
	</tr>
</table>
</form>
</div>


</body>
</html>