<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="top.jsp" %>
    
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>                                  
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>            
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>   
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>

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
	<h3>JAVACADEMY</h3>
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
	<div class="d-flex justify-content-end mb-2">
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModal">로그인</button>
	</div>
	</c:if>
	<c:if test="${sessionScope.userId !=null && sessionScope.userId !=''}">
		<div class="d-flex justify-content-end mb-2">
			${sessionScope.userName} 님 환영합니다!!
			<button type="button" class="btn btn-success" onclick="logout()">로그아웃</button>
		</div>
	</c:if>
    
  </div> 
</div><!-- .container -->
</nav>
 --%>
<div id="demo" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ol>
  <!-- slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item citem-01 active">
      <div class="carousel-caption d-none d-md-block">
        <h5>First slide label</h5>
        <p>Some representative placeholder content for the first slide.</p>
      </div>
    </div>
    <div class="carousel-item citem-02">      
      <div class="carousel-caption d-none d-md-block">
        <h5>Second slide label</h5>
        <p>Some representative placeholder content for the second slide.</p>
      </div>
    </div>
    
    <div class="carousel-item  citem-03">
      <div class="carousel-caption d-none d-md-block">
        <h5>Third slide label</h5>
        <p>Some representative placeholder content for the third slide.</p>
      </div>
    </div>
  </div> <!-- .carousel-inner -->
  
  <a class="carousel-control-prev" type="button" data-target="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  
  <a class="btn carousel-control-next" type="button" data-target="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>


<h3>여러분 환영합니다!!!~~</h3>

</body></html>