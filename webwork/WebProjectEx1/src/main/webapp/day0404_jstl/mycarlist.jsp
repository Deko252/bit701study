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
	<h3 class="alert alert-warning">Mycar List</h3>
	<br>
	<h3>총${count }대의 차량이 있습니다.</h3>
	
	<table class="table table-bordered" style="width: 800px;">
		<tr style="background-color: #ccc">
			<th width="50">번호</th>
			<th width="70">사진</th>
			<th width="100">차종</th>
			<th width="70">차량가격</th>
			<th width="100">구입일</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td align="center">${i.count }</td>
				<td>
					<img src="../image/mycarimage/${dto.carphoto }" width="150" border="1" hspace="10">
				</td>
				<td>${dto.carname }</td>
				<td>
					<fmt:formatNumber value="${dto.carprice }" type="currency" currencySymbol="￦"></fmt:formatNumber>
				</td>
				<td>${dto.buyday }</td>
			</tr>
		</c:forEach>
	</table>
	
</div>
</body>
</html>