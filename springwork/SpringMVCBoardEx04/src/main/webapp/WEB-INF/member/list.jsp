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
</style>
</head>
<body>
<div style="margin:30px; width: 850px;">
	<h4 class="alert alert-primary">
			총 ${totalCount }명의 회원님이 있습니다.
			<i class="bi bi-house" style="float: right; font-size: 30px; cursor: pointer; color: red;"
			onclick="location.href='../'"></i>
	</h4>
	<table class="table table-bordered">
	<c:forEach var="dto" items="${list }">
		<tr><td rowspan="5" align="center" width="180"><img alt="" src="../photo/${dto.photo }" width="160"></td><td align="center" >회원명 : ${dto.name }</td></tr>
		<tr><td align="center">핸드폰 : ${dto.hp }</td></tr>
		<tr><td align="center">이메일 : ${dto.email }</td></tr>
		<tr><td align="center" >가입일 : <fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td></tr>
		<tr>
		
		<c:if test="${sessionScope.loginemail eq dto.email and sessionScope.loginok != null }">
		<td align="center">
		<button type="button" class="btn btn-info" style="color:white;" onclick="location.href='./updateform?num=${dto.num}'">수정</button>
			<button type="button" class="btn btn-danger"onclick="delmember(${dto.num})">삭제</button></td></c:if>
		</tr>
	</c:forEach>
	</table>
	<script type="text/javascript">
		function delmember(num) {
			let b = confirm("삭제하시겠습니까?");
			if(b){
				location.href="./delete?num="+num;
			}
		}
	</script>
	</div>
</body>
</html>
