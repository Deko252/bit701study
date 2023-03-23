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
	boolean b = false;//amho cookie가 존재하면 true로 변경
	//브라우저에 저장된 모든 쿠키값들을 얻는다
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0; i < cookies.length; i++){
			String cname = cookies[i].getName();
			String cvalue = cookies[i].getValue();
			if(cname.equals("amho") && cvalue.equals("1234")){
				//amho 쿠키가 존재하므로 b를 true로 변경
				b = true;
			}
		}
	}
%>
<body>
<%
if(b){
%>
<pre>
[OSEN=김나연 기자] 빅뱅 전 멤버 승리와 인플루언서 유혜원이 방콕 여행설에 휩싸였다. 세 번째 열애설 후 1년만의 일이다.

22일 디스패치는 제보자의 말을 빌려 승리와 유혜원의 방콕 여행설을 보도했다. 보도에 따르면 승리는 지난 5일 방콕의 한 특급호텔에서 휴가를 보냈으며 유해원과 다정히 손을 잡고 로비를 거닐었다.

제보자 A씨는 "두 사람은 여느 연인처럼 자연스레 스킨십을 했다"면서도 "한국인들을 경계하는 모습이었다"고 전했다.


승리와 유혜원은 과거에도 여러 차례 열애설에 휩싸였던 바 있다. 지난 2018년 10월 한 매체는 두 사람이 1년간 만남을 이어오고 있다며 첫 번째 열애설을 보도했다. 이와 함께 같은 시기 비슷한 장소에서 찍은 사진을 각각 올리는 등 '럽스타그램'으로 의심되는 정황까지 포착돼 의심을 더했다. 하지만 양측은 별다른 입장을 내놓지 않았다.

[OSEN=철원, 민경훈 기자]승리가 하차한 후 신병교육대로 입소하고 있다. / rumi@osen.co.kr

그리고 2년 후인 2020년 3월에는 승리가 강원도 철원군 육군 6사단 신병교육대를 통해 입소했을 당시 여자친구와 동행했다는 의혹이 제기됐다. 특히 누리꾼들은 입소 당시 찍힌 사진을 근거로 열애 상대가 유혜원이라고 추측했다. 승리가 타고 온 차 안에 유혜원의 반려견과 동일한 견종이 함께 포착됐다는 것.

하지만 두 번째 열애설에 대해서도 유혜원의 소속사 측은 "배우 개인의 사생활이기 때문에 확인하기 어렵다"며 말을 아꼈다. 유혜원 역시 별다른 입장을 밝히지 않은 채 인스타그램 게시글을 비공개로 전환했다.

그리고 그로부터 꼬박 3년후, 세 번째 열애설이 불거졌다. 지난달 만기 출소한 승리가 그 직후 유혜원과 함께 방콕 여행을 떠났다는 목격담이 제기된 것. 다만 한 매체의 보도에 따르면 유혜원은 승리와의 여행에 대해 묻자 "태국 결혼식 일정이 있어 지인들과 함께한 자리였다"고 답한 것으로 전해졌다.

한편 승리는 상습도박, 성매매처벌법 위반(성매매·성매매 알선·카메라 등 이용 촬영), 특경법 횡령, 외국환거래법 위반 등 9개 혐의에 대해 징역 1년 6개월을 선고받고 지난달 9일 만기출소했다.

/delight_me@osen.co.kr

[Copyright © OSEN 무단전재 및 재배포 금지] [OSEN 페이스북에서 무엇이든 물어보세요 클릭!!!]
</pre>
<%} else{%>
	<script type="text/javascript">
	alert("로그인후 기사를 볼 수 있습니다.");
	history.back();
	</script>
<%}%>
</body>
</html>