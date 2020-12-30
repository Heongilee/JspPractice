<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GetPage.jsp</title>
	</head>
	<body>
		<%!
			String connectedIP;
			String connectedUserName;
		%>
		
		<%
			connectedIP = (String) application.getAttribute("ConnectedIP");
			connectedUserName = (String) application.getAttribute("ConnectedUserName");
		%>
		
		<p>My connectedIP is <%=connectedIP %></p>
		<p>And I'm <%=connectedUserName %></p>
		
		<% // out 객체 사용 예시
			out.print("<h1>hello Jsp World!!</h1>");
			out.print("<p>This is GetPage.jsp</p>");
		%>
	</body>
</html>