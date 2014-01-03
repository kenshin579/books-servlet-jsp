package project.DogShop.action;

import project.DogShop.biz.CartBiz;
import project.DogShop.biz.DogBiz;
import project.DogShop.vo.ActionForward;
import project.DogShop.vo.Dog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DogCartAddAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");
        DogBiz dogBiz = new DogBiz();
        Dog dog = dogBiz.getDog(id);

        CartBiz cartBiz = new CartBiz();
        cartBiz.addCart(request, dog);

        ActionForward forward = new ActionForward();
        forward.setUrl("dogCartList.dog");
        forward.setRedirect(true);
        return forward;
    }

}
