<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</style>
</head>
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

<body>
 <div style="margin: 100px 100px">
 	<form action="loginaction.jsp" method="post">
 		<table class = "table table-borded" style="whdth: 300px">
 			<tr>
 				<td colspan="2" align="center">
 				<!-- 체크후 로그인을 했을경우 b가 true값이므로 체크속성추가 -->
 					<label><input type="checkbox" name="chksave"
 					<%=b?"checked":"" %>>아이디 저장</label>
 				</td>
 			</tr>
 			<tr>
 				<th bgcolor="lightgray" width="100">아이디</th>
 				<td>
 					<input type="text" name = "id" class="form-control" value="<%=loginid %>">
 				</td>
 			</tr>
 			<tr>
 				<th bgcolor="lightgray" width="100">비밀번호</th>
 				<td>
 					<input type="password" name = "pass" class="form-control">
 				</td>
 			</tr>
 			<tr>
 				<td colspan="2" align="center">
 					<label><button type="submit" class = "btn btn-secondary">세션 로그인</button></label>
 				</td>
 			</tr>
 			
 		</table>
 	</form>
 </div>
</body>
</html>