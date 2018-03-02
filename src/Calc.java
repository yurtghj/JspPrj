import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		int x=0; int y=0;
		
		String a = request.getParameter("x");
		if(a != null && !a.equals(""))
		x = Integer.parseInt(a);
		String b = request.getParameter("y");
		if(b != null && !b.equals(""))
		y = Integer.parseInt(b);
	
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>Insert title here</title>");
			out.write("</head>");
			out.write("<body>");
			out.write("<form action=\"calc\">");
			out.write("x:<input type=\"text\" name=\"x\"><br>");
			out.write("y:<input type=\"text\" name=\"y\"><br>");
			out.write("<input id=\"btn-submit\" type=\"submit\" value=\"덧셈\" name=\"add\"/>");
			out.write("<input id=\"btn2-submit\" type=\"submit\" value=\"application\"/>");
			out.write("<input id=\"btn3-submit\" type=\"submit\" value=\"session\"/>");
			out.write("<input id=\"btn4-submit\" type=\"submit\" value=\"cookie\"/>");
			out.write("<div> result : ");
			out.println(x+y);
			out.write("</div>");
			out.write("</form>");
			out.write("</body>");
			out.write("</html>");			
	}
	
}
