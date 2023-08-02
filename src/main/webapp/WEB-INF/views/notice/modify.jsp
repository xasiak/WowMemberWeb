<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 수정</title>
	</head>
	<body>
		<h1>공지사항 수정</h1>
		<form action="/notice/modify.do" method="post">
<!-- 			수정할 때 hidden 많이 사용(사용자에게 보여줘야 하는 값과 내가 사용해야 할 값이 다를 때) -->
			<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
			<fieldset>
				<legend>공지사항 수정</legend>
				<ul>
					<li>
						<label>제목</label>
						<input type="text" id="" name="noticeSubject" value="${notice.noticeSubject }">
					</li>
					<li>
						<label>내용</label>
						<textarea rows="30" cols="40" id="" name="noticeContent" >${notice.noticeContent }></textarea>
					</li>
				</ul>
			</fieldset>
			<div>
				<input type="submit" value="수정">
				<input type="reset" value="초기화">
			</div>			
		</form>
	</body>
</html>