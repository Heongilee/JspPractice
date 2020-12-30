<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>main.jsp</title>
	</head>
	<body>
		<%! // 변수 선언부
			String adminId;
			String adminPw;
			
			String testServerIp;
			String realServerIp;
			String imgDir;
		%>
		<%	// 변수 초기화 (web.xml에 있는 init-param을 사용.)
			adminId = config.getInitParameter("adminId");
			adminPw = config.getInitParameter("adminPw");
		%>
		
		<% //변수 초기화 2
			testServerIp = application.getInitParameter("testServerIP");
			realServerIp = application.getInitParameter("realServerIP");
			imgDir = application.getInitParameter("imgDir");
		%>
		
		<% // application 객체 초기화
			application.setAttribute("ConnectedIP", "182.216.165.78");
			application.setAttribute("ConnectedUserName", "Heongi Lee");
		%>
		
		<%-- p태그를 이용해서 출력. --%>
		<p>adminId: <%=adminId %></p>
		<p>adminPw: <%=adminPw %></p>
		
		<%-- p태그를 이용해서 출력. 2 --%>
		<p>testServerIp : <%=testServerIp %></p>
		<p>realServerIp : <%=realServerIp %></p>
		<p>imgDir : <%=imgDir %></p>
		
		<%-- form 태그를 이용해서 위 application객체의 데이터를 확인해보기. --%>
		<form action="GetPage.jsp" method="get">
			<input type="submit" value="nextPage" />
		</form>
	</body>
</html>