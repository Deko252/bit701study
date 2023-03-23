<%@page import="study.dao.PersonDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	//int 타입으로 num 읽기
	int num = Integer.parseInt(request.getParameter("num"));
	//dao선언
	PersonDao dao = new PersonDao();
	//삭제메서드 호출
	dao.deletePerson(num);
	//personlist.jsp로 이동
	response.sendRedirect("personlist.jsp");
%>