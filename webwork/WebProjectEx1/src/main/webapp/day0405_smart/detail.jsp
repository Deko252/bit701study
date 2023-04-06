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
	.day{
		float: right;
		margin-right: 10px;
		color: #888;
		font-size: 13px;
	}
	.count{
		float: right;
		margin-right: 10px;
		color: #888;
		font-size: 13px;
	}
</style>
</head>
<body>
	<div style="margin: 30px 50px; width: 600px;">
		<h2><p>${dto.subject }</p></h2>
		<div>
			<b>작성자: ${dto.writer }</b>
			<span class="day">
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH-mm"/>
			</span>
		</div>
		<div class="count">
			조회 ${dto.readcount }
			<span id="likes" style="cursor: pointer;">추천 ${dto.likes }</span>
		</div>
		<br>
		<pre>${dto.content }</pre>
		
		<div>
			<button type="button" class="btn btn-primary"
			onclick="location.href='writeform'">글쓰기
			</button>
			<button type="button" class="btn btn-success"
			onclick="location.href='updateform?num=${dto.num }'">수정
			</button>
			<button type="button" class="btn btn-danger"
			onclick="del(${dto.num })">삭제
			</button>
			<button type="button" class="btn btn-secondary"
			onclick="location.href='list'">목록
			</button>
		</div>
	</div>
	<script type="text/javascript">
		$("#likes").click(function() {
			let num = ${dto.num };
			$.ajax(
					{
						type:"get",
						url:"../day0405_smart/likes.jsp",
						dataType:"json",
						data:{"num":num},
						success:function(res){
							$("#likes").text("추천 " + res.likes);
						},	
					});
		});
		
		function del(num) {
			//alert(num);
			let b = confirm("정말 삭제하시겠습니까?");
			if(b){
				location.href="delete?num="+num;
				alert("삭제되었습니다.");
			}
			
		}
		
	</script>
</body>
</html>