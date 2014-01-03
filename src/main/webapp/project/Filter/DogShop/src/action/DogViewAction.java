package action;

import javax.servlet.http.*;

import biz.DogBiz;
import vo.ActionForward;
import vo.Dog;

public class DogViewAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");//�켱 ID���� �޾ƾ��Ѵ�.
        DogBiz dogBiz = new DogBiz();
        boolean result = dogBiz.updateReadcount(id); //��ȸ�� ����

        Dog dog = dogBiz.getDog(id); //�˻������� �ο��ؼ� id���� �Ѱ��ش�
        Cookie cookie = new Cookie("image" + id, dog.getImage()); //Ŭ���̾�Ʈ���� �Ѿ�� ��Ű��ü �Ѿ�� ��
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        request.setAttribute("dog", dog);

        ActionForward forward = new ActionForward();
        forward.setUrl("dogView.jsp");
        return forward;
    }
}
