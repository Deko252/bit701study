<%@page import="study.dto.MyCarDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.MyCarDao"%>
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
	MyCarDao dao = new MyCarDao();
	List<MyCarDto> list = dao.getAllCars();
%>
<body>
<!-- The Modal -->
    <div class="modal" id="mycarModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title" id="modalname">차량 상세보기</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <img alt="여기는 사진" src="" class="modal_photo" style="width: 90%;">
                    <br>
                    <h3 class="modal_title"><b>제품제목..</b></h3>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>
	<a href="mycarform.jsp">차량 추가</a>
	<hr>
	<h3 class="alert alert-danger" style="width : 700px">
		<b>총 <%=list.size()%>대의 차량이 있습니다</b>
	</h3>
	
	<table class="table table-bordered" style="width : 700px">
		<tr bgcolor = "lightgray">
			<th width="50">번호</th>
			<th width="110">차종</th>
			<th width="90">차량 가격</th>
			<th width="100">구입 년도</th>
			<th width="100">삭제</th>
		</tr>
		
		<%
			int n=1;
			for(MyCarDto dto:list){
				
		%>
		<tr>
			<td align="center" style="text-align: center; line-height: 115.94px"><%=n++ %></td>
			<td id = "modal">
				<img alt="" src="../image/mycarimage/<%=dto.getCarphoto() %>"
				width="150px" border="1" hspace="10" class="photo" id="carphoto"
				 data-bs-toggle="modal" data-bs-target="#mycarModal">

				<b style="text-align: center; line-height: 115.94px"><%=dto.getCarname() %></b>
			</td>
			<td style="text-align: center; line-height: 115.94px">
				<%=dto.getCarprice() %>원
			</td>
			<td style="text-align: center; line-height: 115.94px"><%=dto.getBuyday() %></td>
			<td style="text-align: center; line-height: 115.94px;" >
				<button type = "button" class = "btn btn-success btn-sm"
				onclick = "location.href = 'mycarupdateform.jsp?num=<%=dto.getNum() %>'">수정</button>
				<%-- <button type = "button" class = "btn btn-danger btn-sm"
				onclick = "location.href = 'deletePerson.jsp?num=<%=dto.getNum() %>'">삭제</button> --%>
				
				<button  type = "button" class = "btn btn-danger btn-sm"
				onclick = "del(<%=dto.getNum() %>)" >삭제</button>
			</td>
		</tr>
			<%}%>
		
	</table>

	 
	<script type="text/javascript">
		function del(num) {
			//alert(num);
			let b = confirm("정말 삭제 하시겠습니까?");
			if(b){
				location.href = "deletecar.jsp?num=" + num;
			}
		}
		$(function(){
            $("img.photo").click(function(){
                let modal_photo_src = $(this).attr("src");
                let modal_title_name = $(this).next().text();
                let modal_title_price = $(this).parent().siblings("td").eq(1).text();
                $(".modal_photo").attr("src", modal_photo_src);
                $("#modalname").text(modal_title_name + " 상세보기");
                $("h3.modal_title b").text(modal_title_price);
            });
        });
	</script>
</body>
</html>