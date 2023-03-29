<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>진료기록 추가</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
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

h2{
	color: white;
}
#fullsize{
	width: 50%;
	height: 50%;
	left: 10%;
	top: 50px;
	position: absolute;
}

#showimg{
	top: 250px;
	left: 62%;
	position: absolute;
}
.animate__backInUp{
	 	animation-duration: 2.3s; /* don't forget to set a duration! */
}
.animate__backOutUp{
	 	animation-duration: 2s; /* don't forget to set a duration! */
	}
</style>
</head>
<body>
	<div style="margon: 30px 50px" class="animate__animated animate__backInUp">
		<!-- 이미지 출력할곳 -->
		<img id="showimg"
			style="max-width: 580px;">
			
		<form action="cklistaction.jsp" method="post" id="fullsize"
			enctype="multipart/form-data">
			<table class="table table-bordered" >
				<caption align='top'>
					<h2>진료기록 작성</h2>
				</caption>
				<tr>
					<th style="background-color: #ddd" width="100">환자 이름</th>
					<td><input type="text" name="name" class="form-control" placeholder="환자이름을 입력해 주세요."
						style="width: 200px;" autofocus="autofocus" required="required">
					</td>
				</tr>
				<tr>
					<th style="background-color: #ddd" width="100">생년월일</th>
					<td><input type="number" name="birthyear" class="form-control" placeholder="생년월일을 입력해 주세요. Ex)19870605" maxlength="8" oninput="numberMaxLength(this);"
						required="required" style="width: 200px;"></td>
				</tr>
				<tr>
					<th style="background-color: #ddd" width="100">전화번호</th>
					<td><input type="number" name="phone" class="form-control" placeholder="-를 빼고 입력해 주세요." maxlength="11" oninput="numberMaxLength(this);"
						required="required" style="width: 200px;"></td>
				</tr>
				<tr>
					<th style="background-color: #ddd" width="100">병명</th>
					<td><input type="text" name="law" class="form-control" placeholder="병명을 입력해 주세요."
						required="required" style="width: 300px;"></td>
				</tr>
				<tr>
					<th style="background-color: #ddd" width="100">사진(1장)</th>
					<td><input type="file" name="upload" class="form-control" id="myfile">
					</td>
				</tr>
				<tr>
					<td colspan="2"><textarea style="width: 100%; height: 450px;"
							name="content" required="required" placeholder="진료 기록을 작성해주세요"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-secondary btn-sm">진료기록
							작성</button>
						<button type="button" class="btn btn-secondary btn-sm"
							 id="btnC">이전으로</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
<script type="text/javascript">
 	$("#myfile").change(function(){
  		console.log("1:"+$(this)[0].files.length);
  		console.log("2:"+$(this)[0].files[0]);
  	//정규표현식
	var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
	var f=$(this)[0].files[0];//현재 선택한 파일
	if(!f.type.match(reg)){
  	 	alert("확장자가 이미지파일이 아닙니다");
   		 return;
	}
  	if($(this)[0].files[0]){
   		var reader=new FileReader();
   		reader.onload=function(e){
    		$("#showimg").attr("src",e.target.result);
   		}
   reader.readAsDataURL($(this)[0].files[0]);
  }
 });
 	
 function numberMaxLength(e){
 	   if(e.value.length > e.maxLength){
 	       e.value = e.value.slice(0, e.maxLength);
 	   }
 }

 $("#btnC").click(function() {
	 	$(".animate__animated").removeClass("animate__backInUp");
		$(".animate__animated").addClass("animate__backOutUp");
		setTimeout(() => {
		location.href="cklist.jsp";			
		}, 1500);
		setTimeout(() => {
			$(".animate__animated").removeClass("animate__backOutUp");
			$(".animate__animated").addClass("animate__backInUp");
		}, 1600);
	});
</script>
</body>
</html>