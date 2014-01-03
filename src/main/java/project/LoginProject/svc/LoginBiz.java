package project.LoginProject.svc;

import project.LoginProject.dao.LoginDao;
import project.LoginProject.vo.User;

import java.sql.Connection;

import static project.LoginProject.util.DbUtil.close;
import static project.LoginProject.util.DbUtil.getConnection;

/**
 * 비지니스 로직을 정의하는 자바 파일이 존재하는 패키지이다.
 */
public class LoginBiz {
    public User getUserLogin(String id, String passwd) {
        Connection con = getConnection();

        LoginDao loginDao = new LoginDao(con);
        User user = loginDao.getUserLogin(id, passwd);
        close(con);
        return user;
    }
}
