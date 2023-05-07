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
	
	<h2>회원저장하기</h2>
	<div id="enrollMember">
		<form action="${pageContext.request.contextPath}/jpa/member" method="post">
			아이디 <input type="text" name="userId"><br>
			패스워드 <input type="password" name="password"><br>
			이름 <input type="text" name="userName"><br>
			성별
			<label><input type="radio" name="gender" value="M">남</label>
			<label><input type="radio" name="gender" value="F">여</label>
			<br>
			나이<input type="number" size="3" name="age"><br/>
			전화번호<input type="text" name="phone"><br/>
			이메일<input type="email" name="email"><br/>
			주소<input type="text" name="address"><br/>
			취미<br>
			<label><input type="checkbox" name="hobby" value="운동">운동</label>
			<label><input type="checkbox" name="hobby" value="등산">등산</label>
			<label><input type="checkbox" name="hobby" value="독서">독서</label>
			<input type="submit" value="회원가입">
		</form>
	</div>
	<h2>이름으로 조회하기</h2>
	<input id="searchName" type="text" name="name"><button onclick="searchName();">검색하기</button>
	<script>
		const searchName=()=>{
			const name=document.querySelector("#searchName").value;
			location.assign("${pageContext.request.contextPath}/jpa/member/name/"+name);
		}
	</script>	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>