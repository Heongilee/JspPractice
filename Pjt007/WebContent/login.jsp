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
			Cookie[] cookies = request.getCookies();
			System.out.println("cookies: "+ cookies);
			
			if(cookies != null) {
			  for(Cookie c: cookies) {
			    // 이미 로그인 된 것으로 판단하고 로그인 완료 페이지로 리디렉션
			    if(c.getName().equals("memberId")) {
			      response.sendRedirect("loginOk.jsp");
			    }
			  }
			}
		%>
		
		<form action="loginConfig" method="get">
			ID: <input type="text" name="mID" /> <br />
			PW: <input type="password" name="mPW" /> <br />
			<input type="submit" value="login" />
		</form>
	</body>
</html>