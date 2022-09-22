<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 예약 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h1>reservationList.jsp</h1>
	<%
		System.out.println(session.getAttribute("mem_num"));
	%>

	<input type="button" name="res_btn" id="res_btn" value="예약하기" 
	onclick="location.href='./Reservation.re';"> <br><br>
	<fieldset>
		<table border="1">
			<tr>
				<td>예약 번호</td>
				<td>예약자</td>
				<td>예약 날짜 및 시간</td>
				<td>예약 인원</td>
			</tr>
		<c:forEach var="dto" items="${reservationList }"> 
			<tr>
				<td>${dto.res_num }</td>
				<td>${dto.name }</td>
				<td>
					<a href="./ReservationContent.re?res_num=${dto.res_num }&pageNum=${requestScope.pageNum}">
					${dto.res_date } / ${dto.res_time }시
					</a>
				</td>
				<td>${dto.res_persons }명</td>				
			</tr>
		</c:forEach>
		</table>
		<input type="button" value="예약 수정" name="res_update" onclick=""> 
		<input type="button" value="예약 삭제" name="res_delete" onclick=""> 
	</fieldset>
		<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./ReviewList.rv?pageNum=${startPage-pageBlock }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="./ReviewList.rv?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./ReviewList.rv?pageNum=${startPage + pageBlock }">[다음]</a>
		</c:if>
	</c:if>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>