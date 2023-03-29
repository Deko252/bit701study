<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	//체크값
	String chksave = request.getParameter("chksave");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	out.println("chksave = " + chksave); //체크 안하면 null 체크하면 on
	
	if(pass.equals("1234")){//비밀번호가 맞으면 세션에 3가지 적용
		session.setMaxInactiveInterval(60*60);//유지시간 한시간
		session.setAttribute("loginid", id);
		session.setAttribute("chksave", chksave == null?"no":"yes");
		session.setAttribute("loginstate", "yes");
		
		//successpage로 이동
		response.sendRedirect("main.jsp");
		
		
	}else{%>
		<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.back();
		</script>
	<%}

%>