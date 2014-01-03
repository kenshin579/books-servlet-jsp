package dao; //���� dog.sql -> DOglistServlet

import java.sql.*; //DB�۾��Ұ��̴� sql����Ʈ
import java.util.ArrayList;
import java.util.List;

import vo.Dog;

import static util.DbUtil.*;

public class DogDao {
    private Connection con = null; //�� ���� ����� alt + shift + s ����� genarate constructor using fields

    public DogDao(Connection con) {
        super();
        this.con = con;
    }

    public List<Dog> getDogs() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Dog> dogs = null;

        try {
            String sql = "select * from dog";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            dogs = new ArrayList<Dog>(); //ArrayList??? ��ü�� ��´�???
            Dog dog = null;
            while (rs.next()) {
                dog = new Dog();
                dog.setId(rs.getInt("id"));
                dog.setKind(rs.getString("kind"));
                dog.setContent(rs.getString("content"));
                dog.setPrice(rs.getInt("price"));
                dog.setWeight(rs.getInt("weight"));
                dog.setHeight(rs.getInt("height"));
                dog.setImage(rs.getString("image"));
                dog.setCountry(rs.getString("country"));
                dog.setReadcount(rs.getInt("readcount"));
                dogs.add(dog);//dog�� ����
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return dogs;
    }

    public Dog getDog(String id) { //���ǰ����� ������ Ư�� id �� �˻��ҰŴϱ�. �˾ҳ�

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dog dog = null;

        try {
            String sql = "select * from dog where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id); //�ش���̵� �������ִ� ������ ������ �����ؿͶ�!
            rs = pstmt.executeQuery();

            if (rs.next()) { //�����Ͱ� �������� �ƴϱ� ������ �ѹ� ����ȴ�. �׷��� while�� �ƴ� if
                dog = new Dog();
                dog.setId(rs.getInt("id"));
                dog.setKind(rs.getString("kind"));
                dog.setContent(rs.getString("content"));
                dog.setPrice(rs.getInt("price"));
                dog.setWeight(rs.getInt("weight"));
                dog.setHeight(rs.getInt("height"));
                dog.setImage(rs.getString("image"));
                dog.setCountry(rs.getString("country"));
                dog.setReadcount(rs.getInt("readcount"));

                // dogs.add(dog); ���� �ʿ䰡 ���. �ѹ� ���Ŵϱ�. �׷��� if����ѰŰ�. ����?
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return dog;
    }

    public boolean updateReadcount(String id) {

        PreparedStatement pstmt = null;
        boolean result = false;

        try {
            String sql = "update dog set readcount = readcount+1 where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id); //�ش���̵� �������ִ� ������ ������ �����ؿͶ�!
            int count = pstmt.executeUpdate();

            if (count > 0) { //ī��Ʈ�����Ҵ��ϰ� ī��Ʈ���� 0���� ũ�� ����� ���� �ϳ� �̻��̶�� ��.
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
}


