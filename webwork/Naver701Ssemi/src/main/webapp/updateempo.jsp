<%@page import="dao.SsemiDao"%>
<%@page import="dto.SsemiDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>예약변경</title>
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
		color: white;
	}
	body{
		background-image: url("image/star.jpg");	
		overflow:hidden;
	}
	h2.mb-3{
		margin-left: 200px;
		margin-top: 200px;
		position: absolute;
	}
	.container{
		margin: 25px 0;
		margin-top:245px;
		margin-left: 1100px;
		margin-right: 10px;
		position: absolute;
	}
	.animate__backOutUp{
	 	animation-duration: 2s; /* don't forget to set a duration! */
	}
	.animate__fadeIn{
		animation-duration: 2.5s; /* don't forget to set a duration! */
	}
	
</style>
<%
//파라미터값 얻기
int num = Integer.parseInt(request.getParameter("num"));
//dto선언
SsemiDao dao = new SsemiDao();
//dao선언
SsemiDto dto = dao.getdata(num);
%>
</head>
<body>
		        
		        
		<!-- 달력 -->
	    <h2 class="mb-3 animate__animated animate__zoomIn" id="h2">진료예약하기</h2>
				<div class="calendar animate__animated animate__zoomIn" id="calendar">
				   <div class="header">
				      <button class="calendar_btn" onclick="prevCal();">&lt;</button>
				      <div class="title"><span class="year"></span><span class="month"></span></div>
				      <button class="calendar_btn" onclick="nextCal();">&gt;</button>
				   </div>
				   <div class="day">
				      <div>S</div>
				      <div>M</div>
				      <div>T</div>
				      <div>W</div>
				      <div>T</div>
				      <div>F</div>
				      <div>S</div>
				   </div>
				   <div class="dates"></div>
				</div>
				<!--  -->
				
				<!-- 예약 폼 -->
				<div class="container animate__animated animate__zoomIn" id="container">
				    <div class="input-form-backgroud row">
				      <div class="input-form col-md-12 mx-auto">
				        <h2 class="mb-3"></h2>
				        <form class="validation-form" id="myform" method="post" onsubmit="submit();" >
				      <!-- hidden -->
						<input type="hidden" name="num" value="<%=dto.getNum() %>">
				          <div class="row">
				            <div class="col-md-6 mb-3" style="height: 62px">
				              <label for="name">성함</label>
				              <input type="text" class="form-control" id="name" name="name" placeholder="성함을 입력해 주세요." value="<%=dto.getName() %>" style="width: 580px;" required>
				              <div class="invalid-feedback">
				                성함을 입력해 주세요.
				              </div>
				                 <p id="resultMsg"></p>
				            </div>
				          </div>
				
				          <div class="col-md-6 mb-3">
				            <label>생년월일</label>
				            <input type="number" class="form-control" id="p_type" name="birthyear" placeholder="생년월일을 입력해 주세요. Ex)19890101" value="<%=dto.getBirthyear() %>" style="width: 580px;" maxlength="8" oninput="numberMaxLength(this);" required>
				            <div class="invalid-feedback">
				              생년월일을 입력해 주세요.(Ex19890101)
				            </div>
				            <p id="resultMsg3"></p>
				          </div>
				          <div class="col-md-6 mb-3">
				            <label>날짜 확인</label>
				            <input type="text" id="period_1" class="form-control" name="empoday" placeholder="날짜를 골라주세요." value="<%=dto.getEmpoday() %>" style="width: 580px;"  readonly="readonly" >
				            <div class="invalid-feedback">
				              날짜를 골라주세요.
				            </div>
				               <p id="resultMsg2"></p>
				          </div>
				
				          <div class="col-md-6 mb-3">
				            <label for="phoneNumber">전화번호<span class="text-muted">&nbsp;</span></label>
				            <input type="number" maxlength="11" oninput="numberMaxLength(this);" class="form-control" id="phoneNumber" name="phone" placeholder="-빼고 입력해 주세요"  value="0<%=dto.getPhone() %>" style="width: 580px;" required>
				          </div>
				      
				          <hr class="col-md-6 mb-3" style="width: 580px;">
				          <div class="custom-control custom-checkbox">
				            <input type="checkbox" class="custom-control-input" id="aggrement" required checked="checked">
				            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
				          </div>
				          <div class="mb-4"></div>
				          <button class="btn btn-primary btn-lg btn-block modal-btn-sub" type="button" id="btnS">수정하기</button>
				          <button class="btn btn-primary btn-lg btn-block modal-btn-can" type="reset" id="btnF">초기화</button>
				          <button class="btn btn-danger btn-lg btn-block modal-btn-can" type="button" id="btnC">취소</button>
				        </form>
				      </div>
				      </div>
				      </div>
				      
