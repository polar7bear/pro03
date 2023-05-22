<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path2" value="${pageContext.request.contextPath }" /> 
<div id="nav-group">
	<div class="container"> 
		<nav class="navbar" role="navigation" aria-label="main navigation" id="nav">
		  <div class="navbar-brand">
		    <a class="navbar-item" id="logo2" href="<%=request.getContextPath() %>/">
		    </a>
		
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		
		  <div id="navbarBasicExample" class="navbar-menu">
		    <div class="navbar-start" id="gnb">
		    	<!-- ajax로 메뉴 로딩하여 추가하기 -->
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=A" class="navbar-link" >
			    	 <img src="$/images/loro.jpg" alt="강릉시 로고">
				     
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

				    </div>
			  </div>
			</div>
			
			<div class="navbar-end" id="tnb">
			  <div class="navbar-item">
			  	<c:if test="${empty sid }">
			 <div class="buttons">
			   <a href="${path2 }/index.jsp" class="button is-light">
			     강릉 시청
			   </a>
			   <a href="${path2 }/login.jsp" class="button is-light">
			     로그인
			   </a>
			 </div>
			</c:if>
			<c:if test="${not empty sid }">
			 <div class="buttons">
			   <a href="${path2 }/UserInfoCtrl.do" class="button is-primary">
			     <strong>Member Info</strong>
			   </a>
			   <a href="${path2 }/UserLogoutCtrl.do" class="button is-light">
			     LogOut
			   </a>
				<c:if test='${sid.equals("admin")}'>
				   <a href="${path2 }/AdminCtrl.do" class="button is-danger">
				     <strong>Admin</strong>
				   </a>
				 </c:if>
			 </div>
			</c:if>
		  </div>
		</div>
		  </div>
		</nav>
	<script>
	</script>
	</div>
</div>