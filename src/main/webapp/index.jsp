<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>와우 멤버 웹</title>
	</head>
	<body>
		<jsp:include page="./header.html"></jsp:include>
		<h1>와우 멤버 웹!</h1>
		<h2>로그인 페이지</h2>
		<c:if test="${sessionScope.memberId ne null }">
			${sessionScope.memberName }님 환영합니다^^ <a href="/member/logout.do">로그아웃</a><br>
			<a href="/member/myInfo.do?member-id=${memberId }">마이페이지</a>
		</c:if>
		<c:if test="${memberId eq null }">	<!-- sessionScope. 생략 가능 -->
			<fieldset>
				<legend>로그인</legend>
				<form action="/member/login.do" method="post">
					<input type="text" name="member-id"><br>
					<input type="password" name="member-pw"><br>
					<div>
						<input type="submit" value="로그인">
						<input type="reset" value="취소">
						<a href="/member/enroll.jsp">회원가입</a>
					</div>
				</form>
			</fieldset>
		</c:if>
	</body>
</html>