<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@include file="../../top.jsp" %>

  
  <script type="text/javascript">
  	function join(){
  		document.joinForm.action="<c:url value='/memberInsert.do'/>";
  		document.joinForm.submit();
  	}
  	
  	function join2(){ 
  		if($("#myFile").val() !=''){ // 사진이 첨부됬을 때
  			let formData = new FormData(); // 인위적으로 form을 생성
  			formData.append("myFile", $("input[name=myFile]")[0].files[0]); // 첫번째 파일객체의 첫번째 파일
  			
  			$.ajax({
  				url:"<c:url value='/fileAttach.do'/>",
  				type:"post",
  				data: formData,
  				processData: false,
  				contentType: false, // multipart/form-data 형식
  				
  				success: function(data){ //data: 서버에 업로드된 실제 파일이름
  					/* alert(data); */
  					$("#fileName").val(data);
  					document.joinForm.action="<c:url value='/memberInsert.do'/>?mode=fa";
  					document.joinForm.submit(); //id, pw, name, age, email, tel, fileName =>전송
  				},
  				error: function(){alert("error발생!!!")}
  			});
  		}else{ // 사진 첨부되지 않았을 경우
  			document.joinForm.action="<c:url value='/memberInsert.do'/>?mode=a";
			document.joinForm.submit(); //id, pw, name, age, email, tel =>전송
  		}
  	}
  	
  	function formReset(){
  		document.joinForm.reset();
  	}
  	
  	function idChk(){
  		if($("#id").val()==''){
  			alert("아이디를 입력하세요");
  			$("#id").focus();
  			return;
  		}
  		
  		let id = $("#id").val();
  		$.ajax({
  			     // Context를 포함한 경로를 사용하고자 할 때 url을 이용한다.
  			url:"<c:url value='/memberIdCheck.do'/>",
  			type:"POST",
  			data:{"id": id}, // key, value 형태로 서버에 보내는 data를 의미
  			success: duplicateChk, // 함수(Callback)
  			error:function() {
  				alert("요청 실패!!!");
  			}	
  		});
  	}
  	// 서버로 부터 넘어온 응답 결과를 data변수 받는다.
  	function duplicateChk(data){
  		if(data != "N"){
  			alert("이미 존재하는 아이디입니다!!");
  			$("#id").focus();
  		}else{
  			alert("사용가능한 아이디 입니다!!");
  		}
  	}
  </script>  

<div class="container mt-5 d-flex justify-content-center">
	<div class="w-50 border rounded px-5 py-5 shadow"">
		<form method="post" name="joinForm">		
		  <h3 class="text-center">회원 등록</h3>		  
		  <div class="form-group">
		    <label for="id" style="display:block">아이디</label>
		    <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요" style="display:inline-block; width:70%;"/>
		    <input type="button" class="ml-1 align-top btn btn-warning" value="중복확인" style="display:inline-block; width:27%;" onclick="idChk()"/>
		  </div>
		  <div class="form-group">
		    <label for="pw">비밀번호</label>
		    <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요"/>
		  </div>
		  <div class="form-group">
		    <label for="name">이름</label>
		    <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>
		  </div>
		  <div class="form-group">
		    <label for="age">나이</label>
		    <input type="text" class="form-control" id="age" name="age" placeholder="나이를 입력하세요"/>
		  </div>
		  <div class="form-group">
		    <label for="email">이메일</label>
		    <input type="text" class="form-control" id="email" name="email" placeholder="이메일을 입력하세요"/>
		  </div>
		  <div class="form-group">
		    <label for="tel">전화번호</label>
		    <input type="text" class="form-control" id="tel" name="tel" placeholder="전화번호를 입력하세요"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="myFile">사진첨부</label>
		    <input type="file" id="myFile" name="myFile"/>
		  </div>
		  <input type="hidden" name="fileName" id="fileName" value="" />
  		</form>
		<div class="text-center mt-5">
			<c:if test="${sessionScope.userId==null || sessionScope.userId==''}">	
				<input type="button" value="등록" class="btn btn-primary mr-2" onclick="join2()"/>
			</c:if>
			<c:if test="${sessionScope.userId!=null && sessionScope.userId !=''}">	
				<input type="button" value="등록" class="btn btn-primary mr-2" disabled/>
			</c:if>
		    	<input type="reset" value="취소" class="btn btn-info mr-2" onclick="formReset()"/>
	    	<input type="button" value="리스트" class="btn btn-secondary" onclick="location.href='${ctx}/memberList.do'"/>
		</div>
	</div>
</div> <!-- .container -->
</body>
</html>