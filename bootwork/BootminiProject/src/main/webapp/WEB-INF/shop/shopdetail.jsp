<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ include file="../commonaver.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body, body *{
		font-family: 'Jua'
	}
	.detailimg{
		max-width: 500px;
	}
	.table {
		max-width: 500px;
		margin-left: 100px;
	}
	.update-photo:hover{
		cursor: pointer;
	}
</style>
</head>
<body>
	<span style="float: right">
		
	</span>
	<table class="table table-bordered">
	<tr style="background-color: #ddd">
	</tr>
		<tr>
			<td align="center">
				<%-- <img class="detailimg" alt="" src="https://kr.object.ncloudstorage.com/bit701-bucket-114/shop/${dto.photo }"> --%><!-- 내꺼 -->
				<img class="detailimg" alt="" src="https://${imageUrl }/shop/${dto.photo }"><!-- 선생님꺼 -->
			</td>
		</tr>
		<tr>
			<td>
				<b style="text-align: center;">${dto.sangpum }</b>
			</td>
		</tr>
		<tr>
			<td style="text-align: center; background-color: ${dto.color }">${dto.color }
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				<fmt:formatNumber value="${dto.price }" type="currency" currencySymbol="￦" minFractionDigits="0"></fmt:formatNumber>
			</td>
		</tr>
		<tr>
			<td>
				<fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value="${dto.ipgoday}"/>
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" class="btn btn-sm btn-outline-success" data-bs-toggle="modal" data-bs-target="#myPhotoModal">사진수정</button>
				<button type="button" class="btn btn-sm btn-outline-info"data-bs-toggle="modal" data-bs-target="#myShopModal">내용수정</button>
				<button type="button" class="btn btn-sm btn-outline-danger" id="delshop">삭제</button>
				<button type="button" class="btn btn-sm btn-outline-primary"
				onclick="history.back(-1)">돌아가기</button>
			</td>
		</tr>
</table>

<script type="text/javascript">
	$("#delshop").click(function() {
		let a =confirm("삭제하려면 확인을 눌러주세요");
		if(a){
			location.href='./delete?num=' + ${dto.num };
		}
	});
</script>

<!-- 사진변경 모달 -->

<!-- The Modal -->
<div class="modal" id="myPhotoModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">사진 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<img id="modalphoto" src="http://${imageUrl_small }/shop/${dto.photo }?type=f&w=160&h=160&faceopt=true&ttype=jpg" border="5" style="border-radius: 50px; border-color: gray;">
      
      <!-- 카메라 모양 -->
  		<i class="bi bi-camera-fill update-photo" style="position: absolute; left: 195px; top: 145px; font-size: 22px;"></i>    
      <!-- 파일업로드 태그 -->
      	<input type="file" id="photoupload" style="display: none;">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="location.reload()">Apply</button>
      </div>

    </div>
  </div>
</div>
<script type="text/javascript">
	$(".update-photo").click(function() {
		$("#photoupload").trigger("click");
	});
	
	$("#photoupload").change(function() {
		let form = new FormData();
		form.append("upload",$("#photoupload")[0].files[0]);//선택한 한개의 파일만 업로드
		form.append("num",${dto.num })
		
		$.ajax({
			type:"post",
			dataType:"text",
			url:"./photochange",
			data:form,
			processData:false,
			contentType:false,
			success:function(res){
				let src=`http://zxdpdthcmjxj16981873.cdn.ntruss.com/shop/\${res }?type=f&w=160&h=160&faceopt=true&ttype=jpg`;
				$("#modalphoto").attr("src",src);
			}
		});
		
	});
</script>

<!-- 내용변경 모달 -->

<!-- The Modal -->
<div class="modal" id="myShopModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header" style="width: 500px">
        <h4 class="modal-title">상품정보 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" style="width: 500px">
       	<img id="modalphoto" src="http://${imageUrl_small }/shop/${dto.photo }?type=f&w=160&h=160&faceopt=true&ttype=jpg" border="2" style="border-radius: 100px; border-color: gray;">
		<br>
		<br>
		<form id="updateform">
		<input type="hidden" name="num" value="${dto.num }">
		<table style="width: 465px">
			<tr>
				<th style="width: 100px; background-color: #ddd; border-radius: 5px;">상품명</th>
				<td>
					<input type="text" class="form-control" name="sangpum" required="required" value="${dto.sangpum }">
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: #ddd; border-radius: 5px">색상</th>
				<td>
					<input type="color" class="form-control" name="color" value="${dto.color }">
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: #ddd; border-radius: 5px">가격</th>
				<td>
					<input type="number" class="form-control" name="price" min="1000" max="9999999" step="100" value="${dto.price }">
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: #ddd; border-radius: 5px">갯수</th>
				<td>
					<input type="number" class="form-control" name="cnt" min="1" max="10" step="1" value="1">
				</td>
			</tr>
		</table>
	</form>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="btnupdate">Apply</button>
      </div>

    </div>
  </div>
</div>
</div>
<script type="text/javascript">
	$("#btnupdate").click(function() {
		let data=$("#updateform").serialize();
		//alert(data);
		$.ajax({
			type:"get",
			dataType:"text",
			url:"./update",
			data:data,
			success:function(res){
				
			}
		});
	});
</script>
</body>
</html>
