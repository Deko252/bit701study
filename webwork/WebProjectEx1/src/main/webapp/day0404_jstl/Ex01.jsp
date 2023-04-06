<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style type="text/css">
	body, body * {
		font-family: 'Jua'
	}
</style>
</head>
<body>
<%
	String name = "홍길동";
	String loginid = "angel";
	
	//name은 request 에 저장
	request.setAttribute("name", name);
	
	//loginid는 세션에 저장
	session.setAttribute("loginid", loginid);
%>

<!-- 숫자 2개 변수 선언 -->
<c:set var="su1" value="7"/>
<c:set var="su2" value="4"/>
<h2>su1:${su1 }, su2=${su2 }</h2>

<table class="table table-bordered" style="width:300px">
	<caption align="top"><b>JSTL 연산자</b></caption>
	<tr	style="background-color:#ccc">
		<th>연산자</th><th>결과</th>
	</tr>
	<tr>
		<td>\${su1+su2 }</td>
		<td>${su1+su2 }</td>
	</tr>
	<tr>
		<td>\${su1-su2 }</td>
		<td>${su1-su2 }</td>
	</tr>
	<tr>
		<td>\${su1*su2 }</td>
		<td>${su1*su2 }</td>
	</tr>
	<tr>
		<td>\${su1/su2 }\${su1 div su2 }</td>
		<td>${su1/su2 }${su1 div su2 }</td>
	</tr>
	<tr>
		<td>\${su1%su2 }\${su1 mod su2 }</td>
		<td>${su1%su2 }${su1 mod su2 }</td>
	</tr>
	<tr>
		<td>조건연산자</td>
		<td>${su1>su2?"su1이크다":"su2가크다" }</td>
	</tr>
	<tr>
		<td>논린연산자</td>
		<td>${su1>su2 && su1>5 }${su1>su2 and su1>5 }</td>
	</tr>
	<tr>
		<td>request영역의 변수출력</td>
		<td>${requestScope.name }</td>
	</tr>
	<tr>
		<td>session영역의 변수출력</td>
		<td>${sessionScope.loginid }</td>
	</tr>
	<tr>
		<td>session을 이용한 조건연산자</td>
		<td>${sessionScope.loginid2==null?"로그인안함":sessionScope.loginid2}</td>
	</tr>
</table>
</body>
</html>