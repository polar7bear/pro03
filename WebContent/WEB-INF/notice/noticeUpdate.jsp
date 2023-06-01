<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<c:set var="apb" value="${cate1.ct }" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/head.jsp" />
<meta charset="UTF-8">
<title>ADMIN - 공지사항 등록</title>
<style>
</style>
</head>
<body>
<div class="container">
<jsp:include page="/header.jsp" />
<form class="frm1" action="NoticeUpdatePro.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tbody>
			<tr>
				<th><label for="title">공지사항 제목</label></th>
				<td>
				<input value="${notice.title }" class="input is-primary" id="title" name="title" type="text" title="50글자 미만 작성" placeholder="50글자 미만으로 제목을 입력해주세요." maxlength="49" >
				</td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td>
				<textarea class="input is-primary" id="content" name="content" style="width:900px; height:430px; resize:none" title="1000글자 미만 작성" placeholder="1000글자 미만으로 내용을 입력해주세요." maxlength="999" >${notice.content }</textarea>
				</td>
			</tr>
			<tr>
				<th><label for="file1">파일 첨부</label></th>
				<td>
					<input type="file" name="file1" id="file1" class="form-control file"><br>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="submit-btn" class="button button-info" value="글 수정">
					<a href="${path1 }/NoticeList.do" class="button button-info">공지사항 목록</a>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<jsp:include page="/footer.jsp" />
</div>
</body>
</html>