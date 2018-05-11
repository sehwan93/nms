<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>낭만섬 게시판</title>
	<!-- css -->
	<%@include file="../common/css.jsp" %>
</head>
<body>
	<!-- header -->
	<%@include file="../common/header.jsp" %>
	<div class="container" id="main">
		<table class="table table-bordered">
			<tr>
				<th style="width: 80px">글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th style="width: 80px">조회 수</th>
			</tr>
			<c:forEach items="${list }" var="boardVO">
				<tr>
					<td>${boardVO.bno }</td>
					<td><a href='/board/read?bno=${boardVO.bno }'>${boardVO.title }</a></td>
					<td>${boardVO.writer }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate }"/></td>
					<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clearfix">
			<a href="register"><button class="btn btn-primary pull-right">글 작성</button></a>
		</div>
	</div>
	
	<!-- javascript -->
	<%@include file="../common/javascript.jsp" %>
	<script>
		function fnMove(seq){
			var scrollPosition = $("#main").offset().top;
			$("body").animate({
				scrollTop: scrollPosition
			}, 500);
	    }


		$(document).ready(function(){
			init_board();
		});
		
		var result = "${msg}";
		
		if(result == "success") {
			alert("요청하신 작업이 완료되었습니다.");
		}
	</script>
</body>
</html>