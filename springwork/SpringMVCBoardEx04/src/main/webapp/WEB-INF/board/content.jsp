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
	.alist{
		padding-left: 10xp;
		color: #666;
	}
</style>
<script type="text/javascript">
	$(function() {
		list();//처음 시작시 댓글 출력
		
		//댓글 추가 이벤트
		$("#btnasave").click(function() {
			//댓글 내용이 없을 경우 경고후 종료
			let content = $("#answer").val();
			let idx = ${dto.idx};
			let num = ${sessionScope.loginnum};
			
			if(content.trim() == ""){
				alert("댓글을 입력해주세요.");
				return false;
			}
			$.ajax({
					type:"get",
					url:"ainsert",
					data:{"idx":idx,"content":content,"num":num},
					dataType:"text",
					success:function(){
						//댓글다시출력
						list();
						//입력창에 댓글삭제
						$("#answer").val("");
					}
			});
			
		});
		//입력후 엔터
		$("#answer").keyup(function (e) {
			if(e.keyCode == 13){
				$("#btnasave").click();
			}
		});
		
		//댓글 숨겼다/나타났다하기
		$("b.answer").click(function(){
			$(".alist").toggle('fast');
		});
	});
	
	//댓글 출력하는 함수
	function list() {
		
		//글번호 구하기
		let idx = ${dto.idx}
		
		//로그인한 사람의 num
		let num =${sessionScope.loginnum};
		
		$.ajax({
			type:"get",
			url:"alist",
			data:{"idx":idx},
			dataType:"json",
			success:function(res){
				//댓글 갯수 출력
				$("span.acount").text(res.length);
				
				//댓글 출력
				
				let s = "";
				
				$.each(res,function(idx, ele){
					s+=
						`
						<img src="../photo/\${ele.photo}" class="rounded-circle" width=30 height=30 hspace=5>
						\${ele.content}&nbsp;&nbsp;
						<span style="font-size:13px">\${ele.writeday}</span>
						`;
					if(num == ele.num){
						s += `
						&nbsp;
						<i class="bi bi-trash adelete" seq="\${ele.seq}" style="cursor: pointer;"></i>
						`;						
					}	
					s += `<br>`
					
				});
				$(".alist").html(s);
				
			}
	});
	}
	$(document).on("click",".adelete",function(){
		
		let seq = $(this).attr("seq");
		
		let b = confirm("해당 댓글을 삭제하려면 확인을 눌러주세요.");
		if(b){
		$.ajax({
			type:"get",
			url:"adelete",
			data:{"seq":seq},
			dataType:"text",
			success:function(){
				list();
				}
			});
		}
	});
</script>
</head>
<body>
<c:if test="${sessionScope.loginok == null }">
	<script type="text/javascript">
		alert("로그인을 먼저 해주세요");
		location.href="../login/form";
	</script>
</c:if>
	<div style="margin: 30px 50px; width: 600px;">
		<table class="table">
			<tr>
				<h2><b>${dto.subject }</b></h2>
				<img src="../photo/${dto.photo }" class="rounded-circle" width="50" height="50"align="left" hspace="10">
				<b>${dto.name}</b><br>
				<span style="color: #bbb; font-size: 12px;">
					<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH-mm"/>
					&nbsp;
					조회 ${dto.readcount }
				</span>
				<span style="float: right; color: #333; font-size: 16px;">
					<i class="bi bi-chat-dots"></i>&nbsp; 댓글<span class="acount"></span>
				</span>
			</tr>
			<tr>
				<td>
					<pre style="margin-top: 30px;">${dto.content }</pre>
					<br>
					<c:if test="${dto.images !='no' }">
						<c:forTokens items="${dto.images }" delims="," var="myimg">
							<img alt="" src="../photo/${myimg }" class="img-thumbmail" style="max-width:500px;">
						</c:forTokens>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<b class="answer" style="cursor: pointer;" >댓글<span class="acount"></span></b>
					<div class="alist"></div>
				</td>
			</tr>
			<!-- 로그인한 사람만 댓글 추가 기능 -->
			<c:if test="${sessionScope.loginok != null }">
				<tr>
					<td class="input-group">
						<input type="text" id="answer" class="form-control"
						placeholder="댓글을 입력해주세요">
						<button type="button" id="btnasave" class="btn btn-outline-success btn-sm">추가</button>
					</td>
				</tr>
			</c:if>
			<tr>
				<td>
					<c:if test="${sessionScope.loginok != null and sessionScope.loginnum == dto.num }">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='./updateform?idx=${dto.idx}&currentPage=${currentPage}'">수정</button>			
						<button type="button" class="btn btn-outline-secondary" onclick="delboard(${dto.idx })">삭제</button>
					</c:if>
					<button type="button" class="btn btn-outline-secondary" style="float:right; margin-right: 0px;" onclick="location.href='list?currentPage=${currentPage}'" >목록</button>
				</td>
			</tr>
		</table>
	
	</div>
	<script type="text/javascript">
		function delboard(idx) {
			let b = confirm("삭제하시겠습니까?");
			if(b){
				let currentPage=${currentPage};
				location.href="./delete?idx=" + idx + "&currentPage=" + currentPage ;
			}
		}
	</script>
</body>
</html>
