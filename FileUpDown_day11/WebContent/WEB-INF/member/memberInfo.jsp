<%@page import="mr.web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../../top.jsp" %>

<script type="text/javascript">
	function update(){
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
  					document.infoForm.action="<c:url value='/memberUpdate.do'/>?mode=fupdate";
  					document.infoForm.submit(); //num, age, email, tel, fileName =>전송
  				},
  				error: function(){alert("error발생!!!")}
  			});
  		}else{ // 사진 첨부되지 않았을 경우
  			document.infoForm.action="<c:url value='/memberUpdate.do'/>?mode=update";
			document.infoForm.submit(); //num, age, email, tel =>전송
  		}
	}
	function formReset(){
		document.infoForm.reset();
	}
	
	function getFile(fileName){
		location.href="<c:url value='/getFile.do'/>?fileName="+fileName;
	}
	
	function delFile(num, fileName){
		location.href="<c:url value='/delFile.do'/>?num="+num+"&fileName="+fileName;
	}
</script>

<!-- </head>
<body>
 -->
<div class="container mt-5 d-flex justify-content-center">
	<div class="w-50 border rounded px-5 py-5 shadow"">
		<form method="post" name="infoForm">
		<input type="hidden" name="num" value="${dto.num}" />
		<input type="hidden" name="fileName" id="fileName" value=""/>
		  <h3 class="text-center">회원 정보</h3>
		  
		  <div class="d-flex mt-3 mb-4">
		  <c:if test="${sessionScope.userId !=null && sessionScope.userId!=''}">
		  	<c:choose>
			  	<c:when test="${dto.fileName==null || dto.fileName==''}"> <!-- 사진이 등록되지 않은 경우 -->	
				  <div class="col-md-3 mr-auto pl-0">
				  	<img class="border border-secondary" src="${ctx}/img/people.png" width="100px" height="100px" style="opacity:0.5"/>	
				  </div>
				  <span>*사진이 등록되지 않았습니다!!</span>
				</c:when>
				<c:otherwise> <!-- 사진이 등록된 경우 -->
				  	<div class="col-md-3 mr-auto pl-0">
				  		<img class="border border-secondary" src="${ctx}/uploaded_file/${dto.fileName}" width="100px" height="100px"/>
				  	</div>
				  	<%-- <a class="btn btn-sm align-self-end btn-outline-info" style="height:30px" onclick="javascript:getFile('${dto.fileName}')"><c:out value='${dto.fileName}'/> <i class="far fa-save"></i></a> --%>
				  	<a class="btn btn-sm align-self-end btn-outline-info" style="height:30px" onclick="javascript:getFile('${dto.fileName}')">사진 다운로드 <i class="far fa-save"></i></a>
				  	<c:if test="${sessionScope.userId==dto.id}">
				  	<a class="btn btn-sm align-self-end btn-outline-info ml-1" style="height:30px" onclick="javascript:delFile('${dto.num}','${dto.fileName}')">사진 삭제 <i class="far fa-trash-alt"></i></a>
				  	</c:if>
				  		
				</c:otherwise>
			</c:choose>
			</c:if>
			<!-- 로그인을 안하면 샘플사진 보이도록... -->
			<c:if test="${sessionScope.userId ==null || sessionScope.userId==''}">
			 <div class="col-3 mr-auto pl-0">
			  	<img class="border border-secondary" src="${ctx}/img/people.png" width="100px" height="100px" style="opacity:0.5"/>	
			 </div>
			 <span>* 로그인 후 수정이 가능합니다!!</span>
		    </c:if>
		  </div>
		  <div class="d-flex">
			  <div class="form-group col-2 pl-0">
			    <label for="num">번호</label>
			    <input type="text" class="form-control" id="num" value="${dto.num}" disabled>
			  </div>
			  <div class="form-group col-8">
			    <label for="name">이름</label>
			    <input type="text" class="form-control" id="name" value="${dto.name}" disabled>
			  </div>
			  <div class="form-group col-2 pr-0">
			    <label for="age">나이</label>
			    <input type="text" class="form-control" id="age" value="${dto.age}" name="age">
			  </div>
		  </div>
		  
		  <div class="d-flex">
			  <div class="form-group col-6 pl-0">
			    <label for="id">아이디</label>
			    <input type="text" class="form-control" id="id" value="${dto.id}" disabled>
			  </div>
			  <div class="form-group col-6 pr-0">
			    <label for="pw">비밀번호</label>
			    <input type="password" class="form-control" id="pw" value="${dto.pw}" disabled>
			  </div>
		  </div>
		  
		  <div class="d-flex">
			  <div class="form-group col-6 pl-0">
			    <label for="email">이메일</label>
			    <input type="text" class="form-control" id="email" value="${dto.email}" name="email">
			  </div>
			  <div class="form-group col-6 pr-0">
			    <label for="tel">전화번호</label>
			    <input type="text" class="form-control" id="tel" value="${dto.tel}" name="tel">
			  </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="myFile">사진첨부</label><br>
		    <c:if test="${sessionScope.userId == dto.id}">
		    	<input type="file" id="myFile" name="myFile">
		    </c:if>
		    <c:if test="${sessionScope.userId != dto.id}">
		    	<input type="file" id="myFile" name="myFile" disabled>
		    </c:if>
		  </div>
		  
		</form>
		  <div class="text-center mt-5">
		  <c:if test="${!empty sessionScope.userId}">
		  	<c:if test="${sessionScope.userId ==dto.id}">	
			  <input type="button" value="수정하기" class="btn btn-primary mr-2" onclick="update()"/>
			</c:if> 
		  	<c:if test="${sessionScope.userId !=dto.id}">	
			  <input type="button" value="수정하기" class="btn btn-primary mr-2" disabled/>
			</c:if> 
		  </c:if>	  
	  		  <input type="reset" value="취소" class="btn btn-info mr-2" onclick="formReset()"/>
			  <input type="button" value="리스트" class="btn btn-secondary" onclick="location.href='${ctx}/memberList.do'"/>
		  </div>
	</div>
</div>
</body>
</html>