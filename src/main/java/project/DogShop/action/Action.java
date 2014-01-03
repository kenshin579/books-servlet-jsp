package project.DogShop.action;

import project.DogShop.vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
