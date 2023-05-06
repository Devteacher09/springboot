<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>나의 첫 boot메인</title>
</head>
<body>
	<h2>나의 첫 boot화면</h2>
	<h3>
		<a href="${pageContext.request.contextPath}/member/memberAll.do">전체회원조회</a>
	</h3>
	
	<h2>파일 업로드 처리하기</h2>
	<form action="${pageContext.request.contextPath }/fileupload"
	method="post" enctype="multipart/form-data">
		<input type="file" name="upfile">
		<input type="submit" value="파일 전송">
	</form>
	
	
	
	
	
	
	
	
	
</body>
</html>