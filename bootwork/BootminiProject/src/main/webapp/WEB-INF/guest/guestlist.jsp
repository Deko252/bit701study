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
	
	.small_photo{
		border: 5px solid pink;
		border-radius: 30px;
		margin-right: 10px;
		cursor: pointer;
	}
	.today{
		float: right;
		color:#ccc;
		font-size: 14px;
		margin-right: 10px;
	}
	div.guest_box{
		width: 750px;
		border: 1px solid gray;
		margin-bottom: 20px;
		padding: 10px 20px;
	}
	div.guest_box>div{
		margin-bottom: 10px;
	}
	
	.photodel{
		cursor: pointer;
		font-size: 0.8em;
		position: relative;
		left: -15px;
		top: -35px;
		color: red;
		visibility: hidden;
	}
	.photo_del_box{
		height: 90px;
		display: inline-block;
	}
	#del_guest{
		margin-left: 650px;
		position: relative;
	}
	.guestdel{
		cursor: pointer;
		color: red;
	}
</style>
<script type="text/javascript">
	$(function() {
		list();
		
		/* //사진업로드
		$("#photoupload").change(function() {
			let cnt=$(this)[0].files.length;
			if(cnt > 3){
				alert("사진은 3개 까지만 가능합니다.");
				return false;
			}
			var form=new FormData();
			for (i=0; i<$(this)[0].files.length; i++){
				form.append("upload",$(this)[0].files[i]);//선택한 사진 모두 추가
			}
			
			$.ajax({
				type:"post",
				dataType:"text",
				url:"upload",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					
				}
			});
			
		});
		
		$("#guestadd").click(function(){
			let content=$("#content").val();
			let nn = $("#nickname").val();
			console.log(content);
			$.ajax({
				type:"post",
				dataType:"text",
				url:"./insert",
				data:{"content":content,"nickname":nn},
				success:function(res){
					//입력값 초기화
					$("#nickname").val("");
					$("#content").val("");
					$("#photoupload").val("");
					//목록다시호출
					list();
				}
			});
			
		}); */
		//업로드한 사진들과 데이터를 묶어서 서버에 전송하기
		$("#guestadd").click(function(){
			let cnt=$("#photoupload")[0].files.length;
			let content=$("#content").val();
			let nn = $("#nickname").val();
			if(nn.length == 0){
				alert("닉네임을 입력해 주세요.");
				return false;
			}
			if(content.length == 0){
				alert("내용을 입력해주세요.");
				return false;
			}
			
			var form=new FormData();
			for (i=0; i<$("#photoupload")[0].files.length; i++){
				form.append("upload",$("#photoupload")[0].files[i]);//선택한 사진 모두 추가
			}
			form.append("content",content);
			form.append("nickname",nn);		
			
			$.ajax({
				type:"post",
				dataType:"text",
				url:"./insert",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					//입력값 초기화
					$("#nickname").val("");
					$("#content").val("");
					$("#photoupload").val("");
					//목록다시호출
					list();
				}
			});
		});
		
		//이미지 이벤트
		$(document).on("mouseover",".photo_del_box",function(){
			$(this).children(".photodel").css("visibility","visible");
		});
		
		$(document).on("mouseout",".photo_del_box",function(){
			$(this).children(".photodel").css("visibility","hidden");
		});
		
		
		//x아이콘 이벤트
		$(document).on("click",".photodel",function(){
			
			let b = confirm("해당 사진을 삭제하시겠습니까?")
			if(b){
				let photo_idx = $(this).attr("photo_idx");
				//alert(photo_idx);
				$.ajax({
					type:"get",
					url:"./deletephoto",
					data:{"photo_idx":photo_idx },
					dataType:"text",
					success:function(){
						alert("삭제되었습니다.");
						//목록다시호출
						list();
					}
				});
			}
		});
		
		//방명록 삭제 이벤트
		$(document).on("click",".guestdel",function(){			
			let b = confirm("해당 방명록을 삭제하시겠습니까?")
			if(b){
				let guest_idx = $(this).attr("guest_idx");
				//alert(photo_idx);
				$.ajax({
					type:"get",
					url:"./delete",
					data:{"guest_idx":guest_idx },
					dataType:"text",
					success:function(){
						alert("삭제되었습니다.");
						//목록다시호출
						list();
					}
				});
			}
		});
		
		
	});//$function close
		function list() {
			$.ajax({
				type:"get",
				url:"./alist",
				dataType:"json",
				success:function(res){
					let s="";
					$.each(res,function(idx,ele){
						s+=
							`<div class='guest_box'>
								<div>
									<b>\${ele.nickname }</b>
									<span class='today'>\${ele.writeday }
									&nbsp;
									<i class="bi bi-trash3 guestdel" guest_idx="\${ele.guest_idx }"></i>
									<br>
									</span>
								</div>
									<span class='content'>\${ele.content }</span>
							
							`;
						
						//각 방명록에 추가한 사진
						s+="<div class='photo_box'>";
						$.each(ele.photolist, function(pidx,pele) {
							s +=`
							<span class="photo_del_box">
								<img src="http://${imageUrl_small }/guest/\${pele.photoname}?type=f&w=80&h=80&faceopt=true&ttype=jpg"
									id="small_photo" class="small_photo" data-bs-toggle="modal" data-bs-target="#guestPhotoModal" onclick="guestPhoto('\${pele.photoname}')">
								<i class="bi bi-x-square photodel" photo_idx="\${pele.photo_idx }"></i>
							</span>
								`;
						});

						s+="</div>";
						s+="</div>";
					});
					$("div.alist").html(s);
				}
			});
		}
		function guestPhoto(photoname) {
			//alert(photoname);
			let src = "https://${imageUrl }/guest/" + photoname;
			$("#modalphoto").attr("src",src);
		}
		/* $(document).on("click","#small_photo",function(){
			let src = $(this).attr("src");
			$("#modalphoto").attr("src",src);
		}); */
</script>
</head>
<body>

<!-- The Modal -->
<div class="modal" id="guestPhotoModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">원본 사진</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<img id="modalphoto" src="" border="5" style="max-width: 100%;">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="location.reload()">닫기</button>
      </div>

    </div>
  </div>
</div>


	<div style="width: 500px;">
		<input id="nickname" type="text" class="form-control" style="width: 40%;" placeholder="닉네임을 입력하세요.">
		<textarea rows="" cols="" style="width: 750px; height: 100px;" class="form-control" id="content"></textarea>
		<input type="file" id="photoupload" multiple="multiple">
		<button type="button" class="btn btn-sm btn-outline-success" id="guestadd" style="width: 750px;">등록</button>
	</div>
	
	<br>
	<div class="alist">
		
	</div>
</body>
</html>
