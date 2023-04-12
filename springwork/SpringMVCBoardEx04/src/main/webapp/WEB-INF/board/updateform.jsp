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
	.memberphoto{
		width: 50px;
		height: 50px;
		margin-right: 10px;
		border: 1px solid gray;
		border-radius: 50px;
	}
</style>
</head>
<body>
	<i class="bi bi-house" style="font-size: 30px; cursor: pointer; color: red;"
			onclick="location.href='../'"></i>
	<hr>
	<c:if test="${sessionScope.loginok == null }">
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요.");
			location.href="../login/form";
		</script>
	</c:if>
	<c:if test="${sessionScope.loginok != null }">
		<h2>${sessionScope.loginemail } (<img class="memberphoto" src="../photo/${dto.photo }">${dto.name})님이 로그인중입니다.</h2>
		<br><br>
		<form action="updateOfBoard" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${dto.idx }" name="idx">
			<input type="hidden" value="${currentPage}" name="currentPage">
			<table class="table table-boarders" style="width: 500px; margin: 30px 30px">
				<caption align="top"><h4><b>글 수정하기</b></h4></caption>
				<tr>
					<td>
						<input type="text" name="subject" class="form-control" placeholder="제목을 입력하세요" required value="${dto.subject }"> 
					</td>
				</tr>
				<tr>
					<td>
						<h6>사진을 올려주세요</h6>
						<input type="file" name="upload" class="form-control" multiple="multiple"> 
					</td>
				</tr>
				<tr>
					<td>
						<textarea name="content" style="width:  100%; height: 100px;" class="formm-control" required="required" placeholder="내용을 입력해 주세요">${dto.subject }</textarea>
					</td>
				</tr>
				<tr>
					<td align="center">
						<button type="submit" class="btn btn-outline-success" style="width: 130px;" >수정</button>
						<button type="reset" class="btn btn-outline-danger" style="width: 130px;" onclick="location.href='./content?idx=${dto.idx}&currentPage=${currentPage}'">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	<hr>
</body>
</html>