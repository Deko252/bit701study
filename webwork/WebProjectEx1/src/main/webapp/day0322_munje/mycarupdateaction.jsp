<%@page import="study.dto.MyCarDto"%>
<%@page import="study.dao.MyCarDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 

request.setCharacterEncoding("utf-8");

//int 타입으로 num 읽기
int num =  Integer.parseInt(request.getParameter("num"));
//데이터 각각읽기
String carname = request.getParameter("carname");
int carprice = Integer.parseInt(request.getParameter("carprice"));
String carphoto = request.getParameter("carphoto");
String buyday = request.getParameter("buyday");

//dto 선언
	//dao선언
	MyCarDao dao = new MyCarDao();
	MyCarDto dto = dao.getData(num);
	//데이터 dto에 넣기
	dto.setNum(num);
	dto.setCarname(carname);
	dto.setCarprice(carprice);
	dto.setCarphoto(carphoto);
	dto.setBuyday(buyday);
	
//수정메서드 호출
dao.updateCar(dto);
//personlist.jsp로 이동
response.sendRedirect("mycarlist.jsp");

%>