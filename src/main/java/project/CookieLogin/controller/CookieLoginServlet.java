package project.CookieLogin.controller;

import project.CookieLogin.svc.LoginBiz;
import project.CookieLogin.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/project/CookieLogin/cookieLogin")
public class CookieLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CookieLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean loginSuccess = false;

        User user = null;
        if (cookies != null) {
            String id = null;
            String passwd = null;

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("id")) {
                    id = cookies[i].getValue();
                }
                if (cookies[i].getName().equals("passwd")) {
                    passwd = cookies[i].getValue();
                }
            }

            LoginBiz loginBiz = new LoginBiz();
            user = loginBiz.getUserLogin(id, passwd);
            if (user != null) {
                loginSuccess = true;
            }
        }

        if (loginSuccess) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("loginSuccess.jsp");
        } else {
            response.sendRedirect("login.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String passwd = request.getParameter("passwd");
        String cookie = request.getParameter("cookie");

        if (cookie != null) {
            Cookie idCookie = new Cookie("id", id);
            Cookie passwdCookie = new Cookie("passwd", passwd);

            //쿠키 생존기간을 설정 단위는 초임
            idCookie.setMaxAge(60 * 60 * 24);
            passwdCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(idCookie);
            response.addCookie(passwdCookie);
        }

        boolean loginSuccess = false;
        User user = null;
        LoginBiz loginBiz = new LoginBiz();
        user = loginBiz.getUserLogin(id, passwd);

        if (user != null) {
            loginSuccess = true;
        }

        if (loginSuccess) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("loginSuccess.jsp");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
