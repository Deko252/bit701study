<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<div style="margin: 30px 50px">
	<h3 class="alert alert-success">Person List</h3>
	<br>
	<h3>총${count }명의 사람이 있습니다.</h3>
	
	<table class="table table-bordered" style="width: 600px;">
		<tr style="background-color: #ccc">
			<th width="50">번호</th>
			<th width="150">이름</th>
			<th width="100">생년월일</th>
			<th width="90">주소</th>
			<th width="100">직업</th>
			<th width="100">사진</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td align="center">${dto.num }</td>
				<td>${dto.name }</td>
				<td>
					${dto.birthyear }년생<br>
					<c:if test="${dto.birthyear%12 == 0}">
						(원숭이)
					</c:if>
					<c:if test="${dto.birthyear%12 == 1}">
						(닭)
					</c:if>		
					<c:if test="${dto.birthyear%12 == 2}">
						(개)
					</c:if>
					<c:if test="${dto.birthyear%12 == 3}">
						(돼지)
					</c:if>
					<c:if test="${dto.birthyear%12 == 4}">
						(쥐)
					</c:if>
					<c:if test="${dto.birthyear%12 == 5}">
						(소)
					</c:if>
					<c:if test="${dto.birthyear%12 == 6}">
						(호랑이)
					</c:if>
					<c:if test="${dto.birthyear%12 == 7}">
						(토끼)
					</c:if>
					<c:if test="${dto.birthyear%12 == 8}">
						(용)
					</c:if>
					<c:if test="${dto.birthyear%12 == 9}">
						(뱀)
					</c:if>
					<c:if test="${dto.birthyear%12 == 10}">
						(말)
					</c:if>
					<c:if test="${dto.birthyear%12 == 11}">
						(양)
					</c:if>
					띠
				</td>
				<td>${dto.address }</td>
				<td>${dto.job }</td>
				<td>
					<img src="../image/moviestar/${dto.photo }" width="60" border="1" hspace="10">
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>