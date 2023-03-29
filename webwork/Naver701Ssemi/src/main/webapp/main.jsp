<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>어서오세요</title>
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
		font-family: 'Jua';
	}
	body{
		background-image: url("image/star.jpg");	
		overflow:hidden;
	}
	#title{
		margin-top:50px;
		margin-left: 150px;
		position: absolute;
		width: 200px;
	}
	#logininfo{
		position: absolute;
		color: white;
		width: 300px;
		font-size: 30px;
		margin-left: 800px;
		margin-top: 15px;
	}
	h5{
		color: white;
		margin-top:250px;
		margin-left: 180px;
		position: absolute;
	}
	.btnlist{		
		margin-left: 600px;
		margin-top:50px;
		position: absolute;
	}
	#login{
		margin-left:45%;
		margin-top:450px;
		position: absolute;
		font-size: 100px;
		color: white;
	}
	#login:hover{
		font-size: 100px;
		color: gray;
		cursor: pointer;
	}
	
	#logout{
		margin-left:45%;
		margin-top:450px;
		position: absolute;
		font-size: 100px;
		color: white;
	}
	#logout:hover{
		font-size: 100px;
		color: gray;
		cursor: pointer;
	}
	.nav-item {
	font-weight: 100 !important;
	font-size: 50px !important;
	cursor: pointer;
	color: white;
	float: left;
	padding-right: 100px;
	}
	.nav-item:hover {
	color: gray;
	}
	
	.animate__backOutUp{
		animation-duration: 1.4s; /* don't forget to set a duration! */
	}
	
</style>
<%
		//세션에 저장되어 있는 아이디를 얻는다
		String loginid = (String) session.getAttribute("loginid");
		String loginstate=(String)session.getAttribute("loginstate");
%>
</head>
<body>
	<a href="main.jsp" id="titleA"><img class="animate__animated animate__zoomIn"id="title" src="image/2211744.png"><h5 class="animate__animated animate__zoomIn">Space_Hospital</h5></a>
	<div class="btnlist animate__animated animate__zoomIn">
	<a id="btn1"  class="nav-item nav-link active ">예약하기</a>
	<a id="btn2" class="nav-item nav-link active ">예약확인</a>
	<a id="btn3" class="nav-item nav-link active ">진료기록</a>
	<%if(loginstate != null){%>
	<div id="logininfo"><%=loginid %>님 반갑습니다</div>
	<%}%>
	</div>
	<%if(loginstate == null){%>
		<a id="login" class="animate__animated animate__zoomIn">L̬̪̭̻̐̿̒͋͊̏̾̚͟͜ͅó̷̢̨͖̮̣̺̯̩̠̓̾̅̈g̶̢͙͔͍̩̣̺̊̇̑̅͒́̈́ḯ̧̧͙̲̫̒͑͂̒͜͠ń̢͉͙̀̅̀̀͢͟͠</a>
	<%}else{%>
		<a id="logout" class="animate__animated animate__zoomIn" onclick="location.href='logoutaction.jsp'">L̛͙͍͚̝̹̼͈̳͉̂́̔̊̇̒͘͢͝ǫ̵̢͔̱̰̖̈́̑̐̃̔̑͝͝g̵̡͔̪̟̖̮̖̋̿͗̒̓͑̋̚ơ̴̧̤̝̞̞̟̘̻͕̎͆͂͐͜͝ų̢͔̥̲̬̲̅̍͒͒̔ţ̥̻̘̳͇̬̮̟͊̐̅̇͛̕͢</a>
	<%}%>
</body>

<script type="text/javascript">
	$("#login").click(function() {
		$(".animate__animated").addClass("animate__animated animate__zoomOut");
		setTimeout(() => {
		location.href="login.jsp";			
		}, 400);
		setTimeout(() => {
			$(".animate__animated").removeClass("animate__animated animate__zoomOut");
		}, 860);
	});
	
	$("#btn1").click(function() {
		$(".animate__animated").removeClass("animate__zoomIn");
		$(".animate__animated").addClass("animate__backOutUp");
		setTimeout(() => {
		location.href="empo.jsp";			
		}, 1200);
		setTimeout(() => {
			$(".animate__animated").removeClass("animate__backOutUp");
			$(".animate__animated").addClass("animate__zoomIn");
		}, 2000);
	});
	
	$("#btn2").click(function() {
		$(".animate__animated").removeClass("animate__zoomIn");
		$(".animate__animated").addClass("animate__backOutUp");
		setTimeout(() => {
		location.href="empock.jsp";			
		}, 1200);
		setTimeout(() => {
			$(".animate__animated").removeClass("animate__backOutUp");
			$(".animate__animated").addClass("animate__zoomIn");
		}, 2000);
	});
	
	$("#btn3").click(function() {
		$(".animate__animated").removeClass("animate__zoomIn");
		$(".animate__animated").addClass("animate__backOutUp");
		setTimeout(() => {
		location.href="cklist.jsp";			
		}, 1200);
		setTimeout(() => {
			$(".animate__animated").removeClass("animate__backOutUp");
			$(".animate__animated").addClass("animate__zoomIn");
		}, 2000);
	});
</script>
</html>