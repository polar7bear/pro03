<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	String sid = "";
	if(session!=null) sid = (String) session.getAttribute("sid"); 
%>
<c:set var="path2" value="${pageContext.request.contextPath }" /> 
<div id="nav-group">
	<div class="container">
		<div class="img" style="width:200px; height:150px; float:left;">
			<img src="${path2 }/img/logo.png" alt="강릉시 로고">
		</div> 
		  <div id="navbarBasicExample" class="navbar-menu">
		    	<div class="navbar-start" id="gnb">
		    	<!-- ajax로 메뉴 로딩하여 추가하기 -->
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/index.jsp" class="navbar-link" >
				    </a>
				    <div class="navbar-dropdown cate" id="cate01">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link">
				      	테마 여행 자리
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/GetNoticeListCtrl.do">
					       	 서브 페이지
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link">
				      	관광 명소 자리
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/GetNoticeListCtrl.do">
					       	 서브 페이지
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link">
				      	관광 안내 자리
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/GetNoticeListCtrl.do">
					       	 서브 페이지
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link">
				      	강릉은 지금
				    </a>
					<div class="navbar-dropdown single">
						<a class="navbar-item" href="${path2 }/GetNoticeListCtrl.do">
					       	 서브 페이지
						</a>
				    </div> 
				</div>
			</div>
			<div class="navbar-item has-dropdown is-hoverable single">
		    	<a class="navbar-link">
			      	사이트맵 자리
			    </a>
				<div class="navbar-dropdown single">
				     <a class="navbar-item" href="${path2 }/.do">
				       	테마여행
				     </a>
				     <a class="navbar-item" href="${path2 }/.do">
				       	관광 명소
				     </a>
				     <a class="navbar-item" href="${path2 }/.do">
				       	관광 안내
				     </a>
				     <a class="navbar-item" href="${path2 }/.do">
				       	강릉은 지금
				     </a>
			    </div> 
			</div>
			<div class="navbar-item">
		  		<c:if test="${empty sid }">
					<div class="buttons">
					   <a href="https://www.gn.go.kr/www/index.do" class="button is-light">
					     강릉 시청
					   </a>
					   <a href="${path2 }/Login.do" class="button is-light">
					     로그인
					   </a>
					</div>
				</c:if>
				<c:if test="${!empty sid }">
					<div class="buttons">
						<a href="${path2 }/MyInfo.do" class="button is-primary">
					     <strong>내 정보</strong>
					   	</a>
					   	<a href="${path2 }/Logout.do" class="button is-light">
					     로그아웃
					   	</a>
						<c:if test="${sid=='admin' }">
						   <a href="${path2 }/AdminCtrl.do" class="button is-danger">
						     <strong>ADMIN</strong>
						   </a>
						</c:if>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>


<script>
</script>
