<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%-- 
jstl : jsp standard tag library
core tag : if, for, switch .. 같이 많이 사용하는 명령들이 있는 태그

 	int aa = 100;

	EL:Expression Language
	${식}
--%>

<c:set var="aa" value="100"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${aa>500}
</body>
</html>