<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error has occured...</title>
	</head>
	<body>
		<%
			response.setStatus(200);
			String msg = exception.getMessage();
		%>
		
		<h1>error Msg : <%=msg %></h1>
	</body>
</html>