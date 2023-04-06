<%@page import="study.dao.ShopDao"%>
<%@page import="study.dto.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//데이터 읽기
	int num = Integer.parseInt(request.getParameter("num"));
	String sangpum = request.getParameter("sangpum");
	String color = request.getParameter("color");
	String ipgoday = request.getParameter("ipgoday");
	String photo = request.getParameter("photo");
	int su = Integer.parseInt(request.getParameter("su"));
	int dan = Integer.parseInt(request.getParameter("dan"));
	
	//dto에 넣기
	ShopDto dto = new ShopDto();
	dto.setNum(num);
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setIpgoday(ipgoday);
	dto.setPhoto(photo);
	dto.setSu(su);
	dto.setDan(dan);

	//dao선언
	ShopDao dao = new ShopDao();	

	//dao에 있는 insert 메소드 호출
	dao.updateShop(dto);
%>