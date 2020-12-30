<!-- 페이지 지시어 사용은 다음과 같이 쓰고 "이 페이지는 ~~ 하게 흘러 갑니다."라고 알려주는 부분. -->
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 지시어의 include 키워드를 통해 외부 jsp파일을 삽입할 수 있다... ① -->
		<%@ include file="Pjt003_1.jsp" %>
		
		<!-- 선언 태그를 사용해 마음껏 자바 언어의 멤버변수와 멤버함수를 사용할 수 있다. -->
		<%!
			int num = 10;
			String str = "jsp";
			ArrayList<String> list = new ArrayList<String>();
			
			public void jspMethod() {
			  System.out.println("Hello, jspMethod()");
			}
		%>
		
		<!-- Jsp 페이지에서 Java 코드를 넣을 수 있게 해주는 부분을 스크립틀릿 태그라고 한다. -->
		<%
			if(num > 0) {
		%>
		<p>num > 0</p>
		<%
			} else {
		%>
		<p>num <= 0</p>
		<%
			}
		%>
		
		<!-- 표현식 태그 사용은 다음과 같습니다. -->
		<p>num is <%= num %></p>
		
		<!-- 지시어의 include 키워드를 통해 외부 jsp파일을 삽입할 수 있다... ② -->
		<%@ include file="Pjt003_2.jsp" %>
		
		<%-- 외부 기관에서 제공하는 라이브러리 태그를 설정할 때 아래와 같이 사용합니다.
			<%@ taglib uri="주소" prefix="네임스페이스명" %>
		--%>  
		
		<!-- 여기서 부터는 jsp 주석 입니다. -->
		<%-- Hello Jsp world! --%>
	</body>
</html>