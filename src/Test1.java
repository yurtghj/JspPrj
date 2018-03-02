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

@WebServlet("/test1")
public class Test1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();

		int result = 0;
		String result_ = req.getParameter("result");
		if (result_ != null && !result_.equals(""))
			result = Integer.parseInt(result_);

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		out.write("<form action=\"test1\" method=\"post\">");
		out.write("<div>");
		out.write("<label> x : <label>");
		out.write("<input type=\"text\" name=\"x\"> <br>");
		out.write("<label> y : <label>");
		out.write("<input type=\"text\" name=\"y\"> <br>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"덧셈\"/>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"application\"/>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"session\"/>");
		out.write("<input type=\"submit\" name=\"btn\" value=\"cookie\"/>");
		out.write("</div>");

		out.write("<div> result : ");
		out.printf("%d", result);
		out.write("<input type=\"hidden\" name=\"result\" value=\"" + result + "\" />");
		out.write("</div>");
		out.write("</form>");
		out.write("</div>");

		out.write("<div>");
		out.write("<a href=\"test2\"> 마이페이지 </a>");
		out.write("</div>");

		out.write("</body>");
		out.write("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset:UTF-8;");
		req.setCharacterEncoding("UTF-8");

		int x = 0;
		int y = 0;
		int result = 0;

		String btn = "덧셈";

		String x_ = req.getParameter("x");
		if (x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);

		String y_ = req.getParameter("y");
		if (y_ != null && !y_.equals(""))
			y = Integer.parseInt(y_);

		String btn_ = req.getParameter("btn");
		if (btn_ != null && !btn_.equals(""))
			btn = btn_;

		switch (btn) {
		case "덧셈":
			result = x + y;
			break;
		case "application": {
			ServletContext app = req.getServletContext();
			String result_ = req.getParameter("result");
			app.setAttribute("result", result_);
			break;
		}
		case "session": {
			HttpSession sess = req.getSession();
			String result_ = req.getParameter("result");
			sess.setAttribute("result", result_);
			break;
		}
		case "cookie":
			String result_ = req.getParameter("result");
			Cookie cookie = new Cookie("result",result_);
			cookie.setMaxAge(30);
			resp.addCookie(cookie);
			break;
		}

		resp.sendRedirect((String.format("test1?x=%d&y=%d&result=%d", x, y, result)));

	}

}
