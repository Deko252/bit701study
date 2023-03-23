<%@page import="java.util.Date"%>
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
<body>
<h4 class = "alert alert-info" style="width :400px">Mysql person 데이터추가</h4>
<form action= "addaction.jsp" method="post">
		<table class = "table table-bordered" style="width:400px">
			<tr>
				<th bgcolor="lightgray" width="100">이 름</th>
				<td>
					<input type="text" name="name" required="required"
					class="form-control" placeholder="사원명 입력">
				</td>
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">태어난 년도</th>
				<td>
				<select class = "form-select" name = "birthyear">
					<%
						Date date = new Date();
						int currYear = date.getYear()+1900;
						
						for(int i=currYear;i > 1800;i--){%>
						<option value="<%=i %>"><%=i %>년생</option>
						<%}
					%>
				</select>
				</td>
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">주소</th>
				<td>
					<input type="text" name="address" class="form-control">
				</td>
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">직업</th>
				<td>
					<select class="form-select" name="job">
					<%
						String[] job = {"공무원","회사원","영화배우","가수","개발자","교사"};
					
						for(String j:job){%>
							<option value="<%=j %>"><%=j %></option>
						<%}
					%>
				</td>
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">사 진</th>
				<td>
				<div class="input-group">
					<select class = "form-select" style="width : 200px" name="photo" id="photo">
					<%for(int i=1; i<=20; i++) {%>
						<option value="<%=i %>.jpg"><%=i %>번 사진</option>	
					<%}%>
					</select>
					</div>
				</td>
			</tr>
		</table>
		<button type="submit" class = "btn btn-success"  style="position: absolute; width: 400px">서버에 전송</button>	
	</form>
	<img alt="" src="../image/moviestar/1.jpg" id="photoview" width="200"
	border="1" style="position: absolute;left:403px;top:100px">
	<script type="text/javascript">
		//사진을 선택하면 해당 사진으로 바뀌도록 해보세요
		$("#photo").change(function(){
			$("#photoview").attr("src","../image/moviestar/" + $(this).val());
		});
	</script>
</body>
</html>