package chap3.doGet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 * web.xml보다는 annotation 기반을 우선 제공하고 있으므로 @WebServlet("/login") 코드가 자동으로 생성됨
 * <p/>
 * Annotation의 장점
 * - 설정 내용을 설정 파일에서 따로 설정하지 않아도 됨
 * -설정 파일의 크기를 줄이거나 설정 파일 자체를 없앨 수 있음
 */
@WebServlet("/chap3/doGet/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String passwd = request.getParameter("passwd");

        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out = response.getWriter();
        out.println("아이디=" + id + "<br>");
        out.println("비밀번호=" + passwd + "<br>");
    }

}
