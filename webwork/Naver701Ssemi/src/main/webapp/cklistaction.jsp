<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="dao.SsemiDao2"%>
<%@page import="dto.SsemiDto2"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
request.setCharacterEncoding("utf-8");

MultipartRequest mulRequest = null;
//저장할 경로
ServletContext context = getServletContext();
String realPath = context.getRealPath("/save");
System.out.println(realPath);

//업로드할 사진 사이즈
	int uploadSize = 1024*1024*3;//3mb
	try{
	mulRequest = new MultipartRequest(request,realPath,uploadSize,"utf-8",
			new DefaultFileRenamePolicy());

//데이터 각각읽기
String name = mulRequest.getParameter("name");
int birthyear = Integer.parseInt(mulRequest.getParameter("birthyear"));
int phone = Integer.parseInt(mulRequest.getParameter("phone"));
String photo = mulRequest.getFilesystemName("upload");//실제 업로드된 파일명
String content = mulRequest.getParameter("content");
String law = mulRequest.getParameter("law");

//dto 선언
SsemiDto2 dto = new SsemiDto2(name, birthyear, phone, photo, content, law);

//dao선언
SsemiDao2 dao = new SsemiDao2();

//insert 메서드 호출
dao.insertcklist(dto);
//페이지 이동
response.sendRedirect("cklist.jsp");

	}catch(Exception e){
	System.out.println("사진 업로드 오류 발생" + e.getMessage());
	}
%>