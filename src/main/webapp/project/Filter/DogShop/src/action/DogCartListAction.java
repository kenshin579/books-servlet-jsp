package action;

import java.util.ArrayList;
import javax.servlet.http.*;

import biz.CartBiz;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        CartBiz cartBiz = new CartBiz();
        ArrayList<Cart> cartList = cartBiz.getCartList(request);
        int totalMoney = 0;
        for (int i = 0; i < cartList.size(); i++) {
            int money =
                    cartList.get(i).getPrice() * cartList.get(i).getQty();
            totalMoney += money;
        }
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("cartList", cartList);    //����
        ActionForward forward = new ActionForward();
        forward.setUrl("dogCartList.jsp");
        return forward;
    }

}
