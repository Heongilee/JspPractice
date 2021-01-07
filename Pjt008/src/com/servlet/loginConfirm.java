package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class loginConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	  String mID = request.getParameter("mID");
	  String mPW = request.getParameter("mPW");
	  
	  out.print("mId: "+ mID+"<br />");
	  out.print("mPw: "+ mPW+"<br />");
	  
	  HttpSession session = request.getSession();
	  session.setAttribute("memberId", mID);
	  
	  response.sendRedirect("loginOk.jsp");
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
