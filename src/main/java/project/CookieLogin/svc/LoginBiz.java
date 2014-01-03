package project.CookieLogin.svc;

import project.CookieLogin.dao.LoginDao;
import project.CookieLogin.vo.User;

import java.sql.Connection;

import static project.CookieLogin.util.DbUtil.close;
import static project.CookieLogin.util.DbUtil.getConnection;

public class LoginBiz {
    public User getUserLogin(String id, String passwd) {
        Connection con = getConnection();

        LoginDao loginDao = new LoginDao(con);
        User user = loginDao.getUserLogin(id, passwd);

        close(con);
        return user;
    }
}
