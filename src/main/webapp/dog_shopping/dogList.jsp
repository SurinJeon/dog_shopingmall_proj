<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강아지 쇼핑몰</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/dog_shopping/css/list.css">
</head>
<body>
	<section id="listForm">
	
		<c:if test="${dogList != null }">
			<h2>
				개 상품 목록 <br>
			</h2>
			<p>	<a href="dogRegistForm.do" id="regist"><button>개 상품 등록</button></a> </p>
			<table>
				<tr>
					<c:forEach var="dog" items="${dogList }" varStatus="status">
						<td>
							<a href="dogView.do?id=${dog.id }">
								<img src="<%=request.getContextPath()%>/dog_shopping/img/${dog.image}" id="productImage"> <br>
							</a>
							상품명: ${dog.kind } <br> 
							가격: ${dog.price } <br>
						</td>
						<c:if test="${((status.index + 1) mod 4) == 0 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</c:if>
		
		<c:if test="${dogList == null }">
			<div class="div_empty">개 상품이 없습니다. 분양 불가</div>
		</c:if>
		
		
		<br>
		<br>
		<br>
		
		<c:if test="${todayImageList != null }">
		<div id="todayImageList">
			<h2>오늘 본 개 상품 목록</h2>
			<table>
				<tr>
					<c:forEach var="todayImage" items="${todayImageList }" varStatus="status">
						<td>
							<img src="<%=request.getContextPath()%>/dog_shopping/img/${todayImage}" id="todayImage">
						</td>
						<c:if test="${((status.index + 1) mod 4) == 0 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</div>
	</c:if>
	
	</section>
</body>
</html>