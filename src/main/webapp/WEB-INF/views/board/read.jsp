<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="container">
		<form role="form" method="POST">
			<input type="hidden" name="bno" value="${boardVO.bno }">
		</form>
		
		<div class="box-body">
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardVO.content }</textarea>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" name="writer" class="form-control" value="${boardVO.writer }" readonly="readonly">
			</div>
		</div>
		
		<div class="box-footer clearfix">
			<div class="pull-right">
				<button type="submit" class="btn btn-warning">수정</button>
				<button type="submit" class="btn btn-danger">제거</button>
				<button type="submit" class="btn btn-primary">전체 목록</button>
			</div>
		</div>
	</div>
	
	<!-- javascript -->
	<%@include file="../common/javascript.jsp" %>
	<script>
		$(document).ready(function(){
			init_board();
			
			
			var formObj = $("form[role='form']");
			
			console.log(formObj);
			
			$(".btn-warning").on("click",function(){
				formObj.attr("action","/board/modify");
				formObj.attr("method","get");
				formObj.submit();
			});
			
			$(".btn-danger").on("click",function(){
				formObj.attr("action","/board/remove");
				formObj.submit();
			});
			
			$(".btn-primary").on("click",function(){
				self.location="/board/listAll";
			});
		});
	</script>
</body>
</html>