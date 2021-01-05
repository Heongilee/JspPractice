package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginConfig")
public class loginConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	  
	  String mID = request.getParameter("mID");
	  String mPW = request.getParameter("mPW");
	  
	  out.print("mId: " + mID);
	  out.print("mPw: " + mPW);
	  
	  // 클라이언트 요청에 의해서 들어온 쿠키이므로 request객체에서 찾는 것이 맞다.
	  Cookie[] cookies = request.getCookies();
	  Cookie cookie = null;
	  
	  for(Cookie c : cookies) {
	    System.out.println("c.getName() : "+ c.getName() +", c.getValue() : "+ c.getValue());
	    
	    if(c.getName().equals("memberId")) {
	      cookie = c;
	    }
	  }
	  
	  // 쿠키가 없으면 새로 생성함.
	  if(cookie == null) {
	    System.out.println("cookie is null");
	    cookie = new Cookie("memberId", mID);
	  }
	  
	  response.addCookie(cookie);
	  cookie.setMaxAge(60 * 60); // 쿠키가 유효할 수 있는 만료 시간을 설정함 60*60=3600초=1시간
	  
	  // 응답객체로 다시 사용자에게 보냄.
	  response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
