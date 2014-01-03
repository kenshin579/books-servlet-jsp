package biz;

import java.sql.*;

import static util.DbUtil.*;

import java.util.List;

import dao.DogDao;
import vo.Dog;

public class DogBiz {
    public List<Dog> getDogs() {
        Connection con = getConnection();//Ŀ�ؼ� ��ü�� ������ �Ѵ�
        DogDao dogDao = new DogDao(con);//DogdaoŬ���� ���ؾ��Ѵ�. dao�� ��Ű�� �����ϰ� ����
        List<Dog> dogs = dogDao.getDogs(); //Dogdao.java ���� ���Ŀ� ���� ��
        close(con);
        return dogs;
    }

    public Dog getDog(String id) { //���ǰ����� �� id���� �����°���. �� where���� ������ ��� ����

        Connection con = getConnection();//Ŀ�ؼ� ��ü�� ������ �Ѵ�
        DogDao dogDao = new DogDao(con);//DogdaoŬ���� ���ؾ��Ѵ�. dao�� ��Ű�� �����ϰ� ����
        Dog dog = dogDao.getDog(id); //Dogdao.java ���� ���Ŀ� ���� ��
        close(con);
        return dog;
    }

    public boolean updateReadcount(String id) {
        boolean result = false;
        Connection con = getConnection();//Ŀ�ؼ� ��ü�� ������ �Ѵ�
        DogDao dogDao = new DogDao(con);//DogdaoŬ���� ���ؾ��Ѵ�. dao�� ��Ű�� �����ϰ� ����
        result = dogDao.updateReadcount(id); //Dogdao.java ���� ���Ŀ� ���� ��
        if (result) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result;
    }
}

