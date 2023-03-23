<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- dao선언 dto선언-->
<jsp:useBean id="dao" class="study.dao.PersonDao"></jsp:useBean>
<jsp:useBean id="dto" class="study.dto.PersonDto"></jsp:useBean>
<!-- form 태그의 name 과 같은 경우에만 자동 주입 -->
<jsp:setProperty property="*" name="dto"/>
<%
	//수정 메서드 호출
	dao.updatePerson(dto);
	//목록으로 호출
	response.sendRedirect("personlist.jsp");
%>