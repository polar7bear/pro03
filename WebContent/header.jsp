<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	String sid = "";
	if(session!=null) sid = (String) session.getAttribute("sid"); 
%>
<c:set var="path2" value="${pageContext.request.contextPath }" /> 
<div id="nav-group">
	<div class="container" style="height:80px; margin-left: 20px;">
		<div class="img">
			<img src="${path2 }/img/logo.png" alt="강릉시 로고" style="height:80px; float:left;">
		</div> 
		  <div id="navbarBasicExample" class="navbar-menu" style="margin-left:500px;">
		    	<div class="navbar-start" id="gnb" style="font-size:18px;">
		    	<!-- ajax로 메뉴 로딩하여 추가하기 -->
				<div class="navbar-item has-dropdown is-hoverable single" style="margin-left: 95px;">
			    	<a class="navbar-link" href="${path2 }/BoardA01.do?cate=a01">
				      	테마여행
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/BoardA01.do?cate=a01">
					       	 추천여행코스
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardA02.do?cate=a02">
					       	 강릉 Hot Place
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardA03.do?cate=a03">
					       	 강릉 길 여행
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardA04.do?cate=a04">
					       	 해양관광의 도시
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link" href="${path2 }BoardB01.do?cate=b01">
				      	관광명소
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/BoardB01.do?cate=b01">
					       	 자연관광
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardB02.do?cate=b02">
					       	 문화관광
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardB03.do?cate=b03">
					       	 레저 · 체험
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link" href="${path2 }/BoardC01.do?cate=c01">
				      	관광안내
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/BoardC01.do?cate=c01">
					       	 음식
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardC02.do?cate=c02">
					       	 숙박
					     </a>
					     <a class="navbar-item" href="${path2 }/BoardC03.do?cate=c03">
					       	 교통정보
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link" href="${path2 }/BoardD01.do?cate=d01">
				      	강릉은 지금
				    </a>
					<div class="navbar-dropdown single">
						<a class="navbar-item" href="${path2 }/BoardD01.do?cate=d01">
					       	 강릉서핑
						</a>
						<a class="navbar-item" href="${path2 }/BoardD02.do?cate=d02">
					       	강릉여행영상
						</a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link" href="${path2 }/NoticeList.do">
				      	공지사항
				    </a>
				</div>
			</div>
			<div class="navbar-item">
		  		<c:if test="${empty sid }">
					<div class="buttons" style="margin-left:220px;">
					   <a href="https://www.gn.go.kr/www/index.do" class="button is-light">
					     강릉 시청
					   </a>
					   <a href="${path2 }/Login.do" class="button is-light">
					     로그인
					   </a>
					</div>
				</c:if>
				<c:if test="${sid=='admin' }">
				<div class="navbar-item has-dropdown is-hoverable single" style="padding-left:90px; margin-right:-180px;">
			    	<a class="navbar-link" href="${path2 }/UserList.do">
				      	ADMIN
				    </a>
					<div class="navbar-dropdown single">
						<a class="navbar-item" href="${path2 }/UserList.do">
					       	 회원 관리
						</a>
						<a class="navbar-item" href="${path2 }/BoardList.do">
					       	게시판 관리
						</a>
				    </div> 
				</div>
				</c:if>
				<c:if test="${!empty sid }">
				<div class="buttons" style="margin-left:220px;">
					<a href="${path2 }/MyInfo.do" class="button is-primary">
				     <strong>내 정보</strong>
				   	</a>
				   	<a href="${path2 }/Logout.do" class="button is-danger">
				     로그아웃
				   	</a>
				</div>
				</c:if>
				<div class="navbar-item has-dropdown is-hoverable single" style="margin-left:130px;">
			    	<a class="navbar-link" href="">
				      	사이트맵
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
</div>


<script>
</script>
