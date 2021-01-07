<%request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mSignUp.jsp</title>
	</head>
	<body>
		<%!
			String mName;
			String mNickname;
		%>
		
		<%
			mName = request.getParameter("m_name");
			mNickname = request.getParameter("m_nickname");
		%>
		
		<p>이름 : <%=mName %></p> <br />
		<p>별명 : <%=mNickname %></p>
	</body>
</html>