package project.DogShop.controller;

import project.DogShop.action.*;
import project.DogShop.vo.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/project/DogShop/*.dog")
//@WebServlet("*.dog")
@WebServlet("/project/DogShop/doList.dog")
public class DogFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DogFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        // /project/boardWriteForm.bo
        String contextPath = request.getContextPath();
        // /project
        String command =
                requestURI.substring(contextPath.length());
        //  /boardWriteForm.bo

        Action action = null;
        //각 Action 객체 들의 구조를 정의하고 있는 인터페이스.
        //요청을 처리할 때 해당 요청을 처리할 Action 객체들을 하나씩 생성해서
        //해당 객체를 Action 인터페이스의 레퍼런스 변수로 참조함

        ActionForward forward = null;

        if (command.equals("/dogList.dog")) {
            action = new DogListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/dogView.dog")) {
            action = new DogViewAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/dogCartAdd.dog")) {
            action = new DogCartAddAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/dogCartList.dog")) {
            action = new DogCartListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/dogCartRemove.dog")) {
            action = new DogCartRemoveAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/dogCartQtyUp.dog")) {
            action = new DogCartQtyUpAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command.equals("/dogCartQtyDown.dog")) {
            action = new DogCartQtyDownAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getUrl());
            } else {
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(forward.getUrl());
                dispatcher.forward(request, response);
            }
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}
