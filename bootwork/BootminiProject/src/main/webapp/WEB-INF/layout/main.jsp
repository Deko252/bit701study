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
	
	.mainphoto{
		width: 200px;
		height: 200px;
		border: 10px solid pink;
		border-radius: 30px;
		margin-right: 20px;
		box-shadow: 3px 3px 3px gray;
	}
	
	.mainboard{
		font-size: 20px;
		width: 300px;azimuth;
		height: 200px;
		border: 25x solid gray;
		border-radius: 20px;
		text-align: center;
		padding-top: 10px; 
		left:10px;
	}
	.mainboard ,goboard{
		cursor: pointer;
	}
	.mainshop{
		font-size: 20px;
		width: 300px;
		height: 200px;
		border-radius: 20px;
		text-align: center;
		padding-top: 10px;
		position: absolute;
		left: 370px;
		top: 225px;
		
	}
	.mainshop, .goshop{
		cursor: pointer;
	}
	
	.mainboard , .mainshop{
		border: 2px solid black;
		left: 500px;
	}
	
</style>
</head>
<body>
	<img alt="" src="./photo/1.png" class="mainphoto">
	<img alt="" src="./photo/2.png" class="mainphoto">
	<img alt="" src="./photo/3.png" class="mainphoto">
	<br><br>
	<div class="mainboard">
		<b>게시판 목록</b>
		<i class="bi bi-plus-circle-fill goboard"></i>
	</div>
	<div class="mainshop">
		<b>상품목록</b>
		<i class="bi bi-cart goshop"></i>
	</div>	
</body>
</html>
