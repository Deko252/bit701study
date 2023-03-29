<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인</title>
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
		color: white;
		background-image: url("image/star.jpg");
		overflow:hidden;	
	}
	#login{
		border: solid 1px white; 	
		width: 700px;
		height: 450px;
		margin-left: 600px;
		margin-top:250px;
		text-align: center;
		border-radius: 20px;
		padding-top: 100px;
		padding-bottom: 30px;
		background-color: rgba(255,255,255,0.5);
		color: black;
	}
	div input {
		width: 200px;
	}
	#inputck{
		width: 30px;
	}
	.inputsize{
		width: 300px;
		margin-left: 180px;
		padding-top: 10px;
	}
	#btnS{
		margin-top: 35px;
	}
	#btnC{
		margin-top: 35px;
	}
	#inputid{
		border-radius: 5px;
	}
	#inputpw{
		border-radius: 5px;
	}
	#inputpwid{
		height: 30px;
	}
</style>
<%
	String chksave = (String)session.getAttribute("chksave");
	String loginid = (String)session.getAttribute("loginid");
	boolean b;
	//chksave가 한번도 세션에 저장된적이 없을경우 null값이 나온다
	//체크후 로그인을 했다면 yes or no
	if(chksave == null || chksave.equals("no")){
		b=false;
		loginid="";
	}else{
		b = true;
	}
%>
</head>
<body>
	<div class="animate__animated animate__zoomIn"id="login">
<form action="loginaction.jsp" method="post">
		<h2>로그인</h2>
		<div class="inputsize">
			ID :　<input type="text" id="inputid" autofocus name = "id" value="<%=loginid %>">
		</div>
		<div class="inputsize">
			PW : <input type="password" id="inputpw" name = "pass" >
		</div>
		<div class="inputsize">
		<!-- 체크후 로그인을 했을경우 b가 true값이므로 체크속성추가 -->
 		<label><input type="checkbox" name="chksave" id="inputck"
 		<%=b?"checked":"" %>>아이디 저장</label>
 		</div >
 		<div id="inputidpw">
		<button class="btn btn-success" id="btnS" onclick="location.href='loginaction.jsp'">로그인</button>
		<button class="btn btn-danger" id="btnC" type="button">취소</button>
		</div>
</form>
	</div>
</body>

<script type="text/javascript">
	$("#btnC").click(function() {
		$("#login").addClass("animate__animated animate__zoomOut");
		setTimeout(() => {
		location.href="main.jsp";			
		}, 420);
		setTimeout(() => {
			$("#login").removeClass("animate__animated animate__zoomOut");
		}, 840);
		
	});

</script>
</html>