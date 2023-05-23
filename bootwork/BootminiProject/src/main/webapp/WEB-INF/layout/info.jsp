<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body *{
		font-family: 'Jua'
	}
	.user{
		text-align: center;
		width: 300px;
	}
	.user .infoimg{
		width: 250px;
	}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<body>
	<div class="user">
		<img class="infoimg" alt="" src="${root }/photo/9.jpg">
		<div>이름 : 김첨지</div>	
		<div><i class="bi bi-telephone"></i> 010-9939-9967</div>
		<div>직업 : 인력거꾼</div>
		<div>취미 : 설렁탕 사러가기</div>
		<div>특징 : 운이 좋음(Lucky Guy)</div>
	</div>
</body>
</html>
