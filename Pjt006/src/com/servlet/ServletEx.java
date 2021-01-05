package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletEx extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // Servlet Parameter 가져오기.
	  String adminId = getServletConfig().getInitParameter("adminId");
	  String adminPw = getServletConfig().getInitParameter("adminPw");
	  
	  PrintWriter out = response.getWriter();
	  out.print("<p>adminId : "+ adminId +"</p>");
	  out.print("<p>adminId : "+ adminPw +"</p>");
	  
	  // context Parameter 가져오기.
	  String imgDir = getServletContext().getInitParameter("imgDir");
	  String testServerIP = getServletContext().getInitParameter("testServerIP");
	  
	  out.print("<p>imgDir : "+ imgDir +"</p>");
	  out.print("<p>testServerIP : "+ testServerIP + "</p>");
	  
	  // context attribute 설정하기.
	  getServletContext().setAttribute("connectedIP", "182.216.165.78");
	  getServletContext().setAttribute("connectedUser", "hong");
	  
	  out.print("<p>connectedIP : "+ (String) getServletContext().getAttribute("connectedIP") +"</p>");
	  out.print("<p>connectedUser : "+ (String) getServletContext().getAttribute("connectedUser") +"</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
