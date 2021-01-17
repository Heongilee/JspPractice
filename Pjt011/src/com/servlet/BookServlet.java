package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.BookDAO;
import com.servlet.dto.BookDTO;

@WebServlet("/bs")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // 한글 처리
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	 
	  /*
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs = null;
	  
	  try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, id, pw);
      stmt = conn.createStatement();
      String sql = "SELECT * FROM BOOK";
      
      rs = stmt.executeQuery(sql);
      
      while(rs.next()) {
        int bookId = rs.getInt("book_id");
        String bookName = rs.getString("book_name");
        String bookLoc = rs.getString("book_loc");
        
        out.print("bookId : " + bookId + ", ");
        out.print("bookName : " + bookName + ", ");
        out.print("bookLoc : " + bookLoc + ", <br />");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    } // finally
	  */
	  
	  BookDAO bookDao = new BookDAO();
	  
	  ArrayList<BookDTO> list = bookDao.select();
	  
	  for (int i = 0;i < list.size();i++) {
	    BookDTO dto = list.get(i);
	    
	    int bookId = dto.getBookId();
	    String bookName = dto.getBookName();
	    String bookLoc = dto.getBookLoc();
	    
	    out.print("<p>bookId : "+ bookId +"</p>");
	    out.print("<p>bookName : "+ bookName +"</p>");
	    out.print("<p>bookLoc : "+ bookLoc +"</p> <br />");
	  }
	} // doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
