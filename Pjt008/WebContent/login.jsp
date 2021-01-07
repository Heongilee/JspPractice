<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<%
			// 세션 유무를 판단.
			if(session.getAttribute("memberId") != null) {
			  response.sendRedirect("loginOk.jsp");
			}
		%>
	
		<form action="logcon" method="post">
			ID : <input type="text" name="mID" /> <br />
			PW : <input type="password" name="mPW" /> <br />
			<input type="submit" value="로그인" />
		</form>
	</body>
</html>