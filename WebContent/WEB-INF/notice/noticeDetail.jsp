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
<title>강릉 문화관광 - 공지사항 상세</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<table class="table">
	<tbody>
		<tr>
			<th>글 번호</th>
			<td>${notice.no }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${notice.regdate }</td>
		</tr>
		<c:if test="${notice.editdate!=null }">
		<tr>
			<th>글 수정 날짜</th>
			<td>${notice.editdate }</td>
		</tr>
		</c:if>
		<tr>
			<th>제목</th>
			<td>${notice.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${notice.content }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<c:if test="${notice.file1!=null }">
			<td><a href="${notice.file1 }" download>다운로드</a></td>
			</c:if>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${notice.visited }</td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="${path1 }/NoticeList.do" class="button is-link is-light">공지사항 목록</a>
				<a href="${path1 }/NoticeUpdate.do?no=${notice.no }&file1=${notice.file1 }" class="button is-link is-light">수정</a>
				<a href="${path1 }/NoticeDelete.do?no=${notice.no }" class="button is-danger is-light">삭제</a>
			</td>
		</tr>
	</tbody>	
	</table>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>