package chap3.Hangul;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HangulServlet
 */
@WebServlet("/chap3/Hangul/hangul")
public class HangulServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HangulServlet() {
        super();
    }

//    /**
//     * doGet 방법:
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String korName = HangulUtil.toKor(name);
//
//        response.setContentType("text/html;charset=euc-kr");
//        PrintWriter out = response.getWriter();
//        out.println("original = " + name);
//        out.println("hangul Process = " + korName);
//    }

//    /**
//     * doGet 두번째 방법: server.xml을 변경한다
//     * - Connector 태그에서 URIEncoding="euc-kr"를 추가한후 서버 재시작
//     *
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String korName = name;
//
//        response.setContentType("text/html;charset=euc-kr");
//        PrintWriter out = response.getWriter();
//        out.println("original = " + name);
//        out.println("hangul Process = " + korName);
//    }

//    /**
//     * doGet 세번째 방법: server.xml을 변경함
//     * - Connector 태그에서 useBodyEncodingForURI="true" 속성을 추가한후 서버
//     * 재시작
//     * - setCharacterEncoding("euc-kr")로 지정함
//     *
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("euc-kr");
//        String name = request.getParameter("name");
//        response.setContentType("text/html;charset=euc-kr");
//        PrintWriter out = response.getWriter();
//        out.println("hangul Process = " + name);
//    }

    /**
     * doPost 방식
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("euc-kr");
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out = response.getWriter();
        out.println("hangul Process = " + name);
    }
}
