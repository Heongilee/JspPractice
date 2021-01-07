<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>formEx.jsp</title>
	</head>
	<body>
		<h3>Jsp to Servlet</h3>
		<form action="mSignUp" method="post">
			이름: <input type="text" name="m_name" /> <br />
			별명: <input type="text" name="m_nickname" /> <br />
			<input type="submit" value="sign up" />
		</form>
		<br />
		<br />
		<h3>Jsp to Jsp</h3>
		<form action="mSignUp.jsp" method="post">
			이름: <input type="text" name="m_name" /> <br />
			별명: <input type="text" name="m_nickname" /> <br />
			<input type="submit" value="sign up" />
		</form>
	</body>
</html>