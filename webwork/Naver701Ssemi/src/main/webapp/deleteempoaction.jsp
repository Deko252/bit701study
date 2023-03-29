<%@page import="dao.SsemiDao"%>
<%@page import="dto.SsemiDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
request.setCharacterEncoding("utf-8");

//데이터 각각읽기
int num = Integer.parseInt(request.getParameter("num"));

//dao선언
SsemiDao dao = new SsemiDao();

//delete 메서드 호출
dao.deleteempo(num);
//페이지 이동
response.sendRedirect("empock.jsp");

%>