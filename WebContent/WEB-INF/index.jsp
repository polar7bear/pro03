<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path1" value="${request.getContextPath() }" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="/head.jsp" />
    <title>메인 페이지</title>
</head>
<body>
  	<jsp:include page="${path1 }/header.jsp" />
	<h2>메인 화면 페이지 입니다.
	
	</h2>
	<jsp:include page="${path1 }/footer.jsp" />
</body>
</html>