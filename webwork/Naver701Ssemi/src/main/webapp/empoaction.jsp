<%@page import="dao.SsemiDao"%>
<%@page import="dto.SsemiDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
request.setCharacterEncoding("utf-8");

//데이터 각각읽기
String name = request.getParameter("name");
int birthyear = Integer.parseInt(request.getParameter("birthyear"));
String empoday = request.getParameter("empoday");
int phone = Integer.parseInt(request.getParameter("phone"));

//dto 선언
SsemiDto dto = new SsemiDto();

//데이터 dto에 넣기
dto.setName(name);
dto.setBirthyear(birthyear);
dto.setEmpoday(empoday);
dto.setPhone(phone);

//dao선언
SsemiDao dao = new SsemiDao();

//insert 메서드 호출
dao.insertempo(dto);
//페이지 이동
response.sendRedirect("main.jsp");

%>