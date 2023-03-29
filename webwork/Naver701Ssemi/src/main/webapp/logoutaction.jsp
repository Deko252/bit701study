<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	session.removeAttribute("loginstate");

	response.sendRedirect("main.jsp");

%>