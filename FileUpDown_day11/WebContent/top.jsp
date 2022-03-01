<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>                                  
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>            
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>   
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>
<script type="text/javascript">
	function checkValidation(){
		if($("#user_id").val()==''){
			alert("아이디를 입력하세요!!");
			$("#user_id").focus();
			return false;
		}
		
		if($("#pw").val()==''){
			alert("비밀번호를 입력하세요!!");
			$("#pw").focus();
			return false;
		}
		
		return true;
	}
	function logout(){
		// c:url을 이용하면  ${ctx}를 생략할 수 있다.
		location.href="<c:url value='/memberLogout.do'/>";
	}
</script>

<link rel="stylesheet" href="./css/main.css">
</head>
<body>

<!-- Modal -->
<div class="container">
	<div class="modal fade" id="loginModal">
	  <div class="modal-dialog">
	    <div class="modal-content ml-5" style="width:400px">
	    
	      <!-- Modal header -->
	      <div class="modal-header border-0"> 
	      	<!-- <h4 class="modal-title">로그인</h4> -->   
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      
	      <!-- Modal body -->
	      <form action="${ctx}/memberLogin.do">
	      	<div class="modal-body px-5 pt-0">
	      		<input class="form-control" type="text" placeholder="아이디" id="user_id" name="user_id"><br>
	      		<input class="form-control" type="password" placeholder="비밀번호" id="pw" name="pw">
	      	</div>
	      
		  <!-- Modal footer -->
		    <div class="modal-footer border-0 d-flex justify-content-center">
		       <button type="submit" class="btn btn-primary" onclick="return checkValidation()">로그인</button>
		    </div>
	      </form>
	    </div>
	  </div>
	</div>
</div> <!-- .container  -->	
<!-- End of Modal -->

<div class="container">
	<br><br>
	<h3><a href="${ctx}/home.do" style="text-decoration:none">JAVACADEMY</a></h3>
</div>

<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
<div class="container">
<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
    <span class="navbar-toggler-icon"></span>
  </button> -->
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${ctx}/memberList.do">회원관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">메뉴</a>
      </li>
    </ul>
    <c:if test="${sessionScope.userId==null || sessionScope.userId==''}">
	<div class="d-flex justify-content-end">
		<button type="button" class="btn btn-success mr-2" data-toggle="modal" data-target="#loginModal">로그인</button>
	</div>
	</c:if>
	<c:if test="${sessionScope.userId !=null && sessionScope.userId !=''}">
		<div class="d-flex justify-content-end">
			<div class="mr-2 align-self-center" style="color:white;">${sessionScope.userName} 님 환영합니다!!</div>
			<button type="button" class="btn btn-success" onclick="logout()">로그아웃</button>
		</div>
	</c:if>
  </div> 
</div><!-- .container -->
</nav>
