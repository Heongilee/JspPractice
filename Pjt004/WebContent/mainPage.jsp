<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p> Hello, I'm mainPage. If you're looking at this page, you've designed it wrong.</p>
		<%
			response.sendRedirect("redirectPage.jsp");
		%>
	</body>
</html>