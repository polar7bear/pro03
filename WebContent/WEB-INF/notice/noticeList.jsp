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
<title>강릉 문화관광 - 공지사항</title>
<style>
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="container">
	<p style="font-size:28px;">${msg }</p>
	<table class="table">
		<thead>
			<tr><th>글 번호</th><th>제목</th><th>작성일</th><th>조회수</th><th>첨부파일</th></tr>
		</thead>
		<tbody>
			<c:forEach var="notice" items="${notice }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="${path1 }/NoticeDetail.do?no=${notice.no }">${notice.title }</a></td>
				<td>
					<fmt:parseDate value="${notice.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" />
				</td>
				<td>${notice.visited }</td>
				<c:if test="${notice.file1!=null }">
				<td><img src="img/notice/file.png" alt="첨부파일" style="width:16px; height:16px;"></td>
				</c:if>
			</tr>
			</c:forEach>
			<c:if test="${empty notice}">
			<tr>
				<td colspan="4">해당 공지사항이 존재하지 않습니다.</td>
			</tr>
			</c:if>	
		</tbody>
	</table>
	<c:if test="${sid=='admin' }">
	<div class="btn-group">
			<a href="${path1 }/NoticeInsert.do" class="button is-primary is-outlined">글 등록</a>
	</div>
	</c:if>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>