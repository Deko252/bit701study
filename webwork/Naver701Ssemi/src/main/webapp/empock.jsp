<%@page import="dto.SsemiDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.SsemiDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>예약확인</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<style type="text/css">
	body, body * {
		font-family: 'Jua'
	}
	body{
		background-image: url("image/star.jpg");
		color: white;
		overflow:hidden;
	}
	table th{
		border: 1px solid white;
		background-color: rgba(255,255,255,0.5);
		color: black;
		text-align: center;
	}
	table tr td{
		border: 1px solid white;
		font-size: 30px;
		width: 10%;
		height: 5%;
		text-align: center;
	}
	h2{
		position: absolute;
		width: 100%;
		text-align: center;
		font-size: 50px;
		margin-top: 20px;
	}
	
	div.tb{
	position: relative;
	}
	table.empotable{
		position: absolute;
		top: 50%;
		left: 12%;
		right: 12%;
		margin-top: 150px;
	}
	#btnC{
		margin-top:20px;
		margin-left:20px;
		font-size: 25px;
		position: absolute;
	}
	#listcount{
		margin-left :230px;
		margin-top: 120px;
		position: absolute;
	}
	.animate__backInUp{
	 	animation-duration: 2.7s; /* don't forget to set a duration! */
	}
	
	.animate__fadeIn{
		animation-duration: 3.2s; /* don't forget to set a duration! */
	}

	
</style>
<%
//dao 선언
SsemiDao dao = new SsemiDao();
//리스트 가지고오기
List<SsemiDto> list = dao.getallempo();
%>
</head>
<body>
		<h2 class="animate__animated animate__backInUp">예약 확인</h2>
	<div class="tb animate__animated animate__backInUp">
		<div id="listcount" class="animate__animated animate__fadeIn "><%=list.size()==0?"예약자가 없습니다.":"총 "+list.size()+"명의 예약자가 있습니다." %></div>
		<table class="empotable">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>날짜</th>
			<th>전화번호</th>
			<th>예약변경/삭제</th>
		</tr>
		<%for(SsemiDto dto:list) {%>
		<tr>
			<td><%=dto.getNum() %></td>
			<td><%=dto.getName() %></td>
			<td><%=Integer.toString(dto.getBirthyear()).replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3") %></td>
			<td><%=dto.getEmpoday() %></td>
			<td>0<%=Integer.toString(dto.getPhone()).replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-$2-$3") %></td>
			<td>
			<button class="btn btn-primary" id="btnU" onclick="update(<%=dto.getNum()%>)">예약변경</button>
			<button type="button"class="btn btn-danger" id="btnD" onclick ="del(<%=dto.getNum()%>)">삭제</button>
			</td>
		</tr>
		<%} %>
		</table>
	<button class="btn btn-danger" id="btnC">메인으로</button>
	</div>
</body>
<script type="text/javascript">
	function del(num) {
		let b = confirm("정말 삭제하시겠습니까?");
		if(b){
			alert("삭제되었습니다.");
			location.href="deleteempoaction.jsp?num=" + num;
		}else{
			alert("삭제를 취소했습니다.");
		}
	}
	function update(num) {
		let b = confirm("수정하시겠습니까?");
		if(b){
			$(".animate__animated").addClass("animate__zoomOut");
			setTimeout(() => {		
			location.href="updateempo.jsp?num=" + num;
			}, 1100);
			setTimeout(() => {
				$(".animate__animated").removeClass("animate__zoomOut");
			}, 1200);
		}
	}
	
	$("#btnC").click(function() {
		$(".animate__animated").addClass("animate__zoomOut");
		setTimeout(() => {
		location.href="main.jsp";			
		}, 1100);
		setTimeout(() => {
			$(".animate__animated").removeClass("animate__zoomOut");
		}, 1200);
	});
</script>
</html>