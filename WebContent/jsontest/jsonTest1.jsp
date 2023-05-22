<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSONTest1 Test</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<style>
</style>
</head>
<body>
<div class="container">
	<h2>JSON 형태의 텍스트 출력</h2>
	<br><hr><br>
	<div id="msg">
		<ul id="lst">
			
		</ul>
	</div>
	<button type="button" id="reqBtn">데이터 가져오기</button>
	<script>
	$(document).ready(function(){
		var obj = {id:"SSG", point:100, resdate:"2023-05-18"};
		$("#lst").append("<li>아이디 : "+obj.id+"</li>");
		$("#lst").append("<li>포인트 : "+obj.point+"</li>");
		$("#lst").append("<li>가입일 : "+obj.resdate+"</li>");
	});
	</script>
	<script>
	$(document).ready(function(){
		$("#reqBtn").click(function(){
			$.ajax({
				url:"${path1 }/JSONTest1.do",
				type:"post",
				dataType:"json",
				success:function(result){
					//console.log(result.result);
					$("#lst").append("<li>메시지 : "+result.result+"</li>");
				}
			});
		});
	});
	</script>
</div>
</body>
</html>