package com.servlet.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class TempFilter implements Filter {
  
  // 필터가 사라질 때
  @Override
  public void destroy() {
    System.out.println("-- filter destroy() --");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    System.out.println("-- filter doFilter() --");
    
    //request filter
    request.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);
    
    
    //response filter
  }
  
  // 필터가 처음 생성될 때
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("-- filter init() --");
  }
  
}