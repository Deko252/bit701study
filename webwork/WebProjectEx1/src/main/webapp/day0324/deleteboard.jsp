<%@page import="java.io.File"%>
<%@page import="study.dao.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//num 일기
	int num = Integer.parseInt(request.getParameter("num"));
	//dao
	SimpleBoardDao dao = new SimpleBoardDao();
	//만약 글삭제시 업로드 했던 사진도 지우고 싶을경우
	//업로드 했던 파일명얻기
	String photo = dao.getData(num).getPhoto();
	//업로드된 경로 구하기
	String realPath = getServletContext().getRealPath("/save");
	//파일객체생성
	File file = new File(realPath + "/" +photo);
	file.delete();
	//delete
	dao.deleteBoard(num);
	//목록
	response.sendRedirect("boardlist.jsp");
	
%>