package intro;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class ServletTest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("euc-kr");

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        PrintWriter out = response.getWriter();
        out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
        out.write("<BODY><H1>");
        out.write("현재시각은 ");
        out.write(Integer.toString(hour));
        out.write("시 ");
        out.write(Integer.toString(minute));
        out.write("분 ");
        out.write(Integer.toString(second));
        out.write("초입니다.");
        out.write("</H1></BODY></HTML>");
        out.close();
    }
}
