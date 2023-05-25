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
<title>ADMIN - 게시글 작성</title>
<style>
</style>
</head>
<body>
<div class="container">
<jsp:include page="/header.jsp" />
	<table class="table">
		<tbody>
			<tr>
				<th>
					<label for="cate1">게시글 분류</label><br>
					<span id="bnotxt"></span>
				</th>
				<td>
					대분류 : 
				<div class="select is-info">
					<select id="cate1" name="cate1" class="form-control">
						<option value="">선택안함</option>
						<c:forEach items="${cateList }" var="cate1">
						<option value="${cate1.ct }">${cate1.cateGroup }</option>
						</c:forEach>	
					</select>
				</div>
					소분류 :
				<div class="select is-info">
					 
					<select id="cate" name="cate" class="form-control">
					<c:if test="${cate1.ct=='a0' }">
						<c:forEach items="${cateList2 }" var="cate2">
						<option value="${cate2.cateName }">${cate2.cateName }</option>
						</c:forEach>
					</c:if>
					</select><br>
					
				</div>
				</td>
			</tr>
			<tr>
				<th><label for="btitle">제목</label></th>
				<td>
				<input class="input is-primary" id="btitle" name="btitle" type="text" title="50글자 미만 작성" placeholder="50글자 미만으로 제목을 입력해주세요." maxlength="49" >
				</td>
			</tr>
			<tr>
				<th><label for="bcontent">내용</label></th>
				<td>
				<input class="input is-primary" id="bcontent" name="bcontent" type="text" title="1000글자 미만 작성" placeholder="1000글자 미만으로 내용을 입력해주세요." maxlength="999" >
				</td>
			</tr>
			<tr>
				<th><label for="address">주소</label></th>
				<td>
				<input class="input is-primary" id="address" name="address" type="text" title="100글자 미만 작성" placeholder="100글자 미만으로 주소를 입력해주세요." maxlength="99" >
				</td>
			</tr>
			<tr>
				<th><label for="tel">연락처</label></th>
				<td>
				<input class="input is-primary" id="tel" name="tel" type="tel" title="20글자 미만 작성" placeholder="20글자 미만으로 연락처를 입력해주세요." maxlength="19" >
				</td>
			</tr>
			<tr>
				<th><label for="pic1">게시글 이미지 첨부</label></th>
				<td>
					이미지 1 : <p id="picAttac1"></p><input type="file" accept="image/*" name="bpic1" id="bpic1" class="form-control file"><br>
					이미지 2 : <p id="picAttac2"></p><input type="file" accept="image/*" name="bpic2" id="bpic2" class="form-control file"><br>
					이미지 3 : <p id="picAttac3"></p><input type="file" accept="image/*" name="bpic3" id="bpic3" class="form-control file">
				</td>
			</tr>
		</tbody>
	</table>
<jsp:include page="/footer.jsp" />
</div>
<script>
		$(document).ready(function(){
			$("#bcontent").click(function(){
				if($(this).text()=="1000글자 미만 작성"){
					$(this).text("");
				}
			});
			$(".file").change(function(){
				var tar = $(this).index();
				if($(this).val()!=""){
					$(this).prev("p").html("<strong>이미지 첨부 섬공</strong>");
				}
			});
			$("#cate1").change(function(){
				if($("#cate1").val()==""){
					alert("대분류 카테고리를 선택하시기 바랍니다.");
					$("#cate1").focus();
					return;
				}
			})
		})
</script>
</body>
</html>