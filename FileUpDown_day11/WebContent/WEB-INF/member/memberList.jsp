<%@page import="java.util.ArrayList"%>
<%@page import="mr.web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@include file="../../top.jsp" %>

 <style>
 	table td{
 		vertical-align: middle !important;/* !important는 기존의 스타일을 다시 무시하고 우선적으로 적용  */
 	}
 </style>
 <script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${!empty msg}">
			alert("${msg}");
			/* <c:remove var="msg" scope="session"/> */
		</c:if>
	});


	function deleteFunc(num){
		location.href="${ctx}/memberDelete.do?num="+num;
	}
	
	function showList(){
		/* let elem = $(".collapse .card").html();
		alert(elem); */
		
		$.ajax({
			url: "<c:url value='/memberAjaxList.do'/>", //서버 요청
			type:"get",
			dataType:"json", //json타입으로
			success: resultPrint, // 회원리스트 받아서 처리하는 콜백함수
			/* error: function(request, status, error){
				alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error:"+error);
			} */ 
			error: function() {alert("에러");}  
		});
	}
	
	// data는 서버에서 넘어온 데이터 [{},{},{},.....]
	function resultPrint(data) {
		let html = "<table class='table'>";
		html+="<thead class='thead-light'>";
		html+="  <tr>                     ";
		html+="    <th>번호</th>          ";
		html+="    <th>아이디</th>        ";
		html+="    <th>비밀번호</th>      ";
		html+="    <th>이름</th>          ";
		html+="    <th>나이</th>          ";
		html+="    <th>이메일</th>        ";
		html+="    <th>전화번호</th>      ";
		html+="    <th>삭제</th>          ";
		html+="  </tr>                    ";
		html+="</thead>                   ";
		html+="<tbody>                    ";
		
		// 반복문 처리 => [{}, {}, .... ]
		$.each(data, function(index, obj){
			html+="<tr>";
			html+="<td>"+obj.num+"</td>";
			html+="<td>"+obj.id+"</td>";
			html+="<td>"+obj.pw+"</td>";
			html+="<td>"+obj.name+"</td>";
			html+="<td>"+obj.age+"</td>";
			html+="<td>"+obj.email+"</td>";
			html+="<td>"+obj.tel+"</td>";
			html+="<td><input type='button' class='btn btn-danger' value='삭제' onclick='ajaxDelete("+obj.num+")'></td>";
			html+="</tr>";
		});
		
		html+="</tbody>";
		html+="</table>";
		
		$("#memberList .card").html(html);
	}
	
	function ajaxDelete(num){
		$.ajax({
			url: "<c:url value='/memberAjaxDelete.do'/>",
			type:"get",
			data:{"num":num},
			success: showList,
			error: function() {alert("에러!!");}
		});
	}
</script>

<div class="container mt-5">
<table class='table'>
	<thead class="thead-light">
	  <tr> 
	    <th>번호</th>    
	    <th>사진</th>    
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
	<c:forEach var="dto" items="${memberList}">
	  <tr>           
	    <td>${dto.num}</td>        
	    <td>
	    	<c:if test="${dto.fileName !=null && dto.fileName !=''}">
	    		<img src="<c:out value='uploaded_file/${dto.fileName}'/>" width="48px" height="48px"/>
	    	</c:if>
	    </td>        
	    <td><a href="${ctx}/memberInfo.do?num=${dto.num}">${dto.id}</a></td>
	    <td>${dto.pw}</td>        
	    <td>${dto.name}</td>      
	    <td>${dto.age}</td>       
	    <td>${dto.email}</td>     
	    <td>${dto.tel}</td>
	    <c:if test="${sessionScope.userId==dto.id}">
	    	<td><input type="button" class="btn btn-danger" value="삭제" onclick="deleteFunc(${dto.num})"></td>
	    </c:if>
	    <c:if test="${sessionScope.userId!=dto.id}">
	    	<td><input type="button" class="btn btn-danger" value="삭제" onclick="deleteFunc(${dto.num})" disabled></td>
	    </c:if>
	  </tr> 
	</c:forEach>  
		<tr>
			<td colspan="9" class="text-center">
				<input type="button" value="회원등록" class="btn btn-primary" onclick="location.href='${ctx}/memberJoin.do'"/>
			</td>
		</tr>           
	</tbody>
</table>
</div> <!-- .container  -->	

<div class="container">
	<p>
	
	  <button class="btn btn-light" type="button" data-toggle="collapse" data-target="#memberList" aria-expanded="false" aria-controls="collapseExample" onclick="showList()">
	    회원 리스트 보기 
	  </button>
	</p>
	<div class="collapse" id="memberList">
	  <div class="card card-body">
	  	테스트 블라블라~~~
	  </div>
	</div>
</div> <!-- .container -->

	
</body>
</html>