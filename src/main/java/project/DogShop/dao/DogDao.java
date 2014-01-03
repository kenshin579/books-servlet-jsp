package project.DogShop.dao;

import project.DogShop.vo.Dog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static project.DogShop.util.DbUtil.close;

public class DogDao {
    private Connection con = null;

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
            dogs = new ArrayList<Dog>();
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
                dogs.add(dog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return dogs;
    }

    public Dog getDog(String id) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dog dog = null;

        try {
            String sql = "select * from dog where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
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
            pstmt.setString(1, id);
            int count = pstmt.executeUpdate();

            if (count > 0) {
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