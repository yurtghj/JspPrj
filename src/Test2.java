import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test2")
public class Test2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset:UTF-8;");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		int app=0; int sess=0; int cookie=0;
		
		ServletContext application = req.getServletContext();
				
		String app_ = (String) application.getAttribute("result");
		if(app_!=null&&!app_.equals(""))
			app = Integer.parseInt(app_);
		
		HttpSession session = req.getSession();
		
		String sess_ = (String) session.getAttribute("result");
		if(sess_!=null&&!sess_.equals(""))
			sess = Integer.parseInt(sess_);
		
		Cookie[] cookies = req.getCookies();
		String c_ = "";
		
		for(Cookie c : cookies) {
			if(c.getName().equals("result")) {
				c_=c.getValue();
				break;
			}
		}
		
		cookie=Integer.parseInt(c_);
		
		out.write("<html>");
		out.write("<body>");
		out.write("<div> application : "+app+"</div>");
		out.write("<div> session : "+sess+"</div>");
		out.write("<div> cookie : "+cookie+"</div>");
		out.write("<div> <a href=\"test1\"> 계산하기 </a> : </div>");
		out.write("</body>");
		out.write("</html>");
		
		
	}
	
}
