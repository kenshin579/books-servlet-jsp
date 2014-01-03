package project.DogShop.action;

import project.DogShop.biz.CartBiz;
import project.DogShop.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DogCartRemoveAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("EUC-KR");
        String[] kinds = request.getParameterValues("delete");

        CartBiz cartBiz = new CartBiz();
        cartBiz.removeCartItem(request, kinds);
        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setUrl("dogCartList.dog");
        return forward;
    }
}
