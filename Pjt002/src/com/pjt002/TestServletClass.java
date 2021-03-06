package com.pjt002;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tsc")
public class TestServletClass extends HttpServlet {
  
  @PostConstruct
  public void PostConstruct() {
    System.out.println("-- @postConstructor() --");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("-- init() --");
  }
  
  // service는 잘 안쓰이고 대신 doGet()과 doPost()가 더 자주 쓰인다.
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
    
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  
	@Override
  public void destroy() {
	  System.out.println("-- destory() --");
  }
	
	@PreDestroy
	public void preDestroy() {
	  System.out.println("-- @preDestroy() --");
	}
}
