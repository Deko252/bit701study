<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	div.box{
		float: lef	t;
		width: 50px;
		height: 50px;
		margin-right: 5px;
		border: 1px solid black;
	}
</style>
</head>
<body>
<c:set var="colors" value="red,green,blue,gray,pink,orange,magenta,tomato"></c:set>
<h4>${colors }</h4>
<c:forTokens var="a" items="${colors }" delims=",">
	<div class="box" style="background-color: ${a }">${a }</div>
</c:forTokens>
<hr>
<h5>숫자, 날짜 포멧 양식</h5>
<c:set var="today" value="<%=new Date() %>"></c:set>
<c:set var="money" value="7896730"></c:set>
<c:set var="num1" value="23.456789"></c:set>
<c:set var="num2" value="0.8"></c:set>

${today }
<hr>
<fmt:formatDate value="${today }" pattern="yyyy-MM-dd"/><br>
<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/><br>
<fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/><br>
<fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE"/><br>
<fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일 EE"/><br>
<hr>
${money }
<br>
${num1 }
<br>
number: <fmt:formatNumber value="${money }" type="number"></fmt:formatNumber><br>
currency:<fmt:formatNumber value="${money }" type="currency" currencySymbol="￦"></fmt:formatNumber><br>
currency:<fmt:formatNumber value="${money }" type="currency" currencySymbol="$"></fmt:formatNumber><br>

<fmt:formatNumber value="${num1 }" pattern="0.00"></fmt:formatNumber><br>
<fmt:formatNumber value="${num2 }" pattern="0.00"></fmt:formatNumber><br>
<fmt:formatNumber value="${money }" pattern="#,##0"></fmt:formatNumber><br>
</body>
</html>