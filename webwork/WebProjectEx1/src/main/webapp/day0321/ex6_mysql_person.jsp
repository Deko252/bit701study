<%@page import="java.util.Date"%>
<%@page import="study.day0321.PersonDto"%>
<%@page import="java.util.List"%>
<%@page import="study.day0321.PersonDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body *{
		font-family: 'Jua'
	}
</style>
</head>
<%
	PersonDao dao=new PersonDao();
	List<PersonDto> list=dao.getAllPersons();
	Date date=new Date();
	int currYear=date.getYear()+1900;//현재 년도
%>
<body>
	<table class="table table-bordered" style="width: 400px">
		<caption align="top">
			<h4 class="alert alert-danger">Mysql Person 직원들</h4>
		</caption>
	<%
	for(PersonDto dto:list)
	{
		//나이
		int age=currYear-dto.getBirthyear();
		//띠
		int m=dto.getBirthyear()%12;
		String ddi=m==0?"원숭이":m==1?"닭":m==2?"개":m==3?"돼지":m==4?"쥐":
			m==5?"소":m==6?"호랑이":m==7?"토끼":m==8?"용":m==9?"뱀":m==10?"말":"양";
	 %>
		<tr>
			<td align="center">
				<img src="../image/moviestar/<%=dto.getPhoto()%>"
				class="img-thumbnail" width="150" height="200">
			</td>
			<td valign="middle">				
				이 름 : <%=dto.getName()%><br>
				<%=dto.getBirthyear()%>년생(<%=age%>세,<%=ddi%>띠)<br>
				주소 : <%=dto.getAddress()%><br>
				직업 : <%=dto.getJob()%>				
			</td>
		</tr>
	<%}
	%>	
	</table>
</body>
</html>














