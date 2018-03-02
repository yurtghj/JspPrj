package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspweb.entity.MemberRole;

public class MemberRoleDao {

	public List<MemberRole> getList() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "SELECT * FROM NOTICE";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		String member_Id;
		String role_Id;

		List<MemberRole> list = new ArrayList<>();

		while (rs.next()) {
			member_Id = rs.getString("MEMBER_ID");
			role_Id = rs.getString("ROLE_ID");

			MemberRole memberRole = new MemberRole(member_Id, role_Id);
			list.add(memberRole);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

}
