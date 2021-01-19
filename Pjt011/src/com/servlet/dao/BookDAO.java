package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.dto.BookDTO;

public class BookDAO {
//  String driver = "oracle.jdbc.driver.OracleDriver";
//  String url = "jdbc:oracle:thin:@localhost:1521:xe";
//  String id = "C##SCOTT";
//  String pw = "TIGER";
  DataSource dataSource;
  
  public BookDAO() {
    try {
      Context context = new InitialContext();
      dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle18g");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
  
  public ArrayList<BookDTO> select() {
    ArrayList<BookDTO> list = new ArrayList<BookDTO>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
//      conn = DriverManager.getConnection(url, id, pw);
      conn = dataSource.getConnection();
      String sql = "SELECT * FROM BOOK";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        int bookId = rs.getInt("book_id");
        String bookName = rs.getString("book_name");
        String bookLoc = rs.getString("book_loc");
                
        BookDTO bookDto = new BookDTO(bookId, bookName, bookLoc);
        list.add(bookDto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // dealloc resource
      try {
        if(rs != null) rs.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    } // finally
    return list;
  } // select()
}
