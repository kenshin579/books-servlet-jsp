package project.DogShop.biz;

import project.DogShop.vo.Cart;
import project.DogShop.vo.Dog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CartBiz {

    public void addCart(HttpServletRequest request, Dog dog) {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");    //한 번만 만들기 위해서
        //목록 하나가 있는 cart 객체를 ArrayList 로 받아옴

        if (cartList == null) { //session에 존재하지 않을 때
            cartList = new ArrayList<Cart>();    // 객체 새로 생성
        }
        Cart cart = null;    //session 에 존재하면 초기화하고
        boolean newCart = true;
        for (int i = 0; i < cartList.size(); i++) {
            cart = cartList.get(i);
            if (dog.getKind().equals(cart.getKind())) {    //지금 선택한 상품이 카트 리스트에 있는지 kind 로 확인
                newCart = false;
                cart.setQty(cart.getQty() + 1);    // 지금 찾아진 카트 객체(cart) 상품이 있으면 수량만 증가
            }
        }

        if (newCart) {
            //추가되어 있지 않을 때 새로운 카트 객체 생성
            cart = new Cart();
            cart.setImage(dog.getImage());
            cart.setKind(dog.getKind());
            cart.setPrice(dog.getPrice());
            cart.setQty(1); //무조건 1이 들어감
            cartList.add(cart);
        }
        session.setAttribute("cartList", cartList);    //공유
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
