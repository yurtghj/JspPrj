package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Comment;

public class CommentDao {
	public List<Comment> getList() throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "SELECT * FROM NOTICE";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		 String id;
		 String content;
		 Date regdate;
		 String notice_Id;
		 
		 List<Comment> list = new ArrayList<>();
		 
		 	while(rs.next()) {
		 		id=rs.getString("ID");
		 		content=rs.getString("CONTENT");
		 		regdate=rs.getDate("REGDATE");
		 		notice_Id=rs.getString("NOTICE_ID");
		 		
		 		Comment comment = new Comment(id,content,regdate,notice_Id);
		 		list.add(comment);
		 	}
		 
			rs.close();
			st.close();
			con.close();
		
		return list;
		
	}
}
