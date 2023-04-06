<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style type="text/css">
	body, body * {
		font-family: 'Jua'
	}
</style>
</head>
<body>
<fmt:requestEncoding value="utf-8"/>
<form action="Ex02.jsp" method="post">
	이름 : <input type="text" name="irum" value="${param.irum }"><br>
	나이 : <input type="text" name="age" value="${param.age }"><br>
	가고싶은 나라: <input type="text" name="nara" value="${param.nara }">
	<button type="submit">서버에 전송</button>
</form>
<c:if test="${!empty param.irum }">
이름 : ${param.irum }<br>
나이 : ${param.age }<br>
	<c:if test="${param.age >= 20 }">
		<h2 style="color:blue">${param.irum }님은 성인입니다.</h2>
	</c:if>
	<c:if test="${param.age < 20 }">
		<h2 style="color:red">${param.irum }님은 미성년자입니다.</h2>
	</c:if>
	
	<c:set var="nara" value="${param.nara }"></c:set>

	<c:choose>
		<c:when test="${nara == '하와이' }">
			<h3 style="color:green">하와이의 바다는 아름답습니다.</h3>
		</c:when>
		<c:when test="${nara == '프랑스' }">
			<h3 style="color:pink">프랑스의 에펠탑는 아름답습니다.</h3>
		</c:when>
		<c:when test="${nara == '인도' }">
			<h3 style="color:yellow">인도의 타지마할은 아름답습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3 style="color:gray">${nara }은(는) 가보지 않아서 잘 모르겠어요.</h3>
		</c:otherwise>
	</c:choose>
</c:if>
</body>
</html>