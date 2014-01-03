package action;

import javax.servlet.http.*;

import biz.CartBiz;
import biz.DogBiz;
import vo.ActionForward;
import vo.Dog;

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
