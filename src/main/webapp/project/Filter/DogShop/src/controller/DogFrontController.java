package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import vo.ActionForward;
import action.*;

@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DogFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String requestURI = request.getRequestURI();
        // /project/boardWriteForm.bo
        String contextPath = request.getContextPath();
        // /project
        String command =
                requestURI.substring(contextPath.length());
        //  /boardWriteForm.bo

        Action action = null;
        //�� Action ��ü ���� ������ �����ϰ� �ִ� �������̽�
        //��û�� ó���� �� �ش� ��û�� ó���� Action ��ü���� �ϳ��� ���ؼ�
        //�ش� ��ü�� Action �������̽��� ���۷��� ������ ������


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
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProcess(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProcess(request, response);
    }
}
