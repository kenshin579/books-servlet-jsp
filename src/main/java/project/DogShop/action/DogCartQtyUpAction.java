package project.DogShop.action;

import project.DogShop.biz.CartBiz;
import project.DogShop.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DogCartQtyUpAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String kind = request.getParameter("kind");
        CartBiz cartBiz = new CartBiz();
        cartBiz.upCartQty(request, kind);

        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setUrl("dogCartList.dog");
        return forward;
    }
}
