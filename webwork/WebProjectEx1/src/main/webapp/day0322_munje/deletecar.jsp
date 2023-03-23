<%@page import="study.dao.MyCarDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

//int 타입으로 num 읽기
int num =  Integer.parseInt(request.getParameter("num"));
//dao선언
MyCarDao dao = new MyCarDao();
//삭제메서드 호출
dao.deleteCar(num);
//personlist.jsp로 이동
response.sendRedirect("mycarlist.jsp");
%>