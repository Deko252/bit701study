<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//amho 값을 읽는다
	String amho = request.getParameter("amho");
	if(amho.equals("1234")){
		Cookie cookie = new Cookie("amho",amho);
		cookie.setPath("/");//쿠키 저장위치를 루트(/)로 설정
		cookie.setMaxAge(60*60);//1분으로설정
		response.addCookie(cookie);//브라우저에 쿠키 추가
		response.sendRedirect("cookiemain.jsp");// 쿠키메인페이지로 이동
	}else{%>
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다.");
			history.back();
		</script>
	<%}

%>