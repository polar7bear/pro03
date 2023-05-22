<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json test2</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<style>
</style>
</head>
<body>
<div class="container">
	<div id="msg">
		<ul id="lst">
		
		</ul>
	</div>
	<button type="button" id="reqBtn">데이터 가져오기</button>
	<script>
	$(document).ready(function(){
		var params = { item1:"ssg" };
		$("#reqBtn").click(function(){
			$.ajax({
				url:"${path1 }/JSONTest2.do",
				type:"post",
				dataType:"json",
				data:params,
				success:function(obj){
					console.log;
					var sam = obj;
					$("#lst").append("<li>아이디 : "+sam.name+"</li>")
					$("#lst").append("<li>포인트 : "+sam.point+"</li>")
					$("#lst").append("<li>가입일 : "+sam.resdate+"</li>")
				}
			});
		});
	});
	</script>
</div>	
</body>
</html>