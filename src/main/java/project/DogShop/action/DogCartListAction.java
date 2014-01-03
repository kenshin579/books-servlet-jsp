package project.DogShop.action;

import project.DogShop.biz.CartBiz;
import project.DogShop.vo.ActionForward;
import project.DogShop.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


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
