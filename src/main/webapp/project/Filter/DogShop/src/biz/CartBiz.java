package biz;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;
import vo.Dog;

public class CartBiz {

    public void addCart(HttpServletRequest request, Dog dog) {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");    //�ѹ� ����� ���ؼ�
        //����ϳ��� �ִ� cart ��ü�� ArrayList �� �޾ƿ�

        if (cartList == null) { //session �� �������� ���� ��
            cartList = new ArrayList<Cart>();    // ��ü ���� ��
        }
        Cart cart = null;    //session �� �����ϸ� �ʱ�ȭ�ϰ�
        boolean newCart = true;
        for (int i = 0; i < cartList.size(); i++) {
            cart = cartList.get(i);
            if (dog.getKind().equals(cart.getKind())) {    //���� ������ ��ǰ�� īƮ����Ʈ�� �ִ��� kind �� Ȯ��
                newCart = false;
                cart.setQty(cart.getQty() + 1);    // ���� ã���� īƮ��ü(cart)��ǰ�� ������ ������ ����
            }
        }

        if (newCart) {
            //�߰� �ȵ����� �� ���ο� īƮ��ü ��
            cart = new Cart();
            cart.setImage(dog.getImage());
            cart.setKind(dog.getKind());
            cart.setPrice(dog.getPrice());
            cart.setQty(1); //������ 1�� ��
            cartList.add(cart);
        }
        session.setAttribute("cartList", cartList);    //����
    }

    public ArrayList<Cart> getCartList(HttpServletRequest request) {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

        return cartList;
    }

    public void removeCartItem(HttpServletRequest request, String[] kinds) {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList =
                (ArrayList<Cart>) session.getAttribute("cartList");
        for (int i = 0; i < kinds.length; i++) {
            for (int j = 0; j < cartList.size(); j++) {
                if (kinds[i].equals(cartList.get(j).getKind())) {
                    cartList.remove(cartList.get(j));
                }
            }
        }

    }

    public void upCartQty(HttpServletRequest request, String kind) {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList =
                (ArrayList<Cart>) session.getAttribute("cartList");
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getKind().equals(kind)) {
                cartList.get(i).setQty(cartList.get(i).getQty() + 1);
            }
        }
    }

    public void downCartQty(HttpServletRequest request, String kind) {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList =
                (ArrayList<Cart>) session.getAttribute("cartList");
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getKind().equals(kind)) {

                cartList.get(i).setQty(cartList.get(i).getQty() - 1);
            }
        }
    }

}
