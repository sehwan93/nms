<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>낭만섬 게시글 등록</title>
	<!-- css -->
	<%@include file="../common/css.jsp" %>
</head>
<body>
	<!-- header -->
	<%@include file="../common/header.jsp" %>
	<div class="container">
		<form role="form" method="post">
			<!-- box_body -->
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail">Title</label>
					<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요.">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Content</label>
					<textarea class="form-control" rows="3" name="content" placeholder="내용을 입력하세요."></textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail">writer</label>
					<input type="text" name="writer" class="form-control" placeholder="작성자를 입력하세요.">
				</div>
			</div>
			<!-- /.box-body -->
			
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">작성</button>
			</div>
			
		</form>
	</div>
	
	<!-- javascript -->
	<%@include file="../common/javascript.jsp" %>
	<script>
		$(document).ready(function(){
			init_board();
		});
	</script>
</body>
</html>