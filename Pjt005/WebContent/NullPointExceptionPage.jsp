<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>NullPointExceptionPage.jsp</title>
	</head>
	<body>
		<%!
			String str;
		%>
		
		<%
			out.print("str.toString() : " + str.toString());
		%>
	</body>
</html>