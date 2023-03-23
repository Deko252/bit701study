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
미국이 자국에 반도체 공장을 세우는 기업에 보조금을 지급하는 조건으로 내건 '가드레일(Guardrail·안전장치)'의 세부 내용을 완화했다. 미국의 보조금을 받을 경우 향후 10년간 중국에서 생산설비 확대를 5% 이내로 확장과 기술 공정 업그레이드를 진행할 수 있게 된 것이다. 반도체 생산 첨단 설비 반입도 가능하다. 

이에 따라 중국에 반도체 생산공장을 운영 중인 삼성전자와 SK하이닉스는 '전면 투자 금지'라는 최악의 시나리오를 피하면서 한숨 돌릴 수 있게 됐다.

반도체 업계에서도 일단은 다행스럽다는 입장이다. 다만 메모리 업황 특성상 5% 이내 생산시설 확대는 수지타산에서 맞지 않을 수 있다는 점에서 우려의 목소리도 나온다.


이미지=지디넷코리아
미국 상무부는 21일(현지시간) 반도체법상 투자 자금 지원을 받는 기업이 중국에 설비확장을 제한하는 가드레일(안전장치) 조항의 세부 규정안을 발표했다.

Advertisement

미국으로부터 투자 보고금을 받은 경우 수령일로부터 향후 10년간 중국 등 우려대상국에 있는 생산설비의 생산능력을 5% 이내만 확장 가능하다. 일정 사양 이하인 레거시 반도체의 생산설비인 경우 생산능력 확장을 10% 미만까지 허용하기로 했다. 레거시 반도체에는 28나노 이상 로직 칩, 128단 미만 낸드, 18나노 초과 D램 등이 해당되며, 반도체 전(前)공정 제조설비(Fab)의 생산능력은 웨이퍼를 기준으로 측정한다.

산업통상자원부는 "한국 기업이 중국에서 운영하는 생산 설비의 유지 및 부분적 확장은 물론 기술 업그레이드도 계속 가능할 것으로 판단된다"라며 "기술 업그레이드 시, 집적도 증가를 통해 웨이퍼당 칩을 증가시킬 수 있어, 기업 전략에 따라서는 추가적인 생산 확대도 가능할 것으로 예상된다"고 밝혔다.

반도체 업계에서는 최악의 시나리오는 피하게 됐다며 긍정적인 입장이다. 특히 삼성전자와 SK하이닉스는 중국 내 반도체 생산공장을 확장을 못 하게 될 경우 계속 레거시 반도체만 생산할 수 있어 그 피해가 막대할 것으로 우려돼 왔다. 중국 사업장 철수설까지 나올 정도였다. 하지만 우려했던 것보다는 앞으로 신규 투자가 가능해지면서 반도체 생산을 이어갈 수 있게 됐다.


표=지디넷코리아
삼성전자는 중국 시안에 낸드플래시 공장, 쑤저우에는 후공정(테스트, 패키징) 공장을 두고 있다. SK하이닉스는 우시에 D램 공장과 파운드리(8인치) 공장이 있으며, 다롄에는 인텔에서 인수한 낸드플래시 공장이 있다.

삼성전자의 경우 낸드플래시의 40%를, SK하이닉스는 D램의 40%·낸드 20%를 중국에서 만든다. 삼성전자와 SK하이닉스는 현재까지 각각 중국에 33조원, 35조원 이상을 투자한 것으로 알려졌다.

김형준 차세대지능형반도체사업단 단장은 "미국 정부의 가드레일 조항에 대해 워낙 최악의 상황을 예상했기에, 예상 조항보다 완화됐다는 점에서 다행스럽게 생각한다"라며 "삼성전자는 낸드의 40%를 중국 시안 공장에서 만들고 있는데, 앞으로 5% 이내 확장할 수 있고, 일부 첨단 장비가 반입도 가능하다는 점에서 긍정적으로 본다"고 말했다. 

이어 그는 "미국이 중국에 반도체 투자를 반대하는 이유는 중국에 기술 유출 가능성과 첨단 반도체를 중국에 공급하는 것을 막겠다는 것"이라며 "한국 기업이 생산만 중국에서 하고 첨단 반도체를 외국에 팔면 된다고 판단해서 미국 정부가 조항을 완화한 것으로 본다"고 덧붙였다.

다만 메모리 업황 특성상 5% 이내 생산시설 확대로 묶어 놓는 조항은 수지타산에서 맞지 않을 수 있다는 점에서 우려된다는 의견도 나왔다.

업계 한 전문가는 "파운드리는 테크니컬 노드를 5나노에서 3나노, 3나노에서 1.5나노로 내려가는 것이 순서인데, 메모리는 기술 향상뿐 아니라 생산량을 지속해서 늘려야 공장이 유지가 될 수 있는 특성이 있다"며 "10년에 5% 생산량 증가면 1년에 0.5% 생산량이 늘어나는 것이고, 그러면 그 공장은 수지 타산이 맞지 않을 수 있어서 피해가 따른다"고 설명했다.

삼성전자와 SK하이닉스는 "발표 내용을 면밀히 검토해, 향후 대응 방향을 수립할 계획"이라고 밝혔다.
</pre>
<%} else{%>
	<script type="text/javascript">
	alert("로그인후 기사를 볼 수 있습니다.");
	history.back();
	</script>
<%}%>
</body>
</html>