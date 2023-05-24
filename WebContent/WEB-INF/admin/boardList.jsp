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
<title>ADMIN - 게시글 목록</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<table class="table">
		<thead>
			<tr><td>글번호</td><td>제목</td><td>카테고리 번호</td></tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${board }">
			<tr>
				<th>${board.bno }</th>
				<th><a href="BoardDetail.do?bno=${board.bno }">${board.btitle }</a></th>
				<th>${board.cate }</th>
				<th><a href="BoardDelete.do?bno=${board.bno }">게시글 삭제</a></th>
			</tr>
		</c:forEach>
		<tr>
			<th><a href="BoardInsert.do">게시글 작성</a></th>
		</tr>
		</tbody>
	</table>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>