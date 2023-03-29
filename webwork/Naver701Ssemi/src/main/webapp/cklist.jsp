<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.SsemiDao2"%>
<%@page import="java.util.List"%>
<%@page import="dto.SsemiDto2"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>진료기록</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<style type="text/css">
body, body * {
	font-family: 'Jua'
}

body {
	background-image: url("image/star.jpg");
	color: white;
	overflow:hidden;
}

table th {
	border: 1px solid white;
	background-color: rgba(255, 255, 255, 0.5);
	color: black;
	text-align: center;
}

table tr td {
	border: 1px solid white;
	font-size: 30px;
	width: 15.5%;
	height: 5%;
	text-align: center;
}

h2 {
	position: absolute;
	width: 100%;
	text-align: center;
	font-size: 50px;
	margin-top: 20px;
}

div.tb {
	position: relative;
}

table.empotable {
	position: absolute;
	top: 50%;
	left: 12%;
	right: 10%;
	margin-top: 150px;
}

#btnC {
	margin-top: 20px;
	margin-left: 20px;
	font-size: 25px;
	position: absolute;
}

#btnin {
	margin-top: 20px;
	margin-left: 130px;
	font-size: 25px;
	position: absolute;
}

.animate__backInUp {
	animation-duration: 2.7s; /* don't forget to set a duration! */
}
</style>
<%
//dao 선언
SsemiDao2 dao = new SsemiDao2();
//리스트 가지고오기
List<SsemiDto2> list = dao.getallcklist();
%>
</head>
<body>
	<h2 class="animate__animated animate__backInUp">진료기록</h2>
	<div class="tb animate__animated animate__backInUp">
		<table class="empotable">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>병명</th>
				<th>진료날짜</th>
				<th>전화번호</th>
				<th>자세히보기</th>
			</tr>
			<%
			for (SsemiDto2 dto : list) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH시");
			%>
			<tr>
				<td id="number"><%=dto.getNum()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getLaw()%></td>
				<td><%=Integer.toString(dto.getBirthyear()).replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3")%></td>
				<td><%=sdf.format(dto.getWriteday())%></td>
				<td>0<%=Integer.toString(dto.getPhone()).replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-$2-$3")%></td>
				<td>
					<button class="btn btn-primary" id="btnU" onclick ="insert(<%=dto.getNum()%>)" type="button">자세히보기</button>
				</td>

			</tr>
			<%
			}
			%>
		</table>
		<button class="btn btn-success" id="btnin"
			>진료기록 추가</button>
		<button class="btn btn-danger" id="btnC">메인으로</button>
	</div>
</body>
<script type="text/javascript">
$("#btnC").click(function() {
	$(".animate__animated").addClass("animate__zoomOut");
	setTimeout(() => {
	location.href="main.jsp";			
	}, 1100);
	setTimeout(() => {
		$(".animate__animated").removeClass("animate__zoomOut");
	}, 1200);
});
function insert(num) {
	$(".animate__animated").addClass("animate__backOutUp");
	setTimeout(() => {
	location.href="cklistdetail2.jsp?num="+num;			
	}, 1100);
	setTimeout(() => {
		$(".animate__animated").removeClass("animate__backOutUp");
	}, 1200);
}

$("#btnin").click(function() {
	$(".animate__animated").addClass("animate__backOutUp");
	setTimeout(() => {
	location.href="cklistdetail.jsp";			
	}, 1100);
	setTimeout(() => {
		$(".animate__animated").removeClass("animate__backOutUp");
	}, 1200);
});
</script>
</html>