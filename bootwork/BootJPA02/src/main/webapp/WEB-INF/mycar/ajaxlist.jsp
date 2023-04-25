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
	.img{
		width: 250px;
		border: 1px solid black;
		height: 250px;
	}
	
	.content{
		position: absolute ;
		text-align: center;
		border: 1px solid black;
		height: 250px;
		width: 250px;
	}
</style>
<script type="text/javascript">
	$(function(){
		list(1);
		$(".menu b").first().css("color","red");
		$(document).on("click",".list",function(){
			let idx = $(this).attr("idx");
			list(idx);
			$(".list").css("color","black");
			$(this).css("color", "red");
		});
	function list(idx){	
			$.ajax(
					{
						type:"get",
						url:"list",
						data:{"idx":idx},
						dataType:"json",
						success:function(res){
							let s = "";
							$.each(res,function(idx,ele){
								s += `
										<img src="../save/\${ele.carphoto }" class="img">
										<span class="content"><br><br><br><br>이름 : \${ele.carname}<br>가격 : ￦\${ele.carprice}</span><br><br>
								`;
							});
							$(".carlist").html(s);
						},	
						statusCode:{
							404:function(){
								alert("파일이 없어요");
							},
							500:function(){
								alaert("서버오류");
							}
						}
					});
		}
	});
</script>
</head>
<body>
	<div class="menu">
		<b class="list" idx="1" style="cursor: pointer;">높은 가격부터</b>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<b class="list" idx="2" style="cursor: pointer;">낮은 가격부터</b>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<b class="list" idx="3" style="cursor: pointer;">등록 순서대로</b>
		&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="carlist">
	
	</div>
</body>
</html>