<script type="text/javascript">
document.body.style.overflow = "hidden";
var CDate = new Date(); 
var today = new Date();
var selectCk = 0;
var check = 1;
var buildcalendar = function(){
   var htmlDates = ''; 
   var prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0); //지난 달의 마지막 날 
   var thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1); //이번 달의 첫쨰 날
   var thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0); //이번 달의 마지막 날
   document.querySelector(".year").innerHTML = CDate.getFullYear() + "년";  // year에 년도 출력
   document.querySelector(".month").innerHTML = (CDate.getMonth() + 1) + "월";  //month에 월 출력
   const dates = []; 
   if(thisFirst.getDay()!=0){ 
      for(var i = 0; i < thisFirst.getDay(); i++){
         dates.unshift(prevLast.getDate()-i); // 지난 달 날짜 채우기
      } 
   } 
   for(var i = 1; i <= thisLast.getDate(); i++){
          dates.push(i); // 이번 달 날짜 채우기 
   } 
   for(var i = 1; i <= 13 - thisLast.getDay(); i++){ 
          dates.push(i); // 다음 달 날짜 채우기 (나머지 다 채운 다음 출력할 때 42개만 출력함)
   } 
   
   for(var i = 0; i < 42; i++){
      if(i < thisFirst.getDay()){
         htmlDates += '<div class="date last">'+dates[i]+'</div>'; 
      }else if(today.getDate()==dates[i] && today.getMonth()==CDate.getMonth() && today.getFullYear()==CDate.getFullYear()){
          htmlDates += '<div id="date_'+dates[i]+'" class="date today" onclick="fn_selectDate('+dates[i]+');" >'+dates[i]+'</div>'; 
      }else if(i >= thisFirst.getDay() + thisLast.getDate()){
          htmlDates += '<div class="date next">'+dates[i]+'</div>'; 
      }else{
         htmlDates += '<div id="date_'+dates[i]+'" class="date" onclick="fn_selectDate('+dates[i]+');">'+dates[i]+'</div>'; 
      }
    } 
document.querySelector(".dates").innerHTML = htmlDates; 
} 
function prevCal(){
    CDate.setMonth(CDate.getMonth()-1); 
    buildcalendar(); 
} 
function nextCal(){
    CDate.setMonth(CDate.getMonth()+1);
    buildcalendar(); 
}
function fn_selectDate(date){
   
   var year = CDate.getFullYear();
   var month = CDate.getMonth() + 1;
   var date_txt = "";
   if(CDate.getMonth + 1 < 10){
      month = "0" + (CDate.getMonth() + 1);
   }
   if(date < 10){
      date_txt = "0" + date;
   }
   
   if(selectCk == 0){
      $(".date").css("background-color", "");
      $(".date").css("color", "");
      $("#date_"+date).css("background-color", "red");
      $("#date_"+date).css("color", "white");
      
      $("#period_1").val(year+"-"+month+"-"+date);
      check = 0;
      selectCk = 0;
         
      if(check == 0){
         const target = document.getElementById('btnS');
         target.disabled = false;
      }
   
   }
   
}
buildcalendar();
const target = document.getElementById('btnS');
target.disabled = true;
$("#btnF").click(function(){
	const target = document.getElementById('btnS');
	target.disabled = true;
	CDate.setMonth(CDate.getMonth());
	buildcalendar(); 
});
function numberMaxLength(e){
    if(e.value.length > e.maxLength){
        e.value = e.value.slice(0, e.maxLength);
    }
}

$("#btnC").click(function() {
	$(".animate__animated").removeClass("animate__zoomIn");
	$(".animate__animated").addClass("animate__backOutUp");
	setTimeout(() => {
	location.href="empock.jsp";			
	}, 1500);
	setTimeout(() => {
		$(".animate__animated").removeClass("animate__backOutUp");
		$(".animate__animated").addClass("animate__zoomIn");
	}, 2200);
});


$("#btnS").click(function() {
	$(".animate__animated").removeClass("animate__zoomIn");
	$(".animate__animated").addClass("animate__backOutUp");
	setTimeout(() => {
		 $("#myform").attr("action","updateempoaction.jsp").submit();
		}, 1900);
	setTimeout(() => {
		$(".animate__animated").removeClass("animate__backOutUp");
		$(".animate__animated").addClass("animate__zoomIn");
	}, 2200);
});

</script>

</body>

<style>
.calendar {
	font-size: 20px;
	width: 800px; 
	padding: 20px 20px 20px 20px; 
	box-sizing: border-box; 
	border: 1px solid;
	margin: 25px 0;
	margin-top:250px;
	margin-left: 200px;
	margin-right: 10px;
	position: absolute;
}
.calendar > .header {text-align: center;}
.calendar > .header > .title {font-size: 25px; width:50%; display: inline-block;}
.calendar > .header > .calendar_btn {
	font-size: 20px;
   width: 30px;
   height: 30px;
   border: none;
   padding: 0;
   background-color: #ffffff;
   vertical-align: middle;
   color: black;
   
}
.calendar > .day {width:100%; display: table; table-layout: fixed; margin-top: 10px; font-size: 22px;}
.calendar > .day > div {display: table-cell; text-align: center; height: 50px; vertical-align: middle;}
.calendar > .day > div:first-child {color: red;}
.calendar > .day > div:last-of-type {color: blue;}
.calendar > .dates {display: flex; flex-wrap: wrap; width: 100%;}
.calendar > .dates > .date {text-align: center; width: calc(100%/7); height: 50px; box-sizing: border-box;line-height: 3; border-radius: 3px;} 
.calendar > .dates > .date:nth-child(7n){color: blue;}
.calendar > .dates > .date:nth-child(7n+1){color: red;}
.calendar > .dates > .last {color: #c8c8c8 !important;}
.calendar > .dates > .next {color: #c8c8c8 !important;}
</style>