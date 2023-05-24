<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/head.jsp" />
<meta charset="UTF-8">
<title>강릉 문화관광 - 내 정보 수정</title>
<style>
.input { width:500px; }
.pw_pt { width:630px; }
.section { margin : 0 auto; width:700px; }
#address1, #address2 { margin-bottom:10px; }
.cant { color:#ff0000; font-size:6px; }
.urs { color:#81c147; font-size:6px; }
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="field container">
	<section class="section">
		<h2 class="title">정보 수정</h2>
		<form action="${path1 }/UserUpdatePro.do" method="post">
			<div class="field">
				<label class="label">ID <em class="cant">＊</em></label>
			  	<div class="control has-icons-left has-icons-right">
			    	<input class="input is-success" type="text" name="id" id="id" value="${user.id }" readonly>
				    <span class="icon is-small is-left">
				      <i class="fas fa-user"></i>
				    </span>
				    <span class="icon is-small is-right">
				      <i class="fas fa-check"></i>
				    </span>
				</div>
			</div>
			<div class="field">
				<label class="label">비밀번호 <em class="urs">＊</em></label>
				<p class="control has-icons-left">
				  <input class="input" type="password" name="ppw" id="ppw" value="${user.pw }" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" maxlength="16">
				  <input type="hidden" name="pw" id="pw" value="${user.pw }">
				  <span class="icon is-small is-left">
					<i class="fas fa-lock"></i>
				  </span>
				</p>
				<p class="pw_pt">비밀번호는 <strong>최소 8자리에서 최대 16자리까지<br> 숫자, 영문, 특수문자 각 1개 이상</strong> 포함되어야 합니다.</p>
			</div>
			<div class="field">
				<label class="label">비밀번호 확인 <em class="urs">＊</em></label>
				<p class="control has-icons-left">
				  <input class="input" type="password" name="ppw2" id="ppw2" value="${user.pw }" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" maxlength="16">
				  <span class="icon is-small is-left">
					<i class="fas fa-lock"></i>
				  </span>
				</p>
			</div>
			<div class="field">
				<label class="label">이름 <em class="urs">＊</em></label>
				<div class="control">
					<input class="input is-info" type="text" name="name" id="name" value="${user.name }">
				</div>
			</div>
			<div class="field">
				<label class="label">연락처 <em class="urs">＊</em></label>
				<div class="control">
			    <input class="input is-info" type="tel" name="tel" id="tel" value="${user.tel }">
				</div>
			</div>
			<div class="field">
				<label class="label">주소 <em class="urs">＊</em></label>
				<span style="display:block;">${user.address }</span>
				<input class="input is-info" type="hidden" name="address" id="address" value="${user.address }" />
				<input class="input is-info" type="text" name="address1" id="address1" placeholder="기본 주소 입력" class="form-control" /><br>
				<input class="input is-info" type="text" name="address2" id="address2" placeholder="상세 주소 입력" class="form-control" /><br>
				<input class="input is-info" type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" placeholder="우편번호" class="form-control">
				<button type="button" onclick="findAddr()" class="button is-link is-light">우편번호 검색</button>
			</div>
			<div class="field">
				<label class="label">가입일 <em class="cant">＊</em></label>
				<div class="control">
			    <input class="input is-info" type="text" name="regdate" id="regdate" value="${user.regdate }" readonly>
				</div>
			</div>
			<input type="submit" value="회원정보수정" class="button is-primary is-inverted"/>
			<a href="javascript:history.go(-1)" class="button is-link is-inverted">뒤로 가기</a>
		</form>
	</section>
</div>

<jsp:include page="/footer.jsp" />
		<script>
		function findAddr(){
			new daum.Postcode({
				oncomplete: function(data) {
					console.log(data);
					var roadAddr = data.roadAddress;
					var jibunAddr = data.jibunAddress;
					document.getElementById("postcode").value = data.zonecode;
					if(roadAddr !== '') {
						document.getElementById("address1").value = roadAddr;				
					} else if(jibunAddr !== ''){
						document.getElementById("address1").value = jibunAddr;
					}
					document.getElementById("address2").focus();
				}
			}).open();		
		}
		</script>
</body>
</html>