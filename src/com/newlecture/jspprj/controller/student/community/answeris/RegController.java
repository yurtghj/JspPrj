package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.Answeris;

//jsp는 요청할수x 요청은 controller에 매핑된 url

@WebServlet("/student/community/answeris/reg")
public class RegController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/reg.jsp");
		dispatcher.forward(request, response);*/

		request.getContextPath();
		
		ApplicationContext applicationContext = ServletUtil.getApplicationContext(request.getSession().getServletContext());
		TilesContainer container = TilesAccess.getContainer(applicationContext);
		ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
		container.render("student.community.answeris.reg", servletRequest);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathUrl = "/student/upload";
		
		String pathSystem = request.getServletContext().getRealPath(pathUrl);
		
		//System.out.println(pathSystem);
		
		File file = new File(pathSystem);
		
		//만들고자 하는 디렉토리의 상위 디렉토리가 없으면 상위 디렉토리까지 새로 생성
		if(!file.exists())
			file.mkdirs(); 
		
		Answeris answeris= new Answeris();
		//wrapping도구
		//MultipartRequest req = new MultipartRequest(request, pathSystem, 1024*1024*100, "UTF-8", new DefaultFileRenamePolicy());
		
/*		answeris.setTitle(req.getParameter("title"));
		answeris.setSituation(req.getParameter("situation"));
		
		answeris.setAttachedFile(req.getFilesystemName("attached"));*/
		
		
		//request.getParts();
		Part part = request.getPart("attached");
		InputStream is = part.getInputStream();
		
		byte buf[] = new byte[1024];
		FileOutputStream fos = new FileOutputStream(pathSystem);
		
		int size = 0;
		
		while((size = is.read(buf, 0, 1024)) != -1)
			fos.write(buf, 0, size);
		
		is.close();
		fos.close();
		
		
		answeris.setWriterId("sist7979");
		
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		answerisDao.insert(answeris);
		
		response.sendRedirect("list");
		
		
		
/*		Enumeration en = req.getFileNames();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement(); //키가 전달됨. 파일명이 아니라
			String fname = req.getOriginalFileName(key);
		}
*/
		
		
/*		answeris.setAttachedFile(req.getParameter("attached"));
		answeris.setWriterId("sist7979");

		AnswerisDao answerisDao = new JdbcAnswerisDao();
		answerisDao.insert(answeris);

		response.sendRedirect("list");*/
	}
}





