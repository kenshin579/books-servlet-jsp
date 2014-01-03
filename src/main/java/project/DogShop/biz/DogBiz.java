package project.DogShop.biz;

import project.DogShop.dao.DogDao;
import project.DogShop.vo.Dog;

import java.sql.Connection;
import java.util.List;

import static project.DogShop.util.DbUtil.*;

public class DogBiz {
    public List<Dog> getDogs() {
        Connection con = getConnection(); //커넥션 개체를 만들어야 한다
        DogDao dogDao = new DogDao(con); //Dogdao클래스 생성해야한다. dao로 패키지 지정하고 설정
        List<Dog> dogs = dogDao.getDogs(); //Dogdao.java 생성한 이후에 문장 생성
        close(con);
        return dogs;
    }

    public Dog getDog(String id) { //조건값으로 들어갈 id값을 던지는거임. 즉 where절을 삽입할 경우 성립

        Connection con = getConnection(); //커넥션 개체를 만들어야 한다
        DogDao dogDao = new DogDao(con); //Dogdao 클래스를 생성해야 한다. dao로 패키지 지정하고 설정
        Dog dog = dogDao.getDog(id); //Dogdao.java 생성한 이후에 문장 생성
        close(con);
        return dog;
    }

    public boolean updateReadcount(String id) {
        boolean result = false;
        Connection con = getConnection(); //커넥션 개체를 만들어야 한다
        DogDao dogDao = new DogDao(con); //Dogdao 클래스를 생성해야 한다. dao로 패키지 지정하고 설정
        result = dogDao.updateReadcount(id); //Dogdao.java 생성한 이후에 문장 생성
        if (result) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result;
    }
}

