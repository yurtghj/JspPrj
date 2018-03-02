package com.newlecture.jspweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.dao.NoticeDao;
import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public class jdbcNoticeDao implements NoticeDao {
   
   public List<NoticeView> getList() {
	   
	   String sql = "SELECT * FROM NOTICE_VIEW";
	   
      // 드라이버 로드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         List<NoticeView> list = new ArrayList<>();
         
         while(rs.next()) { 
           Notice noticeview = new NoticeView(
	            		rs.getString("ID"),
	            		rs.getString("TITLE"),
	            		rs.getString("WRITER_ID"),
	            		rs.getString("CONTENT"),
	            		rs.getDate("REG_DATE"),
	            		rs.getInt("HIT"),
	            		rs.getString("WRITER_NAME"),
	            		rs.getString("COMMENT_CNT")
                     );
	            
            list.add((NoticeView) noticeview);
         }
         
         rs.close();
         st.close();
         con.close();
         
         return list;
         
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
   }
   
   @Override
   public Notice get(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Notice getPrev(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Notice getNext(String id) {
      // TODO Auto-generated method stub
      return null;
   }

@Override
public int Insert(Notice notice) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int Update(Notice notice) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int Delete(Notice notice) {
	// TODO Auto-generated method stub
	return 0;
}




/*return getList(1, "title", "");   
}

public List<NoticeView> getList(String query) {
return getList(1, "title", query);   
}

public List<NoticeView> getList(int page) {
return getList(page, "title", "");   
}

public List<NoticeView> getList(int page, String field, String query) {
String sql = "SELECT * FROM NOTICE";*/


}