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
	
	
	<h2>
		<a href="${pageContext.request.contextPath }/jpa/member">전체회원가져오기</a>
	</h2>
	<h2>
		<select id="selectId">
		</select>
		<button	onclick="searchId();">검색하기</button>
	</h2>
	<script>
		const searchId=()=>{
			const id=document.getElementById("selectId").value;
			const url="${pageContext.request.contextPath}/jpa/member/";
			location.assign(url+id);
		}
		
		//비동기식으로 요청을 보내는것 javascript가 제공하는 함수
		fetch("${pageContext.request.contextPath}/jpa/member/")
		.then(response=>response.json())
		.then(data=>{
			const $selectContainer=document.getElementById("selectId");
			console.log(data);
			data.forEach(e=>{
				const $option=document.createElement("option");
				$option.value=e.userId;
				$option.innerText=e.userId;
				$selectContainer.appendChild($option);
			});
		});
	</script>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>