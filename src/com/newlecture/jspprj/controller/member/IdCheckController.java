package com.newlecture.jspprj.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newlecture.jspprj.dao.jdbc.JdbcMemberDao;
import com.newlecture.jspprj.entity.Member;


@WebServlet("/member/idcheck")
public class IdCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String memberid = request.getParameter("id");
		PrintWriter out = response.getWriter();
		Member member = new JdbcMemberDao().get(memberid);
		
		Gson gson = new Gson();
		String json = gson.toJson(member);
		
		out.println(json);
		
	
	}
}
