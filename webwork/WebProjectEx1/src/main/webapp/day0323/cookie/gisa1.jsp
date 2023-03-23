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
[헤럴드경제=손미정 기자] 미 연방준비제도(Fed·연준)가 금융 시스템 불안 속에 시장의 예상과 같이 베이비스텝(기준금리 0.25%포인트 인상)을 단행했다.

연준은 22일(현지시간) 이틀간의 연방공개시장위원회(FOMC) 정례회의를 마무리한 후 성명을 통해 기준 금리를 현재보다 0.25%포인트 높은 4.75~5.00%로 올렸다.


연준은 성명에서 “최근 지표는 지출과 생산에서 완만한 성장을 보여주고 있다. 일자리는 최근 몇 달간 증가했으며 견조한 속도로 움직이고 있다”면서 “실업률은 낮게 유지되고 있으며 인플레이션은 높은 상태”라면서 이 같은 결정 이유를 설명했다.

연준은 지난해 4연속 기준금리 0.75%포인트 인상을 단행한 이후 물가 상승세가 둔화할 조짐을 보이자 인상 폭을 지난해 12월 0.50%포인트, 올 2월 0.25%포인트로 줄이면서 속도 조절을 했왔다. 이후 최근들어 인플레이션 둔화세가 느려지고 고용 호조 등의 지표가 나오면서 한때 연준이 이번에 다시 인상폭을 높일 것이란 관측에 힘이 실리기도 했다.

하지만 이후 실리콘밸리은행(SVB)·시그니처은행 파산 사태가 발생하고 퍼스트리퍼블릭은행의 위기설로 금융 시스템 혼란이 가중되자 일각에서는 금리 동결 내지 인하 필요성까지 제기됐다. 공격적인 금리 인상이 금융 불안의 이유로 거론되면서다.

연준의 이날 베이비스텝은 인플레이션 잡기와 금융 안정이란 두 목표를 절충한 성격으로 풀이된다. 시장에서도 0.25%포인트 인상 전망이 가장 많았다.


이와 관련 연준은 성명에서 “미국의 은행 시스템은 건전하고 탄력적”이라면서 “최근 상황은 가계와 기업에 대한 신용 조건이 더 엄격해지고 경제 활동, 고용, 인플레이션에 더 부담을 줄 가능성이 있다”고 말했다.

이어 “이런 영향의 범위는 불확실하다”면서 “위원회는 인플레이션 리스크에 매우 주의를 기울이고 있다”고 밝혔다.

금리 전망은 지난해 12월 예상치와 같은 수준이었다. FOMC 위원들의 금리 인상 전망을 보여주는 지표인 점도표(dot plot)상의 올해 말 금리 예상치(중간값)는 5.1%였다. 내년 말 기준 금리 전망치는 4.3%, 2025년말 전망치는 3.1%였다.

또한 연준은 경제전망요약(SEP) 자료에서 올해 말 물가상승률 전망치를 3.3%로 제시했다. 이는 직전인 지난해 12월 전망(3.1%)보다 다소 올라간 것이다. 연준의 올해 실질 국내총생산(GDP) 증가율 전망치는 0.4%로 직전보다 0.1%포인트 낮아졌다.

올해 실업률 전망치도 작년 12월 4.6%에서 이번에는 4.5%로 하향됐다.

한편 미국 연준의 베이비스텝으로 한국과의 기준금리 차는 기존 1.25%포인트에서 1.5%포인트로 확대되며, 한미간 금리는 2000년 5~10월 이후 22년여 만에 최대 역전 폭을 기록하게 됐다.

balme@heraldcorp.com
</pre>
<%} else{%>
	<script type="text/javascript">
	alert("로그인후 기사를 볼 수 있습니다.");
	history.back();
	</script>
<%}%>
</body>
</html>