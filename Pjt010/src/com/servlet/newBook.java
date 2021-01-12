package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nB")
public class newBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  String bookName = request.getParameter("book_name");
	  String bookLoc = request.getParameter("book_loc");
	  
	  String driver = "oracle.jdbc.driver.OracleDriver";
	  String url = "jdbc:oracle:thin:@localhost:1521:xe";
	  String id = "C##SCOTT";
	  String pw = "TIGER";
	  
	  Connection conn = null;
	  Statement stmt = null;
	  
	  try {
      Class.forName(driver);
      
      conn = DriverManager.getConnection(url, id, pw);
      stmt = conn.createStatement();  // sql 쿼리 전송 객체 생성.
      String sql = "INSERT INTO BOOK(BOOK_ID, BOOK_NAME, BOOK_LOC)";
      sql += "VALUES (BOOK_SEQ.NEXTVAL, '" + bookName +"', '"+ bookLoc +"')";
      int result = stmt.executeUpdate(sql);
      
      if(result == 1) { // 정상 처리
        out.print("<p>INSERT SUCCESS!!</p>");
      } else { // 에러 발생
        out.print("<p>INSERT FAIL!!</p>");
      }
      
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
        
      } catch(Exception e2) {
        e2.printStackTrace();
      }
    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
