<%@page import="study.dao.MyCarDao"%>
<%@page import="study.dto.MyCarDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style type="text/css">
body, body * {
	font-family: 'Jua'
}
</style>
<%
//파라미터값 얻기
int num = Integer.parseInt(request.getParameter("num"));
//dto선언
MyCarDao dao = new MyCarDao();
//dao선언
MyCarDto dto = dao.getData(num);
%>
</head>
<body>
	<h4 class="alert alert-info" style="width: 400px">Mysql mycar
		데이터수정</h4>
	<form action="mycarupdateaction.jsp" method="post">
		<!-- hidden -->
		<input type="hidden" name="num" value="<%=dto.getNum()%>">
		<table class="table table-bordered" style="width: 400px">
			<tr>
				<th bgcolor="lightgray" width="100">차종</th>
				<td><input type="text" name=carname required="required"
					class="form-control" placeholder="차종 입력"
					value="<%=dto.getCarname()%>"></td>
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">차량 가격</th>
				<td><input type="number" name=carprice required="required"
					class="form-control" placeholder="차량 가격" value="<%=dto.getCarprice()%>"></td>
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">구입 년도</th>
				<td><input type="date" name="buyday"
					style="width: 282px" value="<%=dto.getBuyday()%>"></td>
					
			</tr>
			<tr>
				<th bgcolor="lightgray" width="100">차량 사진</th>
				<td>
					<div class="input-group">
						<select class="form-select" style="width: 200px" name="carphoto"
							id="carphoto">
							<%
							for (int i = 1; i <= 15; i++) {
								String s = "car" + i +".png";
							%>
							<option value="car<%=i%>.png" <%=s.equals(dto.getCarphoto())?"selected":""%>><%=i%>번 사진
							</option>
							<%
							}
							%>
						</select>
					</div>
				</td>
			</tr>
		</table>
		<button type="submit" class="btn btn-success"
			style="position: absolute; width: 400px">데이터 수정</button>
	</form>
	<img alt="" src="../image/mycarimage/<%=dto.getCarphoto() %>" id="photoview"
		width="200" border="1"
		style="position: absolute; left: 403px; top: 80px">



	<script type="text/javascript">
		//사진을 선택하면 해당 사진으로 바뀌도록 해보세요

		$("#carphoto").change(
				function() {
					$("#photoview").attr("src",
							"../image/mycarimage/" + $(this).val());
				});
		$("#carphoto").click(
				function() {
					let modal_photo_src = $(this).attr("src");
					let modal_title_name = $(this).parent().siblings("td")
							.eq(1).text();
					$("img.modal_photo").attr("src", modal_photo_src);
				});
		$("#date").change(function() {
			alert(date.value);
		});
	</script>
</body>
</html>