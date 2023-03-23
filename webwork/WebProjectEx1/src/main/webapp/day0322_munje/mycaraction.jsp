<%@page import="study.dao.MyCarDao"%>
<%@page import="study.dto.MyCarDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<% 
	request.setCharacterEncoding("utf-8");

	//데이터 각각읽기
	String carname = request.getParameter("carname");
	int carprice = Integer.parseInt(request.getParameter("carprice"));
	String carphoto = request.getParameter("carphoto");
	String buyday = request.getParameter("buyday");
	
	//dto 선언
	MyCarDto dto = new MyCarDto();
	//데이터 dto에 넣기
	dto.setCarname(carname);
	dto.setCarprice(carprice);
	dto.setCarphoto(carphoto);
	dto.setBuyday(buyday);
	//dao선언
	MyCarDao dao = new MyCarDao();
	//insert 메서드 호출
	dao.insertCar(dto);
	
	//페이지 이동
	response.sendRedirect("mycarlist.jsp");
	
%>