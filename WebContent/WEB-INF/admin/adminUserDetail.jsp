<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/head.jsp" />
<meta charset="UTF-8">
<title>ADMIN - 회원 상세</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
	<div class="container">
	<h2>${msg }</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>ID</th>
					<td>${user.id }</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>${user.pw }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${user.name }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${user.tel }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${user.address }</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${user.regdate }</td>
				</tr>
				<tr>
					<td>
						<a href="${path1 }/AdminUserDelete.do?id=${user.id }">회원 탈퇴</a>
						<a href="${path1 }/UserList.do">회원목록 보기</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<jsp:include page="/footer.jsp" />
</body>
</html>