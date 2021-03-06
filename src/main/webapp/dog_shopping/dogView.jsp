<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/dog_shopping/css/view.css">
</head>
<body>
<section id="listForm">
	<h2>${dog.kind }</h2>
	<section id="content_main">
		<section id="content_left">
			<img src="<%=request.getContextPath()%>/dog_shopping/img/${dog.image}">
		</section>
		<section id="content_right">
			<b>품종 : </b> ${dog.kind } <br>
			<b>가격 : </b> ${dog.price } <br>
			<b>신장 : </b> ${dog.height } <br>
			<b>체중 : </b> ${dog.weight } <br>
			<b>원산지 : </b> ${dog.country } <br>
			<p id="desc">
			<b>내용 : </b> ${dog.content } <br>
		</section>
		<div style="clear:both"></div>
		<nav id="commandList">
			<a href="<%=request.getContextPath()%>/dogList.do"><button>쇼핑 계속하기</button></a>
			<a href="<%=request.getContextPath()%>/dogCartAdd.do?id=${dog.id}"><button>장바구니에 담기</button></a>
		</nav>
	</section>
</section>	
	
</body>
</html>