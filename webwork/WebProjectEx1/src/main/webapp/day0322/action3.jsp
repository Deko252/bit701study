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
	//post 방식인 경우 데이터 읽전에 엔코딩 코드를 넣어준다
	request.setCharacterEncoding("utf-8");
	//form2 의 데이터를 post 방식으로 읽는경우
	String sname = request.getParameter("sname");
	String gender = request.getParameter("gender");
	//선택을 안했을경우 null
	String []hobby = request.getParameterValues("hobby");
	String email = request.getParameter("email");
	String email2 = request.getParameter("email2");
	//hidden 데이터 읽기
	String message = request.getParameter("message");
%>
<body>
	<h4>
		이름 : <%=sname %>
		<br>
		성별 : <%=gender %>
		<br>
		선택취미:
		<%
			if(hobby == null){%>
				<b>취미 없음</b>
				<%
			}else{
				for(int i=0;i<hobby.length;i++){%>
						<%=hobby[i] %>
				<%}
			}
		%>
		<br style="clear: both;">
		이메일<br>
		<%=email %>@<%=email2 %>
		<br>
		Hidden 메세지<br>
		
	</h4>
</body>
</html>