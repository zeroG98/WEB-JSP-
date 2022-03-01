<%@page import="java.util.ArrayList"%>
<%@page import="mr.web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> memberList = dao.memberList();
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
<script type="text/javascript">
	function deleteFunc(num){
		location.href="memberDelete.jsp?num="+num;
	}
</script>
<div class="container">
<h2>회원리스트</h2>
<table class='table'>
	<thead class="thead-light">
	  <tr> 
	    <th>번호</th>    
	    <th>아이디</th> 
	    <th>비밀번호</th>
	    <th>이름</th>   
	    <th>나이</th>  
	    <th>이메일</th> 
	    <th>전화번호</th>
	    <th>삭제</th>
	  </tr>         
	</thead>
	<tbody>
	<%for(MemberDTO dto: memberList){ %>
	  <tr>           
	    <td><%=dto.getNum()%></td>        
	    <td><a href="memberInfo.jsp?num=<%=dto.getNum()%>"><%=dto.getId()%></a></td>
	    <td><%=dto.getPw()%></td>        
	    <td><%=dto.getName()%></td>      
	    <td><%=dto.getAge()%></td>       
	    <td><%=dto.getEmail()%></td>     
	    <td><%=dto.getTel()%></td>
	    <td><input type="button" class="btn btn-danger" value="삭제" onclick="deleteFunc(<%=dto.getNum()%>)"></td>
	  </tr> 
	<%}%>  
		<tr>
			<td colspan="8" class="text-center">
				<input type="button" value="회원등록" class="btn btn-primary" onclick="location.href='join.html'"/>
			</td>
		</tr>           
	</tbody>
</table>
</div>	
</body>
</html>