<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/head.jsp" />
<meta charset="UTF-8">
<title>강릉 문화관광 - 내 정보</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<section class="section">
	<h2 class="title">MY INFO</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>ID</th>
					<td>${user.id }</td>
				</tr>
				<tr>
					<td>PW</td>
					<td>${user.pw }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${user.name }</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>${user.tel }</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${user.address }</td>
				</tr>
				<tr>
					<td>가입일</td>
					<td>${user.regdate }</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="${path1 }/UserUpdate.do?id=${user.id }" class="button is-link is-inverted">정보 수정</a>
						<a href="${path1 }/UserDelete.do?id=${user.id }" class="button is-danger is-inverted">회원 탈퇴</a>
						<a href="javascript:history.go(-1)" class="button is-primary is-inverted">뒤로 가기</a>
					</td>
				</tr>
			</tbody>
		</table>
	</section>
</div>

<jsp:include page="/footer.jsp" />
</body>
</html>