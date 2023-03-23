<%@page import="java.util.Date"%>
<%@page import="study.dto.PersonDto"%>
<%@page import="study.dao.PersonDao"%>
<%@page import="java.util.List"%>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
	body, body * {
		font-family: 'Jua'
	}
</style>
</head>
<%
	PersonDao dao = new PersonDao();
	List<PersonDto> list = dao.getAllPersons();
%>
<body>
<!-- Modal -->
<div class="modal fade" id="personmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="persontitle">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <img alt="" src="" class="personphoto">
        <br>
        <h3 class="personage"><b>제품제목..</b></h3>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	<a href="personform.jsp">멤버추가</a>
	<hr>
	<h3 class="alert alert-danger" style="width : 700px">
		<b>총 <%=list.size()%>명의 멤버가 있습니다</b>
	</h3>
	
	<table class="table table-bordered" style="width : 700px">
		<tr bgcolor = "lightgray">
			<th width="50">번호</th>
			<th width="110">이름</th>
			<th width="90">나이</th>
			<th width="100">주소</th>
			<th width="70">직업</th>
			<th width="100">수정/삭제</th>
		</tr>
		
		<%
			int n=1;
			Date date = new Date();
			int currYear = date.getYear()+1900;
			for(PersonDto dto:list){
				int age = currYear - dto.getBirthyear();
		%>
		<tr>
			<td align="center"><%=n++ %></td>
			<td>
				<img alt="" src="../image/moviestar/<%=dto.getPhoto() %>"
				width="30" border="1" hspace="10" class="photo"
				data-bs-toggle="modal" data-bs-target="#personmodal">
				<b><%=dto.getName() %></b>
			</td>
			<td>
				<%=age %>세(<%=dto.getBirthyear() %>년생)
			</td>
			<td><%=dto.getAddress() %></td>
			<td><%=dto.getJob() %></td>
			<td>
				<button type = "button" class = "btn btn-success btn-sm"
				onclick = "location.href = 'personupdateform.jsp?num=<%=dto.getNum() %>'">수정</button>
				<%-- <button type = "button" class = "btn btn-danger btn-sm"
				onclick = "location.href = 'deletePerson.jsp?num=<%=dto.getNum() %>'">삭제</button> --%>
				
				<button type = "button" class = "btn btn-danger btn-sm"
				onclick = "del(<%=dto.getNum() %>)">삭제</button>
			</td>
		</tr>
			<%}%>
		
	</table>
	<script type="text/javascript">
		function del(num) {
			//alert(num);
			let b = confirm("정말 삭제 하시겠습니까?");
			if(b){
				location.href = "deletePerson.jsp?num=" + num;
			}
		}
		$("img.photo").click(function(){
			let personphoto = $(this).attr("src");
			$("img.personphoto").attr("src", personphoto);
			let persontitle = $(this).next().text();
			$("#persontitle").text(persontitle);
			let personage = $(this).parent().next().text();
			$(".personage b").text(personage);
		});
	</script>
	
	
</body>
</html>