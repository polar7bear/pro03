<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN - 회원 관리</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<p style="font-size:28px;">${msg }</p>
	<table class="table">
		<thead>
			<tr><th>ID</th><th>이름</th><th></th><th>연락처</th><th>가입일</th></tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${user }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="${path1 }/AdminUserDetail.do?id=${user.id }">${user.id }</a></td>
				<td>${user.name }</td>
				<td>${user.tel }</td>
				<td>
					<fmt:parseDate value="${user.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" />
				</td>
				<td><a href="${path1 }/AdminUserDelete.do?id=${user.id }">회원 탈퇴</a></td>
			</tr>
			</c:forEach>
			<c:if test="${empty user}">
			<tr>
				<td colspan="4">가입한 회원이 존재하지 않습니다.</td>
			</tr>
			</c:if>	
		</tbody>
	</table>
	<c:if test="${sid=='admin' }">
	<div class="btn-group">
			<a href="${path1 }/NoticeInsert.do" class="btn btn-primary">글 등록</a>
	</div>
	</c:if>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>