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
<title>ADMIN - 게시글 상세</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<div class="boardImg">
	<c:if test="${board.bpic1 != null }">
	<img src="${path1 }/img/${board.cate }/${board.bpic1 }" alt="${board.btitle }">
	</c:if>
	<c:if test="${board.bpic2 != null }">
	<img src="${path1 }/img/${board.cate }/${board.bpic2 }" alt="${board.btitle }">
	</c:if>
	<c:if test="${board.bpic3 != null }">
	<img src="${path1 }/img/${board.cate }/${board.bpic3 }" alt="${board.btitle }">
	</c:if>
	<c:if test="${board.bpic4 != null }">
	<img src="${path1 }/img/${board.cate }/${board.bpic4 }" alt="${board.btitle }">
	</c:if>
	</div>
	<table class="table">
		<tbody>
			<tr>
				<th>글 번호</th>
				<td>${board.bno }</td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td>${board.btitle }</td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td>${board.bcontent }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${board.baddress }</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${board.btel }</td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td>${board.cate }</td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="${path1 }/BoardList.do" class="button is-link is-inverted">게시판 목록</a>
					<a href="${path1 }/BoardUpdate.do?bno=${board.bno }" class="button is-success is-inverted">게시판 수정</a>
					<a href="${path1 }/BoardDelete.do?bno=${board.bno }" class="button is-danger is-inverted">게시판 삭제</a>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>