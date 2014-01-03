package project.DogShop.action;

import project.DogShop.biz.DogBiz;
import project.DogShop.vo.ActionForward;
import project.DogShop.vo.Dog;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DogViewAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");//우선 ID 값을 받아야 한다.
        DogBiz dogBiz = new DogBiz();
        boolean result = dogBiz.updateReadcount(id); //조회수 증가

        Dog dog = dogBiz.getDog(id); //검색 조건을 부여해서 id 값을 넘겨준다
        Cookie cookie = new Cookie("image" + id, dog.getImage()); //클라이언트에서 넘어 온 쿠키 객체 넘어올 때
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        request.setAttribute("dog", dog);

        ActionForward forward = new ActionForward();
        forward.setUrl("dogView.jsp");
        return forward;
    }
}
