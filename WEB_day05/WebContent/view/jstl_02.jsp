<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="a" value="11"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- if문 -->
<c:if test="${a%2==0}">
짝수
</c:if>
<c:if test="${a%2!=0}">
홀수
</c:if>
<br>
<!-- switch문 -->
<c:choose>
	<c:when test="${a%2==0}">짝수입니다.</c:when>
	<c:when test="${a%2!=0}">홀수입니다.</c:when>
	<c:otherwise>일치하는 when절이 없는 경우 실행됩니다...</c:otherwise>
</c:choose>
<br>
<!-- 
servlet으로 변환시 아래와 같이 변환됨
var="i" == request.setAttribute("i", i);
${i} == request.getAttribute("i")


반복문 
-->
<c:forEach var="i" begin="1" end="10" step="1">
	<font size="${i}">jstl study</font><br>
</c:forEach>


</body>
</html>